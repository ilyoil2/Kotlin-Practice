package com.study.kotlkotlin.global.security.exception

import com.example.kotlinpractice.global.security.exception.SecurityErrorCode
import com.example.kotlinpractice.global.error.exception.BusinessException


class ExpiredTokenException private constructor() : BusinessException(SecurityErrorCode.EXPIRED_TOKEN) {

    companion object {
        @JvmField
        val EXCEPTION = ExpiredTokenException()
    }
}