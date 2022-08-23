package com.ccarvalho.service

import com.ccarvalho.domain.Revenue
import com.ccarvalho.exception.GenericServiceException
import com.ccarvalho.repository.RevenueRepository
import com.ccarvalho.util.getMonthFromDate
import com.ccarvalho.validator.RevenueValidator
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class RevenueService(
    private val repository: RevenueRepository,
    private val validator: RevenueValidator
) : AbstractServiceImpl<Revenue, RevenueValidator, RevenueRepository>(repository, validator) {

    override fun preCreate(entity: Revenue) {
        val month = getMonthFromDate(entity.createdDate)
        val findExists = repository.findRevenueByDescriptionAndMonth(entity.description, month.toInt())
        if (findExists.isNotEmpty()) {
            throw GenericServiceException("Revenue.Is.Duplicated")
        }
        super.preCreate(entity)
    }

    fun findByDescription(descriptionExample: String, pageable: Pageable): Page<Revenue> =
        repository.findAllByDescriptionContainsIgnoreCase(descriptionExample, pageable)

    fun findByYearAndMonth(year: Int, month: Int) = repository.findByYearAndMonth(year, month)

}