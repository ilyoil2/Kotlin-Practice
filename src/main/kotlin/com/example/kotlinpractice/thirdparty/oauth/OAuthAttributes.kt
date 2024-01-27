package com.example.kotlinpractice.thirdparty.oauth

import com.example.kotlinpractice.domain.user.domain.User
import com.example.kotlinpractice.domain.user.domain.type.Role

data class OAuthAttributes (
    val attributes: Map<String, Any>,
    val nameAttributeKey: String,
    val name: String,
    val email: String,
    val picture: String,
) {
    companion object {
        fun of(
            registrationId: String,
            userNameAttributeName: String,
            attributes: Map<String, Any>
        ): OAuthAttributes {
            return OAuthAttributes(
                name = attributes["name"] as String,
                email = attributes["email"] as String,
                picture = attributes["picture"] as String,
                attributes = attributes,
                nameAttributeKey = userNameAttributeName
            )
        }
    }
}
fun OAuthAttributes.toEntity(): User {
    return User(
        id = 0,
        username = name,
        email = email,
        profileImageUrl = picture,
        role = Role.USER
    )
}