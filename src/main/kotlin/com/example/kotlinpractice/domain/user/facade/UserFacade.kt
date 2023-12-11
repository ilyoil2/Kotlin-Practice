package com.example.kotlinpractice.domain.user.facade

import com.example.kotlinpractice.domain.user.domain.User
import com.example.kotlinpractice.domain.user.domain.repository.UserRepository
import com.example.kotlinpractice.domain.user.exception.UserNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade (
        private val userRepository: UserRepository
) {

    fun getCurrentUser(): User {
        val id = SecurityContextHolder.getContext().authentication.name.toLong()
        return userRepository.findByIdOrNull(id) ?: throw UserNotFoundException
    }

}