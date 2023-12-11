package com.example.kotlinpractice.global.security.auth

import com.example.kotlinpractice.domain.user.domain.User
import com.example.kotlinpractice.domain.user.domain.repository.UserRepository
import com.example.kotlinpractice.domain.user.exception.UserNotFoundException
import com.study.kotlkotlin.global.security.auth.AuthDetails
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthDetailsService(
    private val userRepository: UserRepository
): UserDetailsService {

    override fun loadUserByUsername(accountId: String): UserDetails {
        val user: User = userRepository.findByAccountId(accountId) ?: throw UserNotFoundException
        return AuthDetails(user)
    }

}