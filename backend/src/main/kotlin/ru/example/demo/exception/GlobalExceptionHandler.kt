package ru.example.demo.exception

import jakarta.persistence.EntityNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import ru.example.demo.dto.response.ErrorResponse
import ru.example.demo.exception.type.BadRequestException
import ru.example.demo.exception.type.EntityAlreadyExistsException

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException::class)
    fun handleIllegalArgumentException(exception: BadRequestException) =
        ResponseEntity.badRequest().body(ErrorResponse(exception.message ?: "BAD REQUEST"))

    @ExceptionHandler(EntityAlreadyExistsException::class)
    fun handleEntityAlreadyExistsException(exception: EntityAlreadyExistsException) =
        ResponseEntity.status(409).body(ErrorResponse(exception.message ?: "CONFLICT"))

    @ExceptionHandler(Exception::class)
    fun handleGeneralException(ex: Exception): ResponseEntity<Map<String, String>> {
        return ResponseEntity(mapOf("error" to "Внутренняя ошибка сервера"), HttpStatus.INTERNAL_SERVER_ERROR)
    }
}
