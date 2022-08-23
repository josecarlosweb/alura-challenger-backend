package com.ccarvalho.controller

import com.ccarvalho.domain.Revenue
import com.ccarvalho.service.RevenueService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/receitas", "/receipts"])
class RevenueController(
    private val revenueService: RevenueService
): AbstractController<Revenue, RevenueService>(revenueService) {

}