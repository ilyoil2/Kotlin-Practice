package com.example.kotlinpractice.domain.user.domain

import com.example.kotlinpractice.global.entity.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity

@Entity
class User(
        id : Long,

        @Column(columnDefinition = "VARCHAR(10)", nullable = false)
        val accountId: String,

        @Column(columnDefinition = "CHAR(60)", nullable = false)
        val password: String,

        @Column(columnDefinition = "VARCHAR(50)", nullable = false)
        val email: String,

) : BaseEntity(id)
