package ru.example.demo.dto.response


data class AuthResponse(
    val userId : Long,
    val companyId : Long,
    val token: String
)