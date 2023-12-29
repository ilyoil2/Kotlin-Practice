package com.example.kotlinpractice.domain.item.presentation.dto.request

import javax.validation.constraints.NotBlank

data class ModifyItemCountRequest(

        @field:NotBlank
        val itemCount: Int
)
