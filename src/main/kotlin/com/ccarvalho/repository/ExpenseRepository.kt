package com.ccarvalho.repository

import com.ccarvalho.domain.Expense
import com.ccarvalho.domain.views.DefaultEntityIdView
import com.ccarvalho.domain.views.ExpenseByCategory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ExpenseRepository : JpaRepository<Expense, Long> {

    @Query("SELECT e.id FROM Expense e WHERE e.description = ?1 AND MONTH(e.createdDate) = ?2")
    fun findRevenueByDescriptionAndMonth(description: String, month: Int): List<DefaultEntityIdView>

    fun findAllByDescriptionContainsIgnoreCase(description: String, pageable: Pageable): Page<Expense>

    @Query("SELECT e FROM Expense e WHERE YEAR(e.createdDate) = ?1 AND MONTH(e.createdDate) = ?2")
    fun findByYearAndMonth(year: Int, month: Int): List<Expense>

    @Query("SELECT SUM(e.value) FROM Expense e  WHERE YEAR(e.createdDate) = ?1 AND MONTH(e.createdDate) = ?2")
    fun sumByYearAndMonth(year: Int, month: Int): Double

    @Query("SELECT SUM(e.value) AS total, e.category AS category FROM Expense e WHERE YEAR(e.createdDate) = ?1 AND MONTH(e.createdDate) = ?2 GROUP BY e.category")
    fun sumByYearAndMonthGroupByCategory(year: Int, month: Int): List<ExpenseByCategory>

}