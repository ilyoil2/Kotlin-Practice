package com.example.kotlinpractice.domain.item.presentation

import com.example.kotlinpractice.domain.item.presentation.dto.request.CreateItemRequest
import com.example.kotlinpractice.domain.item.presentation.dto.response.ItemResponse
import com.example.kotlinpractice.domain.item.service.CreateItemService
import com.example.kotlinpractice.domain.item.service.DeleteItemService
import com.example.kotlinpractice.domain.item.service.QueryItemListService
import com.example.kotlinpractice.domain.item.service.QueryItemService
import org.springframework.web.bind.annotation.*
import java.util.UUID
import javax.validation.constraints.NotNull

@RequestMapping("/item")
@RestController
class ItemController(
        private val createItemService: CreateItemService,
        private val queryItemListService: QueryItemListService,
        private val deleteItemService: DeleteItemService,
        private val queryItemService: QueryItemService
) {
    @PostMapping
    fun createItem(@RequestBody request: CreateItemRequest) {
        createItemService.execute(request)
    }

    @GetMapping
    fun queryItemList(): ItemResponse {
        return queryItemListService.execute()
    }

    @GetMapping("/{item-id}")
    fun queryItem(@PathVariable("item-id") @NotNull itemId: UUID): ItemResponse {
        return queryItemService.execute(itemId)
    }

    @DeleteMapping("/{item-id}")
    fun deleteItem(@PathVariable("item-id") itemId : UUID) {
        deleteItemService.execute(itemId)
    }

}
