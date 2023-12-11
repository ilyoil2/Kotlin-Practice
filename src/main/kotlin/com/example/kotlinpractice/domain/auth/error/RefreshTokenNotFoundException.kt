package com.example.kotlinpractice.domain.auth.error

import com.example.kotlinpractice.global.error.ErrorCode
import com.study.kotlkotlin.global.error.exception.BusinessException

class RefreshTokenNotFoundException private constructor(): BusinessException(ErrorCode.REFRESH_TOKEN_NOT_FOUND){

    companion object {
        @JvmField
        val EXCEPTION = RefreshTokenNotFoundException()
    }
}