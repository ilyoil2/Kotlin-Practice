package com.example.kotlinpractice.domain.item.service

import com.example.kotlinpractice.domain.item.domain.Item
import com.example.kotlinpractice.domain.item.domain.repository.ItemRepository
import com.example.kotlinpractice.domain.user.domain.User
import com.example.kotlinpractice.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class DeleteItemService(
        private val itemRepository: ItemRepository,
) {
    @Transactional
    fun execute(itemId : Long) {

        val item: Item = itemRepository.findItemById(itemId)

        itemRepository.delete(item)
    }

}
