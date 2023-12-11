package com.example.kotlinpractice.domain.user.exception

import com.example.kotlinpractice.global.error.ErrorCode
import com.study.kotlkotlin.global.error.exception.BusinessException

object UserNotFoundException : BusinessException (
        ErrorCode.USER_NOT_FOUND
)