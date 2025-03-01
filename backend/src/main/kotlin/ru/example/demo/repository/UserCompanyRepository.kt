package ru.example.demo.repository



import org.springframework.data.jpa.repository.JpaRepository
import ru.example.demo.entity.UserCompanyEntity

import java.util.*

interface UserCompanyRepository : JpaRepository<UserCompanyEntity, Long> {


}