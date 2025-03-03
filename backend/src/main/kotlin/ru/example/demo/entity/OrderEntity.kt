package ru.example.demo.entity
import jakarta.persistence.*

@Entity
@Table(name="orders")
data class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val name: String,

    @Column(name = "download_address")
    val downloadAddress: String,

    @Column(name = "delivery_address")
    val deliveryAddress: String,

    val weight: String,

    val length: String,

    val height: String,

    val width: String,

    @Column(name = "additional_requirements")
    val additionalRequirements: String?=null,

    @Column(name = "created_date")
    val createdDate: String,

    @Column(name = "close_date", nullable = false)
    val closeDate: String?=null,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val user: UserEntity
)
