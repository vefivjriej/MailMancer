package ru.example.demo.entity

import jakarta.persistence.*

@Entity
@Table(name="order_recepients")
data class OrderRecepientEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable=false)
    val order_id:Long?=null,

    @Column(nullable = false)
    val recepients_company_id: String?=null,
)