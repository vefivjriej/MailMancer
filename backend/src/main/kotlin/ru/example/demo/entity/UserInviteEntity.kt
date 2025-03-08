package ru.example.demo.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "user_invites")
class UserInviteEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(unique = true)
    val token: String,

    @ManyToOne()
    @JoinColumn(name = "company_id", nullable = false)
    val company: UserCompanyEntity,

    var used: Boolean = false,

    val createdAt: LocalDateTime = LocalDateTime.now()
)
