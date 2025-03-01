package com.example.demo.dto.model

import java.time.LocalDateTime

data class Order (
    val id: Int,
    val name: String,
    val downloadAddress: String,
    val unloadingAddress: String,
    val weight: Double,
    val length: Double,
    val width: Double,
    val height: Double,
    val additionalRequirements: String,
    val createdDate: LocalDateTime = LocalDateTime.now(),
    val closeDate : LocalDateTime? = null,

    val user : User,

)