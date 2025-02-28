package com.example.demo.Entity

import jakarta.persistence.*

@Entity
@Table(name="user_companies")
data class UserCompanyEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable=false)
    val work_email:String?=null,

    @Column(nullable=true)
    val name: String?=null,

    @Column(nullable=false)
    val work_email_password:String?=null,
)