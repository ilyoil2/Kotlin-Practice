package com.example.kotlinpractice.domain.item.service

import com.example.kotlinpractice.domain.item.domain.repository.ItemRepository
import com.example.kotlinpractice.domain.item.presentation.dto.response.ItemResponse
import org.springframework.stereotype.Service

@Service
class QueryItemListService (
        private val itemRepository: ItemRepository,
) {
    fun execute() : ItemResponse {

        return ItemResponse(
                itemName = "fs",
                itemCounts = 12
        )
    }
}