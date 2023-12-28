package com.example.kotlinpractice.domain.item.service

import com.example.kotlinpractice.domain.item.domain.repository.ItemRepository
import com.example.kotlinpractice.domain.item.presentation.dto.response.QueryItemListResponse
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class QueryItemListService (
        private val itemRepository: ItemRepository,
) {
    fun execute(): QueryItemListResponse {
        return QueryItemListResponse(
                itemRepository.findAll()
                        .map { QueryItemListResponse.ItemResponse(it) }
        )
    }
}
