package com.ccarvalho.repository

import com.ccarvalho.domain.Revenue
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface RevenueRepository: JpaRepository<Revenue, Long> {

    @Query("SELECT r.id FROM Revenue r WHERE r.description = ?1 AND MONTH(r.createdDate) = ?2")
    fun findRevenueByDescriptionAndMonth(description: String, month: Int): List<Revenue>

}