package application.repository.com.example.demo.Entity

import jakarta.persistence.*

@Entity
@Table(name="carrier_representative")
data class CarrierRepresentativeEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable=false)
    val carrier_companie_id:Long?=null,

    @Column(nullable=false)
    val email: String?=null,

    @Column(nullable = true)
    val additionally: String?=null,
) {
}