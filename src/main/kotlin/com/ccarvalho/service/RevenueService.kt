package com.ccarvalho.service

import com.ccarvalho.domain.Revenue
import com.ccarvalho.repository.RevenueRepository
import com.ccarvalho.validator.RevenueValidator
import org.springframework.stereotype.Service

@Service
class RevenueService(
    private val repository: RevenueRepository,
    private val validator: RevenueValidator
): AbstractServiceImpl<Revenue, RevenueValidator, RevenueRepository>(repository, validator) {

}