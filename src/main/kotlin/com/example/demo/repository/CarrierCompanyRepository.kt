package com.example.demo.repository

import application.repository.com.example.demo.Entity.CarrierRepresentativeEntity
import application.repository.com.example.demo.Entity.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CarrierCompanyRepository
    : JpaRepository<CarrierRepresentativeEntity, Long>
{
}