package br.com.rmbrito.kotlinforum.dto.response

import br.com.rmbrito.kotlinforum.domain.StatusTopic
import java.time.LocalDateTime

data class TopicResponse(
    val id: Long?,
    val title: String,
    val message: String,
    val status: StatusTopic,
    val dateCreate: LocalDateTime
)
