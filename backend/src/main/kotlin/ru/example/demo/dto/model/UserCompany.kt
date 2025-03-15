package ru.example.demo.dto.model

import ru.example.demo.entity.UserCompanyEntity


data class UserCompany (
    val name: String,
    val email: String,
    val password: String,
) {
    fun toEntity() = UserCompanyEntity(
        name = name,
        email = email,
        password = password
    )
}