package com.example.kotlinpractice.domain.order.repository

import com.example.kotlinpractice.domain.order.domain.Order
import com.example.kotlinpractice.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, Long> {

    fun findOrderById(id: Long) : Order

    fun findOrderByUser(user: User) : Order

    fun deleteOrderById(id: Long)
}