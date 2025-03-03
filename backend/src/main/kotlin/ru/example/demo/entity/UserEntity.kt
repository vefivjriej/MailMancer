package ru.example.demo.entity


import jakarta.persistence.*
import ru.example.demo.dto.enums.UserRoles
import ru.example.demo.dto.model.User
import ru.example.demo.dto.model.UserCompany

@Entity
@Table(name = "users")
data class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val name: String,

    val password: String,

    val role: UserRoles,

    val token: String?,

    @ManyToOne()
    @JoinColumn(name = "company_id", nullable = false)
    val company: UserCompanyEntity,

    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    val orders: MutableList<OrderEntity> = mutableListOf(),

) {

    fun toUser(companyId: Long? =null): User {

        return User(
            id = id,
            name = name,
            password = password,
            role = role,
            company = company.toUserCompany()

        )
    }
}