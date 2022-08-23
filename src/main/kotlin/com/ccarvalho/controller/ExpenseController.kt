package com.ccarvalho.controller

import com.ccarvalho.domain.Expense
import com.ccarvalho.service.ExpenseService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/despesas", "/expenses"])
class ExpenseController(expenseService: ExpenseService): AbstractController<Expense, ExpenseService>(expenseService)