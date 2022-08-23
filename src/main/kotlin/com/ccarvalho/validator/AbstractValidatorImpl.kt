package com.ccarvalho.validator

import com.ccarvalho.domain.DefaultEntity
import com.ccarvalho.exception.GenericServiceException
import org.slf4j.LoggerFactory

abstract class AbstractValidatorImpl<E: DefaultEntity>: AbstractValidator<E> {

    private val Log = LoggerFactory.getLogger(AbstractValidatorImpl::class.java)

    override fun validateUpdate(id: Long, entity: E) {
        if(entity.id == null || id != entity.id){
            throw GenericServiceException("The.Id.Must.Be.Equals.To.Entity.Id")
        }
    }

    override fun validateInsert(entity: E) {
        Log.info("This method has no default implementation")
    }
}