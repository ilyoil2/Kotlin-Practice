package com.study.kotlkotlin.global.error.exception

import com.example.kotlinpractice.global.error.ErrorCode

open class BusinessException(
        val errorProperty: ErrorCode
): RuntimeException() {
}