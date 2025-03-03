package ru.example.demo.controller


import ru.example.demo.dto.request.RegisterHeadRequest
import ru.example.demo.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.example.demo.dto.response.RegisterHeadResponse


@RestController
@RequestMapping("/api/users")
class UserController(
    val userService: UserService
) {
    @PostMapping("/head/sign-up")
    fun registerHead(@RequestBody request: RegisterHeadRequest): RegisterHeadResponse {
        return userService.registerHead(request)
    }



}