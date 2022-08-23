package com.ccarvalho.service

import com.ccarvalho.domain.views.ResumeByYearAndMonth
import com.ccarvalho.repository.ExpenseRepository
import com.ccarvalho.repository.RevenueRepository
import org.springframework.stereotype.Service

@Service
class ResumeService(
    private val expenseRepository: ExpenseRepository,
    private val revenueRepository: RevenueRepository
) {

    fun resumeByYearAndMonth(year: Int, month: Int): ResumeByYearAndMonth {
        val totalRevenue = revenueRepository.sumByYearAndMonth(year, month)
        val totalExpense = expenseRepository.sumByYearAndMonth(year, month)
        val balance = totalRevenue - totalExpense
        val expenseByCategory = expenseRepository.sumByYearAndMonthGroupByCategory(year, month)

        return ResumeByYearAndMonth(
            totalReceipt = totalRevenue,
            totalExpense = totalExpense,
            balance = balance,
            expenseByCategory = expenseByCategory
        )
    }

}