package com.example.kotlinpractice.domain.item.service

import com.example.kotlinpractice.domain.item.domain.Item
import com.example.kotlinpractice.domain.item.domain.repository.ItemRepository
import com.example.kotlinpractice.domain.item.presentation.dto.response.ItemResponse
import org.springframework.stereotype.Service
import java.util.UUID
import javax.transaction.Transactional

@Service
class QueryItemService (
        private val itemRepository: ItemRepository,
)
{
    @Transactional
    fun execute(itemId : UUID) : ItemResponse {
        val item: Item = itemRepository.findById(itemId)

        return ItemResponse(
                itemName = item.itemName,
                itemCounts = item.itemCounts
        )
    }

}
