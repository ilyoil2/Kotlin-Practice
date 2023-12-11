package com.example.kotlinpractice.global.entity

import javax.persistence.*

@MappedSuperclass
abstract class BaseEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?
)
