package ru.example.demo.entity

import jakarta.persistence.*
import ru.example.demo.dto.model.User
import ru.example.demo.dto.model.UserCompany

@Entity
@Table(name="user_companies")
data class UserCompanyEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val name: String,

    val email:String,

    val password:String,

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    val users: MutableList<UserEntity> = mutableListOf(),

    ) {
    fun toUserCompany(): UserCompany = UserCompany(
        id = id,
        name = name,
        email = email,
        password = password,
        users = users.map { it.id }
    )
    override fun toString(): String {
        return "UserCompanyEntity(id=$id, name=$name, email=$email, password=$password, users=${users.map { it.id }})"
    }
}