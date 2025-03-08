package ru.example.demo.exception


import io.swagger.v3.oas.annotations.Hidden
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import ru.example.demo.dto.response.ErrorResponse
import ru.example.demo.exception.type.*

@Hidden
@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException::class)
    fun handleIllegalArgumentException(exception: BadRequestException) =
        ResponseEntity.status(400).body(ErrorResponse(exception.message ?: "BAD REQUEST"))

    @ExceptionHandler(EntityAlreadyExistsException::class)
    fun handleEntityAlreadyExistsException(exception: EntityAlreadyExistsException) =
        ResponseEntity.status(409).body(ErrorResponse(exception.message ?: "CONFLICT"))

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(exception: NotFoundException) =
        ResponseEntity.status(404).body(ErrorResponse(exception.message ?: "NOT FOUND"))

    @ExceptionHandler(UnauthorizedException::class)
    fun handleUnauthorizedException(exception: UnauthorizedException) =
        ResponseEntity.status(401).body(ErrorResponse(exception.message ?: "UNAUTHORIZED"))

    @ExceptionHandler(ExpiredTokenException::class)
    fun handleExpiredTokenException(exception: ExpiredTokenException) =
        ResponseEntity.status(410).body(ErrorResponse(exception.message ?: "TOKEN EXPIRED"))
}
