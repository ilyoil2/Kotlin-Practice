package com.example.kotlinpractice.global.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.example.kotlinpractice.global.security.jwt.JwtTokenProvider
import com.example.kotlinpractice.thirdparty.oauth.CustomOAuth2UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
@Configuration
class SecurityConfig(
        private val jwtTokenProvider: JwtTokenProvider,
        private val objectMapper: ObjectMapper,
        private val customOAuth2UserService: CustomOAuth2UserService
) {

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {

        http
            .cors().and()
            .csrf().disable()
            .formLogin().disable()

        http.sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        http.apply(FilterConfig(jwtTokenProvider, objectMapper))

        http.logout()
            .logoutSuccessUrl("/")

        http.oauth2Login()
            .userInfoEndpoint()
            .userService(customOAuth2UserService)

        return http.build()
    }

}
