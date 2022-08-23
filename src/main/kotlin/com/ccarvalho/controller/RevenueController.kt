package com.ccarvalho.controller

import com.ccarvalho.domain.Revenue
import com.ccarvalho.service.RevenueService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

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

}