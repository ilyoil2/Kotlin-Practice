package com.example.kotlinpractice.domain.feed.facade

import com.example.kotlinpractice.domain.feed.domain.Item
import com.example.kotlinpractice.domain.feed.domain.repository.ItemRepository
import org.springframework.stereotype.Component

@Component
class ItemFacade (
        private val itemRepository: ItemRepository;
) {
    fun getItem(): Item {
        val
    }
}