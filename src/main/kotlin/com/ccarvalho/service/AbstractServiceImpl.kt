package com.ccarvalho.service

import com.ccarvalho.domain.DefaultEntity
import com.ccarvalho.validator.AbstractValidator
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

abstract class AbstractServiceImpl<E : DefaultEntity, V : AbstractValidator<E>, R : JpaRepository<E, Long>>(
    private val repository: R,
    private val validator: V
) : AbstractService<E> {

    protected open fun preCreate(entity: E) {
        validator.validateInsert(entity)
    }

    protected open fun preUpdate(id: Long, entity: E){
        validator.validateUpdate(id, entity)
    }

    override fun create(entity: E): E {
        preCreate(entity)
        return repository.save(entity)
    }

    override fun create(entities: Collection<E>) {
        entities.toList()
            .forEach { entity ->
                preCreate(entity)
                create(entity)
            }
    }

    override fun update(id: Long, entity: E): E {
        preUpdate(id, entity)
        return repository.save(entity)
    }

    override fun findAll(pageable: Pageable) = repository.findAll(pageable)

    override fun findById(id: Long) = repository.findById(id)

    override fun deleteById(id: Long) = repository.deleteById(id)
}