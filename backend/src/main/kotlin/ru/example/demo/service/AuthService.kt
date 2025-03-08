package ru.example.demo.service

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import ru.example.demo.dto.enums.UserRoles
import ru.example.demo.dto.request.LoginUserRequest
import ru.example.demo.dto.request.RegisterHeadRequest
import ru.example.demo.dto.request.RegisterManagerRequest
import ru.example.demo.dto.response.AuthResponse
import ru.example.demo.entity.InviteEntity
import ru.example.demo.entity.UserCompanyEntity
import ru.example.demo.entity.UserEntity
import ru.example.demo.exception.type.EntityAlreadyExistsException
import ru.example.demo.exception.type.NotFoundException
import ru.example.demo.exception.type.UnauthorizedException
import ru.example.demo.repository.InviteRepository
import ru.example.demo.repository.UserCompanyRepository
import java.util.*
import kotlin.jvm.optionals.getOrElse


@Service
class AuthService(
    private val userRepository: ru.example.demo.repository.UserRepository,
    private val userCompanyRepository: UserCompanyRepository,
    private val inviteRepository: InviteRepository
) {
    @Transactional
    fun registerHead(request: RegisterHeadRequest): AuthResponse {
        userCompanyRepository.findByEmail(request.email).ifPresent {
            throw EntityAlreadyExistsException("Почта ${request.email} занята")
        }

        userRepository.findByLogin(request.headLogin).ifPresent {
            throw EntityAlreadyExistsException("Логин ${request.headName} занят")
        }

        val token = generateToken()

        val company = UserCompanyEntity(
            name = request.companyName,
            email = request.email,
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

        return AuthResponse(
            userId = savedUser.id,
            token = savedUser.token,
            companyId = savedCompany.id,

            )
    }

    @Transactional
    fun registerManager(request: RegisterManagerRequest): AuthResponse {
        val invite = inviteRepository.findByToken(request.inviteToken).getOrElse {
            throw NotFoundException("Приглашение недействительно")
        }

        userRepository.findByLogin(request.managerLogin).ifPresent {
            throw EntityAlreadyExistsException("Логин ${request.managerLogin} занят")
        }

        invite.checkToken()

        val company = invite.company
        val token = generateToken()


        val newUser = UserEntity(
            login = request.managerLogin,
            name = request.managerName,
            password = request.managerPassword,
            role = UserRoles.MANAGER,
            company = company,
            token = token
        )

        val savedUser = userRepository.save(newUser)

        return AuthResponse(
            userId = savedUser.id,
            token = savedUser.token,
            companyId = company.id,
        )
    }

    @Transactional
    fun loginUser(request: LoginUserRequest): AuthResponse {
        val user = userRepository.findByLogin(request.login).getOrElse {
            throw NotFoundException("Такого пользователя не существует")
        }
        user.checkPassword(request.password)

        user.token = generateToken()

        val savedUser = userRepository.save(user)

        return AuthResponse(
            userId = savedUser.id,
            token = savedUser.token,
            companyId = savedUser.company.id,
        )
    }


    @Transactional
    fun generateInvite(userToken: String): String {

        val user = userRepository.findByToken(userToken).getOrElse {
            throw UnauthorizedException("Недействителен токен авторизации")
        }

        val company = user.company

        val token = generateToken()

        val invite = InviteEntity(
            company = company,
            token = token
        )
        val savedInvite = inviteRepository.save(invite)

//        Пока localhost:8080 потом разберусь, как лучше сделать
        return "https://localhost:8080/manager/sign-up?token=${savedInvite.token}"
    }

    fun generateToken(): String {
        return UUID.randomUUID().toString()
    }
}
