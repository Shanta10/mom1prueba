package com.example.demo.model

import jakarta.persistence.*

@Entity
@Table(name = "assistant")
class Assistant {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var nameassistant: String? = null
    var roleassistant: String? = null
    var ageassistant: Int? = null
    @Column (name="conference_id")
    var conferenceId: Long? = null
}