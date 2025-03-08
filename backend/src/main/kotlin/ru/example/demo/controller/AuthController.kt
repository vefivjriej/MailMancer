package ru.example.demo.controller


import org.springframework.web.bind.annotation.*
import ru.example.demo.dto.request.RegisterHeadRequest
import ru.example.demo.service.AuthService
import ru.example.demo.dto.request.LoginUserRequest
import ru.example.demo.dto.response.LoginUserResponse
import ru.example.demo.dto.response.RegisterHeadResponse


@RestController
@RequestMapping("/api/v1")
class AuthController(
    val authService: AuthService
) {
    @PostMapping("/head/sign-up")
    fun registerHead(@RequestBody request: RegisterHeadRequest): RegisterHeadResponse =
        authService.registerHead(request)

    @PostMapping("/manager/sign-up")
    fun registerManager(@RequestBody request: LoginUserRequest): LoginUserResponse {
        TODO()
    }

    @PostMapping("/sign-in")
    fun loginUser(@RequestBody request: LoginUserRequest): LoginUserResponse {
        TODO()
    }

    @PostMapping("/generate-invite")
    fun generateInvite(@RequestParam companyId: Long): String {
        TODO()
    }



}