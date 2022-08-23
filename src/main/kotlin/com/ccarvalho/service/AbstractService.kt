package com.ccarvalho.service

import com.ccarvalho.domain.DefaultEntity

interface AbstractService<E: DefaultEntity> {

    fun create(entity: E): E

    fun create(entities: Collection<E>)

    fun update(id: Long, entity: E): E

}