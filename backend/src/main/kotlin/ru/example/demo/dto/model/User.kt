package ru.example.demo.dto.model

import ru.example.demo.dto.enums.UserRoles

data class User (
    val id: Long?,
    val name: String,
    val password: String,
    val role: UserRoles,
    val company: UserCompany
)