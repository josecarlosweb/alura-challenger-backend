package com.ccarvalho.domain

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Temporal
import javax.persistence.TemporalType
import javax.validation.constraints.Digits
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Entity
data class Expense(
    @field:NotEmpty @field:NotNull @Column(nullable = true) val description: String,

    @field:NotNull @field:Digits(integer = 12, fraction = 2) @Column(
        precision = 12,
        scale = 2,
        nullable = false
    ) val value: Double,

    @field:NotNull @Column(nullable = false) @Temporal(TemporalType.TIMESTAMP) val createdDate: Date
) : DefaultEntity()
