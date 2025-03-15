package ru.example.demo.dto.model

import ru.example.demo.dto.enums.UserRoles
import ru.example.demo.entity.UserEntity

data class User (
    val login: String,
    val name: String,
    val password: String,
    val role: UserRoles,
    val token: String,
    val company: UserCompany
){
    fun toEntity() = UserEntity(
        login = login,
        name = name,
        password = password,
        role = role,
        token = token,
        company = company.toEntity())
}