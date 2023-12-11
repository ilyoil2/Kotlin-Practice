package com.example.kotlinpractice.domain.user.exception

import com.example.kotlinpractice.global.error.ErrorCode
import com.study.kotlkotlin.global.error.exception.BusinessException

object UserAlreadyExistsException : BusinessException(
        ErrorCode.USER_ALREADY_EXISTS
)