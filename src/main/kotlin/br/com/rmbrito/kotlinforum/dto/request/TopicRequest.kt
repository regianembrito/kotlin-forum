package br.com.rmbrito.kotlinforum.dto.request

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class TopicRequest(
    @field:NotEmpty(message = "Título não deve estar vazio")
    @field:Size(min = 5, max = 100, message = "Tamanho deve ser entre 5 e 100")
    val title: String,
    @field:NotEmpty(message = "Message não deve estar vazio")
    @field:Size(min = 5, max = 100, message = "Tamanho deve ser entre 5 e 100")
    val message: String,
    @field:NotNull(message = "Curso não deve estar vazio")
    val idCourse: Long,
    @field:NotNull
    val idAuthor: Long
)