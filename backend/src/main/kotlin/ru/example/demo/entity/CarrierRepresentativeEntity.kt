package ru.example.demo.entity

import jakarta.persistence.*

@Entity
@Table(name="carrier_representative")
data class CarrierRepresentativeEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne()
    @JoinColumn(name = "carrier_company_id", nullable = false)
    val carrierCompany: CarrierCompanyEntity,

    val email: String,

    val additionally: String?=null,

    @ManyToMany(mappedBy = "recipients")
    val orders: MutableSet<OrderEntity> = mutableSetOf()
)