package com.example.kotlinpractice.domain.user.domain

import com.example.kotlinpractice.domain.user.domain.type.Role
import com.example.kotlinpractice.global.entity.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated

@Entity
class User(
        id : Long,

        @Column(columnDefinition = "VARCHAR(300)")
        var profileImageUrl: String,

        @Column(columnDefinition = "VARCHAR(10)", nullable = false)
        var username: String,

        @Column(columnDefinition = "VARCHAR(50)", nullable = false)
        val email: String,

        @Enumerated(EnumType.STRING)
        val role: Role

) : BaseEntity(id)
