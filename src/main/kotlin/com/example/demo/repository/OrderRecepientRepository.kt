package com.example.demo.repository

import application.repository.com.example.demo.Entity.OrderEntity
import application.repository.com.example.demo.Entity.OrderRecepientEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRecepientRepository
    : JpaRepository<OrderRecepientEntity, Long>
{
}