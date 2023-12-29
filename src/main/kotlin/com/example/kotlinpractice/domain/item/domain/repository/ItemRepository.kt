package com.example.kotlinpractice.domain.item.domain.repository

import com.example.kotlinpractice.domain.item.domain.Item
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ItemRepository : JpaRepository<Item, Long> {

    fun existsByItemName(itemName: String) : Boolean

    fun deleteItemById(id: Long)

    fun findItemById(id: Long) : Item
}
