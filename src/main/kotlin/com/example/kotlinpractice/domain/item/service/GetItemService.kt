package com.example.kotlinpractice.domain.item.service

import com.example.kotlinpractice.domain.item.domain.repository.ItemRepository
import com.example.kotlinpractice.domain.item.facade.ItemFacade
import com.example.kotlinpractice.domain.item.presentation.dto.response.GetItemResponse
import org.springframework.stereotype.Service

@Service
class GetItemService (
        private val itemRepository: ItemRepository,
        private val itemFacade: ItemFacade
) {
    fun execute() : GetItemResponse {

        return GetItemResponse(
                itemName = "fs",
                itemCounts = 12
        )
    }
}