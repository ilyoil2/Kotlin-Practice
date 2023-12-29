package com.example.kotlinpractice.domain.order.service

import com.example.kotlinpractice.domain.item.domain.Item
import com.example.kotlinpractice.domain.item.domain.repository.ItemRepository
import com.example.kotlinpractice.domain.order.domain.Order
import com.example.kotlinpractice.domain.order.domain.type.OrderType
import com.example.kotlinpractice.domain.order.repository.OrderRepository
import com.example.kotlinpractice.domain.user.domain.User
import com.example.kotlinpractice.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class MakeOrderService (
        private val userFacade: UserFacade,
        private val orderRepository: OrderRepository,
        private val itemRepository: ItemRepository
) {
    fun execute(itemId: Long, orderedItemCounts: Int) {

        val item: Item =  itemRepository.findItemById(itemId)
        item.minusItemCount(orderedItemCounts)

        val currentUser: User = userFacade.getCurrentUser()

        orderRepository.save(
                Order(
                        id = 0,
                        user = currentUser,
                        item = item,
                        orderedItemName = item.itemName,
                        orderedItemCounts = orderedItemCounts,
                        type = OrderType.SHIPPING
                )
        )
    }

}
