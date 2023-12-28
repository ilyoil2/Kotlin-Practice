package com.example.kotlinpractice.domain.item.service

import com.example.kotlinpractice.domain.item.exception.ItemAlreadyExistsException
import com.example.kotlinpractice.domain.item.domain.Item
import com.example.kotlinpractice.domain.item.domain.repository.ItemRepository
import com.example.kotlinpractice.domain.item.presentation.dto.request.CreateItemRequest
import org.springframework.stereotype.Service
import java.util.*
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
                        id = 0,
                        itemName = request.itemName,
                        itemCounts = request.itemCounts
                )
        )
    }
}