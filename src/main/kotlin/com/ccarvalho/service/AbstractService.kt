package com.ccarvalho.service

import com.ccarvalho.domain.DefaultEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

interface AbstractService<E: DefaultEntity> {

    fun create(entity: E): E

    fun create(entities: Collection<E>)

    fun update(id: Long, entity: E): E

    fun findAll(pageable: Pageable): Page<E>

    fun findById(id: Long): Optional<E>

}