package com.example.kotlinpractice.domain.storage.service

import com.example.kotlinpractice.domain.item.domain.Item
import com.example.kotlinpractice.domain.item.domain.repository.ItemRepository
import com.example.kotlinpractice.domain.storage.entity.Storage
import com.example.kotlinpractice.domain.storage.repository.StorageRepository
import com.example.kotlinpractice.domain.user.domain.User
import com.example.kotlinpractice.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class ItemStorageService (
        private val itemRepository: ItemRepository,
        private val userFacade: UserFacade,
        private val storageRepository: StorageRepository
) {

    fun execute(itemId: Long) {

        val currentUser : User =  userFacade.getCurrentUser()
        val item : Item = itemRepository.findItemById(itemId)
        val storage : Storage = storageRepository.findStorageByUser(user = currentUser)

        storage.addItem(item)

    }

}
