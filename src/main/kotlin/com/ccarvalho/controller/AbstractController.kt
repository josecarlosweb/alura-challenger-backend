package com.ccarvalho.controller

import com.ccarvalho.domain.DefaultEntity
import com.ccarvalho.service.AbstractService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid
import javax.validation.constraints.NotEmpty

@Validated
abstract class AbstractController<E: DefaultEntity, S: AbstractService<E>>(
    private val service: S
){

    @PostMapping
    fun create(@Valid @RequestBody entity: E): ResponseEntity<E> {
        val created = service.create(entity)
        return ResponseEntity(created, HttpStatus.CREATED)
    }

    @PostMapping("/batch")
    fun create(@Valid @NotEmpty @RequestBody entities: Collection<E>): Collection<ResponseEntity<E>> {
        return entities.map { entity -> create(entity) }
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long, @Valid @RequestBody entity: E): ResponseEntity<E> {
        val updated = service.update(id, entity)
        return ResponseEntity(updated, HttpStatus.OK)
    }

}