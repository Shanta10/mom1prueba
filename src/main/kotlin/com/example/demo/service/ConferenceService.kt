package com.example.demo.service

import com.example.demo.model.Conference
import com.example.demo.repository.ConferenceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.server.ResponseStatusException

@Service
class ConferenceService {
    @Autowired
    lateinit var conferenceRepository: ConferenceRepository

    fun list ():List<Conference>{
        return conferenceRepository.findAll()
    }
    fun save(conference: Conference): Conference {
        try{
            conference.tittleconf?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Titulo no debe ser vacio")

            conference.descriptionconf?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Descripcion no debe ser vacio")

            conference.cityconf?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Ciudad no debe ser vacio")

            return conferenceRepository.save(conference)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.BAD_REQUEST,ex.message)
        }
    }
    fun update(conference: Conference): Conference{
        try {
            conferenceRepository.findById(conference.id)
                ?: throw Exception("ID no existe")

            return conferenceRepository.save(conference)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updateName(conference: Conference): Conference{
        try{
            val response = conferenceRepository.findById(conference.id)
                ?: throw Exception("ID no existe")
            response.apply {
                tittleconf=conference.tittleconf
            }
            return conferenceRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):Conference?{
        return conferenceRepository.findById(id)
    }
    fun delete (id: Long?):Boolean?{
        try{
            val response = conferenceRepository.findById(id)
                ?: throw Exception("ID no existe")
            conferenceRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}