package com.example.demo.repository

import application.repository.com.example.demo.Entity.OrderEntity
import application.repository.com.example.demo.Entity.UserCompanyEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository
    : JpaRepository<OrderEntity, Long>
{
}
