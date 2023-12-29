package com.example.kotlinpractice.domain.item.presentation

import com.example.kotlinpractice.domain.item.presentation.dto.request.CreateItemRequest
import com.example.kotlinpractice.domain.item.presentation.dto.request.ModifyItemCountRequest
import com.example.kotlinpractice.domain.item.presentation.dto.response.QueryItemListResponse
import com.example.kotlinpractice.domain.item.presentation.dto.response.QueryItemResponse
import com.example.kotlinpractice.domain.item.service.*
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.NotNull

@RequestMapping("/item")
@RestController
class ItemController(
        private val createItemService: CreateItemService,
        private val queryItemListService: QueryItemListService,
        private val deleteItemService: DeleteItemService,
        private val queryItemService: QueryItemService,
        private val modifyItemCountService: ModifyItemCountService
) {
    @PostMapping
    fun createItem(@RequestBody request: CreateItemRequest) {
        createItemService.execute(request)
    }

    @GetMapping
    fun queryItemList(): QueryItemListResponse {
        return queryItemListService.execute()
    }

    @GetMapping("/{item-id}")
    fun queryItem(@PathVariable("item-id") @NotNull itemId: Long): QueryItemResponse {
        return queryItemService.execute(itemId)
    }

    @DeleteMapping("/{item-id}")
    fun deleteItem(@PathVariable("item-id") itemId : Long) {
        deleteItemService.execute(itemId)
    }

    @PostMapping("/itemCount/{item-id}")
    fun modifyItemCount(@PathVariable("item-id") itemId: Long, @RequestBody request: ModifyItemCountRequest) {
        modifyItemCountService.execute(itemId, request)
    }

}
