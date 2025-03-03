package ru.example.demo.entity

import jakarta.persistence.*

@Entity
@Table(name="carrier_companies")
data class CarrierCompanyEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val userCompanyId:Long?=null,

    @Column(nullable=true)
    val name: String?=null,
)