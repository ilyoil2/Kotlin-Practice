package com.example.kotlinpractice.domain.item.facade

import com.example.kotlinpractice.domain.item.domain.Item
import com.example.kotlinpractice.domain.item.domain.repository.ItemRepository
import org.springframework.stereotype.Component

@Component
class ItemFacade (
        private val itemRepository: ItemRepository
) {
    fun getItem(): Item {
        val
    }
}