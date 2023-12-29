package com.example.kotlinpractice.domain.item.service

import com.example.kotlinpractice.domain.item.domain.Item
import com.example.kotlinpractice.domain.item.domain.repository.ItemRepository
import com.example.kotlinpractice.domain.item.presentation.dto.request.ModifyItemCountRequest
import org.springframework.stereotype.Service

@Service
class ModifyItemCountService(
        private val itemRepository: ItemRepository,
) {

    fun execute(itemId: Long, request: ModifyItemCountRequest) {
        val item: Item = itemRepository.findItemById(itemId)

        item.itemCounts = request.itemCount
    }

}