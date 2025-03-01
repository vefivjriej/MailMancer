package ru.example.demo.entity
import jakarta.persistence.*

@Entity
@Table(name="Orders")
data class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = true)
    val name: String? = null,

    @Column(name = "download_address",nullable = false)
    val downloadAddress: String?=null,

    @Column(name = "delivery_address", nullable = false)
    val deliveryAddress: String?=null,

    @Column(nullable = false)
    val weight: String?=null,

    @Column(nullable = false)
    val length: String?=null,

    @Column(nullable = false)
    val height: String?=null,

    @Column(nullable = false)
    val width: String?=null,

    @Column(name = "additional_requirements", nullable = true)
    val additionalRequirements: String?=null,

    @Column(name = "created_date",nullable = false)
    val createdDate: String?=null,

    @Column(name = "close_date", nullable = false)
    val closeDate: String?=null,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val user: UserEntity
)
