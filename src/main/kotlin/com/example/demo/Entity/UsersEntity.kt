package com.example.demo.Entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val company_id: Long?=null,

    @Column(nullable = true)
    val name: String? = null,

    @Column(nullable = false)
    val role: Boolean = false,
)