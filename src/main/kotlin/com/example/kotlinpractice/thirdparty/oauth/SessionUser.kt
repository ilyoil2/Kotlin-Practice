package com.example.kotlinpractice.thirdparty.oauth

import com.example.kotlinpractice.domain.user.domain.User
import java.io.Serializable

data class SessionUser(
    private val user: User
): Serializable {
    val username = user.username
    val email = user.email
    val profileImageUrl = user.profileImageUrl
}