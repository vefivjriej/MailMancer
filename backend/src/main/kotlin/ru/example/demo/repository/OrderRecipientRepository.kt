package ru.example.demo.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.example.demo.entity.OrderRecepientEntity

interface OrderRecipientRepository
    : JpaRepository<OrderRecepientEntity, Long>
{
}