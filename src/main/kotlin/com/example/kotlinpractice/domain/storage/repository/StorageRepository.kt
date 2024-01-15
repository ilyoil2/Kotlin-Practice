package com.example.kotlinpractice.domain.storage.repository

import com.example.kotlinpractice.domain.storage.entity.Storage
import com.example.kotlinpractice.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface StorageRepository : JpaRepository<Storage, Long> {

    fun findStorageByUser(user: User) : Storage

}