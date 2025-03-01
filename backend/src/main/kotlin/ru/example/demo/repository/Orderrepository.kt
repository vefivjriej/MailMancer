package ru.example.demo.repository

import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository
    : JpaRepository<ru.example.demo.entity.OrderEntity, Long>
{
}
