package com.ccarvalho.domain.views

import com.ccarvalho.domain.ExpenseCategory

data class ResumeByYearAndMonth(
    val totalReceipt: Double = 0.0,
    val totalExpense: Double = 0.0,
    val balance: Double = 0.0,
    val expenseByCategory: List<ExpenseByCategory>
)

interface ExpenseByCategory {
    var total: Double?
    var category: ExpenseCategory?
}