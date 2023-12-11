package com.example.kotlinpractice.domain.feed.service

import com.example.kotlinpractice.domain.feed.domain.Item
import com.example.kotlinpractice.domain.feed.domain.repository.ItemRepository
import com.example.kotlinpractice.domain.feed.presentation.dto.response.GetItemResponse
import org.springframework.stereotype.Service

@Service
class GetItemService (
        private val itemRepository: ItemRepository
) {
    fun execute() : GetItemResponse {
        val item: Item = itemFacade.getCurrentUser()

        return GetItemResponse(
                itemName = re
        )
    }
}