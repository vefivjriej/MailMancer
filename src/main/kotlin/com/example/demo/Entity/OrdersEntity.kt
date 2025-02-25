package application.repository.com.example.demo.Entity

import jakarta.persistence.*

@Entity
@Table(name="Orders")
data class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = true)
    val name: String? = null,

    @Column(nullable = false)
    val company_id: Long?=null,

    @Column(nullable = false)
    val download_adress: String?=null,

    @Column(nullable = false)
    val delivery_adress: String?=null,

    @Column(nullable = false)
    val weight: String?=null,

    @Column(nullable = false)
    val lenght: String?=null,

    @Column(nullable = false)
    val height: String?=null,

    @Column(nullable = false)
    val width: String?=null,

    @Column(nullable = true)
    val additional_requirments: String?=null,

    @Column(nullable = false)
    val create_data: String?=null,

    @Column(nullable = false)
    val close_data: String?=null,
)