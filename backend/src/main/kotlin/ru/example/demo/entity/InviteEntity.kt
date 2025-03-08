package ru.example.demo.entity

import jakarta.persistence.*
import ru.example.demo.exception.type.ExpiredTokenException
import java.time.LocalDateTime
import java.time.Duration

@Entity
@Table(name = "invites")
class InviteEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(unique = true)
    val token: String,

    @ManyToOne()
    @JoinColumn(name = "user_company_id", nullable = false)
    val company: UserCompanyEntity,

    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    fun checkToken() {
        if (Duration.between(createdAt, LocalDateTime.now()).toHours() > 24) {
            throw ExpiredTokenException("Приглашение истекло")
        }
    }
}
