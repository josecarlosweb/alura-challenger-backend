package com.ccarvalho.repository

import com.ccarvalho.domain.Revenue
import com.ccarvalho.domain.views.DefaultEntityIdView
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface RevenueRepository : JpaRepository<Revenue, Long> {

    @Query("SELECT r.id FROM Revenue r WHERE r.description = ?1 AND MONTH(r.createdDate) = ?2")
    fun findRevenueByDescriptionAndMonth(description: String, month: Int): List<DefaultEntityIdView>

    fun findAllByDescriptionContainsIgnoreCase(description: String, pageable: Pageable): Page<Revenue>

    @Query("SELECT r FROM Revenue r WHERE YEAR(r.createdDate) = ?1 AND MONTH(r.createdDate) = ?2")
    fun findByYearAndMonth(year: Int, month: Int): List<Revenue>

    @Query("SELECT SUM(r.value) FROM Revenue r  WHERE YEAR(r.createdDate) = ?1 AND MONTH(r.createdDate) = ?2")
    fun sumByYearAndMonth(year: Int, month: Int): Double

}