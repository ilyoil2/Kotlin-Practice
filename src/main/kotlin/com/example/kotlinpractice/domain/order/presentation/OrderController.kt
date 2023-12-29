package com.example.kotlinpractice.domain.order.presentation

import com.example.kotlinpractice.domain.order.service.CancelOrderService
import com.example.kotlinpractice.domain.order.service.MakeOrderService
import com.example.kotlinpractice.domain.order.service.QueryMyOrderService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.constraints.NotBlank

@RequestMapping("/order")
@RestController
class OrderController (
        private val makeOrderService: MakeOrderService,
        private val cancelOrderService: CancelOrderService,
        private val queryMyOrderService: QueryMyOrderService
) {

    @PostMapping("/{item-id}")
    fun makeOrder(@PathVariable("item-id") itemId: Long,
                  @RequestParam @NotBlank orderedItemCounts: Int) {
        makeOrderService.execute(itemId, orderedItemCounts)
    }

    @DeleteMapping("/{order-id}")
    fun cancelOrder(@PathVariable("order-id") orderId: Long) {
        cancelOrderService.execute(orderId)
    }

    @GetMapping
    fun queryMyOrder() {
        queryMyOrderService.execute()
    }

}
