package com.ccarvalho.validator

import com.ccarvalho.domain.Expense
import org.springframework.stereotype.Component

@Component
class ExpenseValidator: AbstractValidatorImpl<Expense>()