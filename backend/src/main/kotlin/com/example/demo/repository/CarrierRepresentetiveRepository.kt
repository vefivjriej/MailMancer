package com.example.demo.repository

import com.example.demo.Entity.CarrierRepresentativeEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CarrierRepresentativeRepository
    : JpaRepository<CarrierRepresentativeEntity, Long>
{
}