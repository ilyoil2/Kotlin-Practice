package com.example.kotlinpractice.domain.user.service

import com.example.kotlinpractice.domain.storage.entity.Storage
import com.example.kotlinpractice.domain.storage.repository.StorageRepository
import com.example.kotlinpractice.domain.user.domain.User
import com.example.kotlinpractice.domain.user.domain.repository.UserRepository
import com.example.kotlinpractice.domain.user.exception.UserAlreadyExistsException
import com.example.kotlinpractice.domain.user.presentation.request.SignUpRequest
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class SignUpService (
        private val userRepository: UserRepository,
        private val storageRepository: StorageRepository
){

    @Transactional
    fun execute(request: SignUpRequest) {

        if (userRepository.existsByAccountId(request.accountId)){
            throw UserAlreadyExistsException
        }

        val currentUser: User = userRepository.save(
                User(
                        id = 0,
                        accountId = request.accountId,
                        password = request.password,
                        email = request.email
                )
        )

        storageRepository.save(
                Storage(
                        id = 0,
                        user = currentUser
                )
        )

    }

}
