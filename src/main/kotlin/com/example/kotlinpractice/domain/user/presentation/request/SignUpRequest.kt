package com.example.kotlinpractice.domain.user.presentation.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class SignUpRequest(

        @field:NotBlank
        @field:Size(max = 10)
        val accountId: String,

        @field:NotBlank
        @field:Size(max = 25)
        val password: String,

        @field:NotBlank
        @field:Size(max = 40)
        val email: String
)