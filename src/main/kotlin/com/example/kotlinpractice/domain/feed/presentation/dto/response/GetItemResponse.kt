package com.example.kotlinpractice.domain.feed.presentation.dto.response

import javax.validation.constraints.NotNull

data class GetItemResponse (

        @field:NotNull
        val itemName: String,

        @field:NotNull
        val itemCounts: Long

)

