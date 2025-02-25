package com.example.demo.repository

import application.repository.com.example.demo.Entity.UserCompanyEntity
import com.example.demo.Entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserCompaniesRepository
    : JpaRepository<UserCompanyEntity, Long>
{
}