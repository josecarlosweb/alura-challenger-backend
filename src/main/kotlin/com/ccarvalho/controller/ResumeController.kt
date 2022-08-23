package com.ccarvalho.controller

import com.ccarvalho.domain.views.ResumeByYearAndMonth
import com.ccarvalho.service.ResumeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/resumo", "/resume"])
class ResumeController(
    private val resumeService: ResumeService
) {

    @GetMapping("/{year}/{month}")
    fun getResumeByYearAndMonth(
        @PathVariable("year") year: Int,
        @PathVariable("month") month: Int
    ): ResumeByYearAndMonth {
        return resumeService.resumeByYearAndMonth(year, month)
    }

}