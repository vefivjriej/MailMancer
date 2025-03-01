package ru.example.demo.repository

import org.springframework.data.jpa.repository.JpaRepository

interface CarrierRepresentativeRepository
    : JpaRepository<ru.example.demo.entity.CarrierRepresentativeEntity, Long>
{
}