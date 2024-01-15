package com.example.kotlinpractice.thirdparty

import com.example.kotlinpractice.domain.item.service.QueryItemListService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class Scheduler(
    private val queryItemListService: QueryItemListService
) {

    @Scheduled(cron = "0 43 16 * * *")
    fun autoUpdate() {
        queryItemListService.execute()
    }

}