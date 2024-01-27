package com.example.kotlinpractice.global.security.auth

import com.example.kotlinpractice.domain.user.domain.User
import com.example.kotlinpractice.domain.user.domain.repository.UserRepository
import com.example.kotlinpractice.domain.user.exception.UserNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class AuthDetailsService(
    private val userRepository: UserRepository
): UserDetailsService {

    override fun loadUserByUsername(email: String): UserDetails {
        val user: User = userRepository.findByEmail(email) ?: throw UserNotFoundException
        return AuthDetails(user)
    }

}