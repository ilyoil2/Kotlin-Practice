package com.example.kotlinpractice.domain.item.domain

import com.example.kotlinpractice.global.entity.BaseEntity
import com.sun.istack.NotNull
import javax.persistence.Column
import javax.persistence.Entity

@Entity
class Item (

        override val id : Long,

        @field:NotNull
        @Column(columnDefinition = "VARCHAR(50)")
        var itemName: String,

        @field:NotNull
        @Column(columnDefinition = "INT")
        var itemCounts: Int,

        ) : BaseEntity() {
        fun minusItemCount(int: Int) {
                this.itemCounts -= int
        }

        fun addItemCount(int: Int) {
                this.itemCounts += int
        }

}
