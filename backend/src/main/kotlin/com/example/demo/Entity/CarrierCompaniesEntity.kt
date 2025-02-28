package com.example.demo.Entity
import jakarta.persistence.*

@Entity
@Table(name="carrier_companies")
data class CarrierCompanyEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable=false)
    val user_companie_id:Long?=null,

    @Column(nullable=true)
    val name: String?=null,
)