package com.example.kotlinpractice.domain.storage.presentation

import com.example.kotlinpractice.domain.storage.service.ItemStorageService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/storage")
class StorageController (
        private val itemStorageService: ItemStorageService
) {


    @PostMapping("/{item-id}")
    fun execute(@PathVariable("item-id") itemId: Long) {
        itemStorageService.execute(itemId)

    }



}