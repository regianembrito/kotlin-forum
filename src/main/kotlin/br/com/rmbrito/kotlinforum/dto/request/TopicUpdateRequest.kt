package br.com.rmbrito.kotlinforum.dto.request

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class TopicUpdateRequest(
    @field:NotNull
    var id: Long,
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val title: String,
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val message: String,
)
