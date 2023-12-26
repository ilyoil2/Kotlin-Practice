package com.example.kotlinpractice.domain.item.presentation

import com.example.kotlinpractice.domain.item.presentation.dto.request.CreateItemRequest
import com.example.kotlinpractice.domain.item.presentation.dto.response.ItemResponse
import com.example.kotlinpractice.domain.item.service.CreateItemService
import com.example.kotlinpractice.domain.item.service.GetItemService
import org.springframework.web.bind.annotation.*

@RequestMapping("/item")
@RestController
class ItemController(
        private val createItemService: CreateItemService,
        private val queryItemService: GetItemService
) {
    @PostMapping
    fun createItem(@RequestBody request: CreateItemRequest) {
        createItemService.execute(request)
    }

    @GetMapping
    fun queryItemList(): ItemResponse {
        return queryItemService.execute()
    }

    @DeleteMapping("/item-id")
    fun deleteItem(@PathVariable("item-id") Long)

}