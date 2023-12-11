package com.example.kotlinpractice.domain.user.domain

import com.example.kotlinpractice.global.entity.BaseEntity
import com.sun.istack.NotNull
import javax.persistence.Column
import javax.persistence.Entity

@Entity
class User(
        id : Long?,

        @field:NotNull
        @Column(columnDefinition = "VARCHAR(10)")
        val accountId: String,

        @field:NotNull
        @Column(columnDefinition = "CHAR(60)")
        val password: String,

        @field:NotNull
        @Column(columnDefinition = "VARCHAR(50)")
        val email: String,

) : BaseEntity(id)