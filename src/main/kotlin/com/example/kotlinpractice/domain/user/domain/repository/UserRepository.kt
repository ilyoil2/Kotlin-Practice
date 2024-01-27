package com.example.kotlinpractice.domain.user.domain.repository

import com.example.kotlinpractice.domain.user.domain.User
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface UserRepository : CrudRepository<User, Long>{

    fun findByEmail(email: String) : User?

    fun existsByEmail(email: String) : Boolean
}