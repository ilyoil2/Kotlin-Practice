package com.example.kotlinpractice.domain.order.service

import com.example.kotlinpractice.domain.order.repository.OrderRepository
import com.example.kotlinpractice.domain.user.domain.User
import com.example.kotlinpractice.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class QueryMyOrderService (
        private val orderRepository: OrderRepository,
        private val userFacade: UserFacade,
) {
    fun execute() {

        val currentUser : User = userFacade.getCurrentUser()

        orderRepository.findOrderByUser(user = currentUser)
    }

}
