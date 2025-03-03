package ru.example.demo.entity

import jakarta.persistence.*

@Entity
@Table(name="carrier_representative")
data class CarrierRepresentativeEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val carrierCompanyId: Long,

    val email: String,

    @Column(nullable = true)
    val additionally: String?=null,
) {
}