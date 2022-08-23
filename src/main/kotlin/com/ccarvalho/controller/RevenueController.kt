package com.ccarvalho.controller

import com.ccarvalho.domain.Revenue
import com.ccarvalho.service.RevenueService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/receitas", "/receipts"])
class RevenueController(
    private val revenueService: RevenueService
) : AbstractController<Revenue, RevenueService>(revenueService) {

    @GetMapping(params = ["page", "size", "description"])
    fun findAllByDescription(
        @RequestParam(required = false, defaultValue = "0") page: Int,
        @RequestParam(required = false, defaultValue = "50") size: Int,
        @RequestParam description: String
    ): Page<Revenue> {
        val pageable = PageRequest.of(page, size)
        return if (description.isNotBlank()) {
            revenueService.findByDescription(description, pageable)
        } else {
            revenueService.findAll(pageable)
        }
    }

    @GetMapping("/{year}/{month}")
    fun findAllByYearAndMonth(@PathVariable("year") year: Int, @PathVariable("month") month: Int): ResponseEntity<List<Revenue>> {
        return ResponseEntity(revenueService.findByYearAndMonth(year, month), HttpStatus.OK)
    }

}