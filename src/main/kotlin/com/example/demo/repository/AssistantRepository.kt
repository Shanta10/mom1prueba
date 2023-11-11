package com.example.demo.repository

import com.example.demo.model.Conference
import com.example.demo.model.Assistant
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AssistantRepository : JpaRepository<Assistant, Long?> {

    fun findById (id: Long?): Assistant?
}