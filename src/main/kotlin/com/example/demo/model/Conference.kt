package com.example.proyecto.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "conference")
class Conference {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @NotBlank(message="Campo obligatorio") //validate
    var tittleconf: String? = null
    @NotBlank(message="Campo obligatorio") //validate
    var descriptionconf: String? = null
    @NotBlank(message="Campo obligatorio") //validate
    var cityconf: String? = null
    var totalassisconf: Int? = null
}