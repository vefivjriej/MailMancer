package ru.example.demo.dto.model

data class UserCompany (
    val id: Long?,
    val name: String,
    val email: String,
    val password: String,
    val users: List<User>
)