package ru.example.demo.service

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import io.kotest.matchers.shouldBe
import ru.example.demo.dto.enums.UserRoles
import ru.example.demo.dto.model.User
import ru.example.demo.dto.model.UserCompany
import ru.example.demo.dto.request.RegisterHeadRequest
import ru.example.demo.repository.InviteRepository
import ru.example.demo.repository.UserCompanyRepository
import ru.example.demo.repository.UserRepository
import java.util.*


class AuthServiceTest {
    private val userRepository = mockk<UserRepository>()
    private val userCompanyRepository = mockk<UserCompanyRepository>()
    private val inviteRepository = mockk<InviteRepository>()
    private val tokenService = mockk<TokenService>()
    private val authService = AuthService(userRepository, userCompanyRepository, inviteRepository, tokenService)

    @Test
    fun `когда head успешно регистрируется, должны по явиться новая комания и пользователь`() {
        val request = RegisterHeadRequest(
            headLogin     = "admin",
            headName      = "Name",
            headPassword  = "123456",
            companyName   = "Company",
            email         = "email@example.com",
            emailPassword = "123456",
        )
        val newCompany = UserCompany(
            name = request.companyName,
            email    = request.email,
            password = request.emailPassword
        )

        val newHead = User(
            login = request.headLogin,
            name   = request.headName,
            password = request.headPassword,
            role = UserRoles.HEAD,
            company = newCompany,
            token = "token"


        )
        every { userRepository.save(any()) } answers { firstArg() }
        every { userRepository.findByLogin(any()) } answers { Optional.empty() }
        every { userCompanyRepository.save(any()) } answers { firstArg() }
        every { userCompanyRepository.findByEmail(any()) } answers { Optional.empty() }
        every { tokenService.generateToken() } returns "token"

        val savedUser = authService.registerHead(request).toUser()

        savedUser shouldBe newHead
        savedUser.company shouldBe newCompany

    }

    @Test
    fun `когда head регистрируется, email компании уже занят`(){

    }
}