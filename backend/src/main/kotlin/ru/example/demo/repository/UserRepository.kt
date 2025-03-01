package ru.example.demo.repository


import org.springframework.data.jpa.repository.JpaRepository

import java.util.*

interface UserRepository : JpaRepository<ru.example.demo.entity.UserEntity, Long> {
    fun findByToken(token: String): Optional<ru.example.demo.entity.UserEntity>

}