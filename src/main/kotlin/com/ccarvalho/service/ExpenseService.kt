package com.ccarvalho.service

import com.ccarvalho.domain.Expense
import com.ccarvalho.exception.GenericServiceException
import com.ccarvalho.repository.ExpenseRepository
import com.ccarvalho.util.getMonthFromDate
import com.ccarvalho.validator.ExpenseValidator
import org.springframework.stereotype.Service

@Service
class ExpenseService(
    private val repository: ExpenseRepository,
    private val validator: ExpenseValidator
) : AbstractServiceImpl<Expense, ExpenseValidator, ExpenseRepository>(repository, validator) {

    override fun preCreate(entity: Expense) {
        val month = getMonthFromDate(entity.createdDate)
        val findExists = repository.findRevenueByDescriptionAndMonth(entity.description, month.toInt())
        if (findExists.isNotEmpty()) {
            throw GenericServiceException("Expense.Is.Duplicated")
        }
        super.preCreate(entity)
    }

}