package com.example.kotlinpractice.domain.user.presentation.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class SignUpRequest(

        @field:NotBlank
        @field:Size(max = 10)
        val username: String,


        @field:NotBlank
        @field:Size(max = 40)
        val email: String
)