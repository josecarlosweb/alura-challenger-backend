package com.ccarvalho.validator

import com.ccarvalho.domain.DefaultEntity
import com.ccarvalho.exception.GenericServiceException

interface AbstractValidator<E: DefaultEntity> {

    @Throws(GenericServiceException::class)
    fun validateInsert(entity: E)

    @Throws(GenericServiceException::class)
    fun validateUpdate(id: Long, entity: E)


}