package com.example.kotlinpractice.domain.user.service

import com.example.kotlinpractice.domain.user.domain.User
import com.example.kotlinpractice.domain.user.domain.repository.UserRepository
import com.example.kotlinpractice.domain.user.exception.UserAlreadyExistsException
import com.example.kotlinpractice.domain.user.presentation.request.SignUpRequest
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
class SignUpService (
        private val userRepository: UserRepository,
){

    @Transactional
    fun execute(request: SignUpRequest) {

        if (userRepository.existsByAccountId(request.accountId)){
            throw UserAlreadyExistsException
        }

        userRepository.save(
                User(
                        id = 0,
                        accountId = request.accountId,
                        password = request.password,
                        email = request.email
                )
        )
    }

}
