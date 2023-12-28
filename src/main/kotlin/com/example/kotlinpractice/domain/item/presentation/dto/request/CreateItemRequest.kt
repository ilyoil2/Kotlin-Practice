package com.example.kotlinpractice.domain.item.presentation.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CreateItemRequest(

        @field:NotBlank
        @field:Size(max = 20)
        val itemName: String,

        @field:NotBlank
        @field:Size(max = 40)
        val email: String
)
