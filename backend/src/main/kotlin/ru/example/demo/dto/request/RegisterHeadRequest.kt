package ru.example.demo.dto.request

data class RegisterHeadRequest (
    val headName: String,
    val headPassword: String,

    val companyName: String,
    val email: String,
    val emailPassword: String,
)