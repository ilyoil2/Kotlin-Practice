package com.example.kotlinpractice.domain.item.exception

import com.example.kotlinpractice.global.error.ErrorCode
import com.example.kotlinpractice.global.error.exception.BusinessException

object ItemAlreadyExistsException : BusinessException(
        ErrorCode.ITEM_ALREADY_EXISTS
)