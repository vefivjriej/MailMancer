package com.example.demo.dto.model

data class User (
    val id: Long,
    val name: String,
    val password: String,
    val role: String,
    val company: Company
)