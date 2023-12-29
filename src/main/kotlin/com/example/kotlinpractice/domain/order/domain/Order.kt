package com.example.kotlinpractice.domain.order.domain

import com.example.kotlinpractice.domain.item.domain.Item
import com.example.kotlinpractice.domain.order.domain.type.OrderType
import com.example.kotlinpractice.domain.user.domain.User
import com.example.kotlinpractice.global.entity.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Order (

        id: Long,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)")
        val user: User,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "item_id", columnDefinition = "BINARY(16)")
        val item: Item,

        @Column(columnDefinition = "VAECHAR(255)", nullable = false)
        val orderedItemName: String,

        @Column(columnDefinition = "INT", nullable = false)
        val orderedItemCounts: Int,

        @Column(nullable = false)
        val type: OrderType

) : BaseEntity(id)
