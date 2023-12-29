package com.example.kotlinpractice.domain.order.service

import com.example.kotlinpractice.domain.item.domain.Item
import com.example.kotlinpractice.domain.item.domain.repository.ItemRepository
import com.example.kotlinpractice.domain.order.domain.Order
import com.example.kotlinpractice.domain.order.domain.type.OrderType
import com.example.kotlinpractice.domain.order.repository.OrderRepository
import com.example.kotlinpractice.domain.user.exception.UserAlreadyExistsException
import com.example.kotlinpractice.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class CancelOrderService (
        private val orderRepository: OrderRepository,
        private val userFacade: UserFacade,
        private val itemRepository: ItemRepository
)
{

    fun execute(orderId: Long) {

        userFacade.getCurrentUser()

        val order: Order = orderRepository.findOrderById(orderId)

        if(order.type == OrderType.COMPLETE) {
            throw UserAlreadyExistsException
        }

        //취소한 주문의 아이템의 갯수만큼 아이템 수 증가
        val item: Item = itemRepository.findItemById(order.item.id)
        item.addItemCount(order.orderedItemCounts)

        orderRepository.deleteOrderById(order.id)

    }

}
