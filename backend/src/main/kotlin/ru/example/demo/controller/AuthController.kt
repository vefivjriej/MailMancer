package ru.example.demo.controller


import org.springframework.web.bind.annotation.*
import ru.example.demo.dto.request.RegisterHeadRequest
import ru.example.demo.service.AuthService
import ru.example.demo.dto.request.LoginUserRequest
import ru.example.demo.dto.request.RegisterManagerRequest
import ru.example.demo.dto.response.AuthResponse
import ru.example.demo.dto.response.InviteResponse


@RestController
@RequestMapping("/api/v1")
class AuthController(
    val authService: AuthService
) {
    @PostMapping("/head/sign-up")
    fun registerHead(@RequestBody request: RegisterHeadRequest): AuthResponse {
        val user = authService.registerHead(request)
        return AuthResponse(
            userId = user.id,
            token = user.token,
            companyId = user.company.id,
            )
    }

    @PostMapping("/manager/sign-up")
    fun registerManager(@RequestBody request: RegisterManagerRequest): AuthResponse {
        val user = authService.registerManager(request)
        return AuthResponse(
            userId = user.id,
            token = user.token,
            companyId = user.company.id,
        )
    }

    @PostMapping("/sign-in")
    fun loginUser(@RequestBody request: LoginUserRequest): AuthResponse {
        val user = authService.loginUser(request)
        return AuthResponse(
            userId = user.id,
            token = user.token,
            companyId = user.company.id,
        )
    }

    @PostMapping("/generate-invite")
    fun generateInvite(@RequestHeader("Authorization") userToken: String): InviteResponse {
            val url = authService.generateInvite(userToken)
        return InviteResponse(
            url = url,
        )
    }

}