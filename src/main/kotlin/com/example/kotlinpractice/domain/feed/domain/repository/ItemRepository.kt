package com.example.kotlinpractice.domain.feed.domain.repository

import com.example.kotlinpractice.domain.feed.domain.Item
import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository : JpaRepository<Item, Long> {

    fun existsByItemName(itemName: String) : Boolean

}