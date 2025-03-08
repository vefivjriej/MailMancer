package ru.example.demo.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.example.demo.entity.OrderEntity

interface OrderRepository : JpaRepository<OrderEntity, Long>
{
}
