package com.ccarvalho.repository

import com.ccarvalho.domain.Expense
import com.ccarvalho.domain.views.DefaultEntityIdView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ExpenseRepository: JpaRepository<Expense, Long>{

    @Query("SELECT e.id FROM Expense e WHERE e.description = ?1 AND MONTH(e.createdDate) = ?2")
    fun findRevenueByDescriptionAndMonth(description: String, month: Int): List<DefaultEntityIdView>

}