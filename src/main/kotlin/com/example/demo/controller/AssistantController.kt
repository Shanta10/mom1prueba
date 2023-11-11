package com.example.demo.controller

import com.example.demo.model.Conference
import com.example.demo.model.Assistant
import com.example.demo.service.AssistantService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/assistant")   //endpoint
class AssistantController {
    @Autowired
    lateinit var assistantService: AssistantService

    @GetMapping
    fun list ():List <Assistant>{
        return assistantService.list()
    }
    @PostMapping
    fun save (@RequestBody assistant: Assistant): ResponseEntity<Assistant> {
        return ResponseEntity(assistantService.save(assistant), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody assistant: Assistant): ResponseEntity<Assistant> {
        return ResponseEntity(assistantService.update(assistant), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody assistant: Assistant): ResponseEntity<Assistant> {
        return ResponseEntity(assistantService.updateName(assistant), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(assistantService.listById (id), HttpStatus.OK)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return assistantService.delete(id)
    }
}