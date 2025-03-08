package ru.example.demo.entity


import jakarta.persistence.*

@Entity
@Table(name="carrier_companies")
data class CarrierCompanyEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne()
    @JoinColumn(name = "user_company_id", nullable = false)
    val userCompany: UserCompanyEntity,

    val name: String,
)