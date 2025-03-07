package ru.example.demo.entity

import jakarta.persistence.*

@Entity
@Table(name="carrier_companies")
data class CarrierCompanyEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val userCompanyId:Long?=null,
    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    val representatives: MutableList<OrderEntity> = mutableListOf(),

    val name: String,
)