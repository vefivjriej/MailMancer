package com.example.demo.repository

import com.example.demo.Entity.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository
    : JpaRepository<OrderEntity, Long>
{
}
