package br.com.rmbrito.kotlinforum.service

import br.com.rmbrito.kotlinforum.domain.Course
import br.com.rmbrito.kotlinforum.domain.StatusTopic
import br.com.rmbrito.kotlinforum.domain.Topic
import br.com.rmbrito.kotlinforum.domain.User
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import kotlin.collections.ArrayList

@Service
class TopicService {
    fun toList(): List<Topic> {
        val topic = Topic(
            id = 1,
            title = "Dúvida Kotlin",
            message = "Variaveis no Kotlin",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Desenvolvimento"
            ),
            author = User(
                id = 1,
                name = "Iêda",
                email = "ieda@gmail.com"
            ),
            status = StatusTopic.NOT_ANSWERED,
            answers = ArrayList(),
            dateCreate = LocalDateTime.now()
        )
        return listOf(topic, topic, topic)
    }
}