package ru.example.demo.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.example.demo.entity.InviteEntity
import java.util.Optional

interface InviteRepository : JpaRepository<InviteEntity, Long> {
    fun findByToken(userToken: String): Optional<InviteEntity>
}