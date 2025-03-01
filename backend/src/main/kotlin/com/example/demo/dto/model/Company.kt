package com.example.demo.dto.model

data class Company (
    val id: Int,
    val name: String,
    val email: String,
    val password: String,
    val users: List<User>
)