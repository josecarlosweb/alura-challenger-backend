package com.ccarvalho.repository

import com.ccarvalho.domain.Revenue
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RevenueRepository: JpaRepository<Revenue, Long>