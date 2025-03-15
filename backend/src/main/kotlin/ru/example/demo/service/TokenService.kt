package ru.example.demo.service

import org.springframework.stereotype.Service
import java.util.*

@Service
class TokenService {
    fun generateToken(): String {
        return UUID.randomUUID().toString()
    }
}
