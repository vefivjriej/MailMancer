package ru.example.demo.controller


import org.springframework.web.bind.annotation.*
import ru.example.demo.dto.request.RegisterHeadRequest
import ru.example.demo.service.AuthService
import ru.example.demo.dto.request.LoginUserRequest
import ru.example.demo.dto.request.RegisterManagerRequest
import ru.example.demo.dto.response.AuthResponse


@RestController
@RequestMapping("/api/v1")
class AuthController(
    val authService: AuthService
) {
    @PostMapping("/head/sign-up")
    fun registerHead(@RequestBody request: RegisterHeadRequest): AuthResponse =
        authService.registerHead(request)

    @PostMapping("/manager/sign-up")
    fun registerManager(@RequestBody request: RegisterManagerRequest): AuthResponse =
        authService.registerManager(request)

    @PostMapping("/sign-in")
    fun loginUser(@RequestBody request: LoginUserRequest): AuthResponse =
        authService.loginUser(request)

    @PostMapping("/generate-invite")
    fun generateInvite(@RequestHeader("Authorization") userToken: String): String =
        authService.generateInvite(userToken)

}