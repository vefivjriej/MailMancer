package ru.example.demo.service

import org.springframework.stereotype.Service
import ru.example.demo.dto.enums.UserRoles
import ru.example.demo.dto.request.RegisterHeadRequest
import ru.example.demo.dto.response.RegisterHeadResponse
import ru.example.demo.entity.UserCompanyEntity
import ru.example.demo.entity.UserEntity
import ru.example.demo.repository.UserCompanyRepository
import java.util.*
import kotlin.jvm.optionals.getOrElse

@Service
class UserService (
    val userRepository: ru.example.demo.repository.UserRepository,
    val userCompanyRepository: UserCompanyRepository
) {
    fun registerHead(request: RegisterHeadRequest): RegisterHeadResponse {

        val token = generateToken()

        val company= UserCompanyEntity(
            name = request.companyName,
            email=request.email,
            password = request.emailPassword
        )

        val savedCompany = userCompanyRepository.save(company)

        val user = UserEntity(
            login = request.headLogin,
            name = request.headName,
            password = request.headPassword,
            role = UserRoles.HEAD,
            company = savedCompany,
            token = token
        )
        val savedUser = userRepository.save(user)

        return RegisterHeadResponse(
            id = savedUser.id,
            token = token

        )
    }
    fun generateToken() : String {
        return UUID.randomUUID().toString()
    }
}