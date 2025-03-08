package ru.example.demo.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.example.demo.entity.UserInviteEntity

interface UserInviteRepository : JpaRepository<UserInviteEntity, Long> {
}