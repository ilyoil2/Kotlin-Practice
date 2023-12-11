package com.example.kotlinpractice.domain.feed.exception

import com.example.kotlinpractice.global.error.ErrorCode
import com.study.kotlkotlin.global.error.exception.BusinessException

object ItemAlreadyExistsException : BusinessException(
        ErrorCode.ITEM_ALREADY_EXISTS
)