package com.ccarvalho.controller

import com.ccarvalho.domain.DefaultEntity
import com.ccarvalho.service.AbstractService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import javax.validation.constraints.NotEmpty

@Validated
abstract class AbstractController<E : DefaultEntity, S : AbstractService<E>>(
    private val service: S
) {

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Long): ResponseEntity<E> {
        val findByIdOptional = service.findById(id)
        return if(findByIdOptional.isPresent){
            ResponseEntity(findByIdOptional.get(), HttpStatus.OK)
        }else{
            ResponseEntity(HttpStatus.NO_CONTENT)
        }
    }

    @GetMapping
    fun findAll(@RequestParam(defaultValue = "0") page: Int, @RequestParam(defaultValue = "50") size: Int): Page<E> {
        val pageable = PageRequest.of(page, size)
        return service.findAll(pageable)
    }

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

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable("id") id: Long): ResponseEntity<E>{
        service.deleteById(id)
        return ResponseEntity(HttpStatus.OK)
    }

}