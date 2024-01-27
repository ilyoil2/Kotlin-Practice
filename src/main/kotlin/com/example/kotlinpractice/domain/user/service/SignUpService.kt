package com.example.kotlinpractice.domain.user.service

import com.example.kotlinpractice.domain.user.domain.User
import com.example.kotlinpractice.domain.user.domain.repository.UserRepository
import com.example.kotlinpractice.domain.user.domain.type.Role
import com.example.kotlinpractice.domain.user.exception.UserAlreadyExistsException
import com.example.kotlinpractice.domain.user.presentation.request.SignUpRequest
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class SignUpService (
        private val userRepository: UserRepository,
){


    @Transactional
    fun execute(request: SignUpRequest) {

        if (userRepository.existsByEmail(request.email)){
            throw UserAlreadyExistsException
        }

        val currentUser: User = userRepository.save(
                User(
                        id = 0,
                    username = request.username,
                        email = request.email,
                    role = Role.USER,
                    profileImageUrl = "kang"
                )
        )


    }

}
