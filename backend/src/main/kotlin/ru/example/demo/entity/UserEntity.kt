package ru.example.demo.entity


import jakarta.persistence.*
import ru.example.demo.dto.enums.UserRoles
import ru.example.demo.dto.model.User
import ru.example.demo.exception.type.UnauthorizedException

@Entity
@Table(name = "users")
data class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(unique = true)
    val login: String,

    val name: String,

    val password: String,

    val role: UserRoles,

    @Column(unique = true)
    var token: String,

    @ManyToOne()
    @JoinColumn(name = "company_id", nullable = false)
    val company: UserCompanyEntity,

    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    val orders: MutableList<OrderEntity> = mutableListOf(),

    ) {

    fun toUser(companyId: Long? = null): User {

        return User(
            login = login,
            name = name,
            password = password,
            token = token,
            role = role,
            company = company.toUserCompany()

        )
    }

    fun checkPassword(userPassword: String) {
        if (password != userPassword) {
            throw UnauthorizedException("Неверный логи или пароль")
        }
    }
}