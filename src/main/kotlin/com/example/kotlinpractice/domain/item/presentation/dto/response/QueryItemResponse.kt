package com.example.kotlinpractice.domain.item.presentation.dto.response

import com.example.kotlinpractice.domain.item.domain.Item

data class QueryItemResponse(
        val id: Long,
        val itemName: String,
        val itemCount: Int
) {
    constructor(item: Item): this(
            id = item.id,
            itemName = item.itemName,
            itemCount = item.itemCounts
    )
}
