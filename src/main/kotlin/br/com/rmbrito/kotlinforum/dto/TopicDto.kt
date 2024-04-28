package br.com.rmbrito.kotlinforum.dto

data class TopicDto(
    val title: String,
    val message: String,
    val idCourse: Long,
    val idAuthor: Long
)