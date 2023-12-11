package com.example.kotlinpractice.domain.user.domain.repository

import com.example.kotlinpractice.domain.user.domain.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long>{

    fun existsByAccountId(accountId: String) : Boolean

    fun findByAccountId(accountId: String) : User?

}