package ru.example.demo.dto.request

data class RegisterManagerRequest (
    val managerName: String,
    val managerLogin: String,
    val managerPassword: String,
    val inviteToken: String
)