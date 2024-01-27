package com.example.kotlinpractice.domain.auth.domain

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed
import java.util.UUID

@RedisHash
class RefreshToken(
    id: UUID,
    token: String,
    expiration: Long
) {

    @Id
    var id: UUID = id
        protected set

    @Indexed
    var token: String = token
        protected set

    @TimeToLive
    var expiration: Long = expiration
        protected set

    fun updateToken(token: String, expiration: Long) {
        this.token = token
        this.expiration = expiration
    }
}
