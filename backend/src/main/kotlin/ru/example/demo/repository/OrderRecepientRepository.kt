package ru.example.demo.repository

import org.springframework.data.jpa.repository.JpaRepository

interface OrderRecepientRepository
    : JpaRepository<ru.example.demo.entity.OrderRecepientEntity, Long>
{
}