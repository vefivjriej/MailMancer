package com.example.demo.repository

import com.example.demo.Entity.UserCompanyEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserCompaniesRepository
    : JpaRepository<UserCompanyEntity, Long>
{
}