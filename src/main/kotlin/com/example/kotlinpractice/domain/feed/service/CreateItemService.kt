package com.example.kotlinpractice.domain.feed.service

import com.example.kotlinpractice.domain.feed.domain.Item
import com.example.kotlinpractice.domain.feed.domain.repository.ItemRepository
import com.example.kotlinpractice.domain.feed.exception.ItemAlreadyExistsException
import com.example.kotlinpractice.domain.feed.presentation.dto.request.CreateItemRequest
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class CreateItemService (
        private val itemRepository: ItemRepository
) {

    @Transactional
    fun execute(request: CreateItemRequest) {

        if (itemRepository.existsByItemName(request.itemName))
            throw ItemAlreadyExistsException

        itemRepository.save(
                Item(
                        id = null,
                        itemName = request.itemName,
                        itemCounts = request.itemCounts
                )
        )
    }
}