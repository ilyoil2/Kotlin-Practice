package com.example.kotlinpractice.global.entity

import java.util.UUID
import javax.persistence.*

@MappedSuperclass
abstract class BaseEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open val id: Long = 0
)
