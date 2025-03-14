package ru.example.demo.repository


import org.springframework.data.jpa.repository.JpaRepository
import ru.example.demo.entity.UserEntity

import java.util.*

interface UserRepository : JpaRepository<UserEntity, Long> {
    fun findByToken(token: String): Optional<UserEntity>
    fun findByLogin(login: String): Optional<UserEntity>
}