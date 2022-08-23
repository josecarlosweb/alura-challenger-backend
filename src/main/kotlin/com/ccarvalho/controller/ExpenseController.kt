package com.ccarvalho.controller

import com.ccarvalho.domain.Expense
import com.ccarvalho.service.ExpenseService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/despesas", "/expenses"])
class ExpenseController(private val expenseService: ExpenseService) :
    AbstractController<Expense, ExpenseService>(expenseService) {

    @GetMapping(params = ["page", "size", "description"])
    fun findAllByDescription(
        @RequestParam(required = false, defaultValue = "0") page: Int,
        @RequestParam(required = false, defaultValue = "50") size: Int,
        @RequestParam description: String
    ): Page<Expense> {
        val pageable = PageRequest.of(page, size)
        return if (description.isNotBlank()) {
            expenseService.findByDescription(description, pageable)
        } else {
            expenseService.findAll(pageable)
        }
    }

    @GetMapping("/{year}/{month}")
    fun findAllByYearAndMonth(@PathVariable("year") year: Int, @PathVariable("month") month: Int): ResponseEntity<List<Expense>>{
        return ResponseEntity(expenseService.findByYearAndMonth(year, month), HttpStatus.OK)
    }
}