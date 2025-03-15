package ru.example.demo.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.example.demo.entity.CarrierRepresentativeEntity

interface CarrierCompanyRepository
    : JpaRepository<CarrierRepresentativeEntity, Long> {
}