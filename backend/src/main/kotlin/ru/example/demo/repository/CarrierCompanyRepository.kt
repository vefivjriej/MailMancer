package ru.example.demo.repository

import org.springframework.data.jpa.repository.JpaRepository

interface CarrierCompanyRepository
    : JpaRepository<ru.example.demo.entity.CarrierRepresentativeEntity, Long>
{
}