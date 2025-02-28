package com.example.demo.repository

import com.example.demo.Entity.OrderRecepientEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRecepientRepository
    : JpaRepository<OrderRecepientEntity, Long>
{
}