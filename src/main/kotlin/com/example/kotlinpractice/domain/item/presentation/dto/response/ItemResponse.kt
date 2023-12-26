package com.example.kotlinpractice.domain.item.presentation.dto.response

import javax.validation.constraints.NotNull

data class ItemResponse (

        @field:NotNull
        val itemName: String,

        @field:NotNull
        val itemCounts: Long

)

