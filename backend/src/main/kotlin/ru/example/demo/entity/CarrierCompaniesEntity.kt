package ru.example.demo.entity

import jakarta.persistence.*

@Entity
@Table(name="carrier_companies")
data class CarrierCompanyEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val userCompanyId:Long?=null,

    val name: String,
)