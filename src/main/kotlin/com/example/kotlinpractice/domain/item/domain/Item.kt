package com.example.kotlinpractice.domain.item.domain

import com.example.kotlinpractice.global.entity.BaseEntity
import com.sun.istack.NotNull
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity

@Entity
class Item (

        id : UUID,

        @field:NotNull
        @Column(columnDefinition = "VARCHAR(50)")
        var itemName: String,

        @field:NotNull
        @Column(columnDefinition = "INT")
        var itemCounts: Long,

        ) : BaseEntity(id)

