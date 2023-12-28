package com.example.kotlinpractice.domain.item.service

import com.example.kotlinpractice.domain.item.domain.Item
import com.example.kotlinpractice.domain.item.domain.repository.ItemRepository
import com.example.kotlinpractice.domain.user.domain.User
import com.example.kotlinpractice.domain.user.facade.UserFacade
import io.lettuce.core.KillArgs.Builder.user
import org.springframework.stereotype.Service
import java.util.UUID
import javax.transaction.Transactional

@Service
class DeleteItemService(
        private val itemRepository: ItemRepository,
        private val userFacade: UserFacade
) {
    @Transactional
    fun execute(itemId : Long) {
        val user: User = userFacade.getCurrentUser()

        val item: Item = itemRepository.findById(itemId)

        itemRepository.delete(item)
    }

}
