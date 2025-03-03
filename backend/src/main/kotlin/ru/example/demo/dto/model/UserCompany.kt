package ru.example.demo.dto.model

import ru.example.demo.entity.UserEntity

data class UserCompany (
    val id: Long?,
    val name: String,
    val email: String,
    val password: String,
    val users: List<Long?>
)