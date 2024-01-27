package com.example.kotlinpractice.thirdparty.oauth

import com.example.kotlinpractice.domain.user.domain.User
import com.example.kotlinpractice.domain.user.domain.repository.UserRepository
import com.example.kotlinpractice.domain.user.domain.type.Role
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService
import org.springframework.security.oauth2.core.OAuth2AuthenticationException
import org.springframework.security.oauth2.core.user.DefaultOAuth2User
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Service
import javax.servlet.http.HttpSession

@Service
class CustomOAuth2UserService(
    private val userRepository: UserRepository,
    private val httpSession: HttpSession
): OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    override fun loadUser(userRequest: OAuth2UserRequest?): OAuth2User {
        if (userRequest == null) throw OAuth2AuthenticationException("Error")

        val delegate = DefaultOAuth2UserService()
        val oAuth2User = delegate.loadUser(userRequest)

        // registrationId는 로그인 진행중인 서비스 코드
        // 구글, 네이버, 카카오등을 구분하는 것이기에 현재는 사실 필요없음
        val registrationId = userRequest.clientRegistration.registrationId
        // OAuth2 로그인 진행시 키가 되는 필드값
        val userNameAttributeName = userRequest.clientRegistration.providerDetails.userInfoEndpoint.userNameAttributeName

        // OAuth2User의 attribute가 된다.
        // 추후 다른 소셜 로그인도 이 클래스를 쓰게 될 것이다.
        val attributes = OAuthAttributes.of(
            registrationId,
            userNameAttributeName,
            oAuth2User.attributes
        )

        // 전달받은 OAuth2User의 attribute를 이용하여 회원가입 및 수정의 역할을 한다.
        // User Entity 생성 : 회원가입
        // User Entity 수정 : update
        val user = saveOrUpdate(attributes)

        // session에 SessionUser(user의 정보를 담는 객체)를 담아 저장한다.
        httpSession.setAttribute("user", SessionUser(user))

        return DefaultOAuth2User(
            setOf(SimpleGrantedAuthority(user.role.key)),
            attributes.attributes,
            attributes.nameAttributeKey
        )
    }

    fun saveOrUpdate(attributes: OAuthAttributes): User {
        val existingUser = userRepository.findByEmail(attributes.email)

        return if (existingUser != null) {
            // 이미 존재하는 사용자의 경우 정보 업데이트
            existingUser.apply {
                username = attributes.name
                profileImageUrl = attributes.picture
                // 다른 필요한 프로퍼티들도 여기에 추가
            }
        } else {
            // 존재하지 않는 사용자의 경우 새로운 객체 생성
            User(
                id = 0,
                username = attributes.name,
                email = attributes.email,
                profileImageUrl = attributes.picture,
                role = Role.USER
                // 다른 필요한 프로퍼티들도 여기에 추가
            )
        }.let {
            userRepository.save(it)
        }
    }

}