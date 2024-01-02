package com.example.kotlinpractice.domain.storage.entity

import com.example.kotlinpractice.domain.item.domain.Item
import com.example.kotlinpractice.domain.user.domain.User
import com.example.kotlinpractice.global.entity.BaseEntity
import javax.persistence.*

@Entity
class Storage(
        id: Long,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)")
        val user: User,

        @OneToMany(mappedBy = "storage", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        val itemList: MutableList<Item> = mutableListOf()

) : BaseEntity(id) {

        fun addItem(item: Item) {
                itemList.add(item)
        }
}