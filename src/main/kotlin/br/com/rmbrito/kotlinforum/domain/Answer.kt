package br.com.rmbrito.kotlinforum.domain

import java.time.LocalDateTime

data class Answer(
    val id: Long?,
    val message: String,
    val dateCreate: LocalDateTime = LocalDateTime.now(),
    val author: User,
    val topic: Topic,
    val solution: Boolean
)
