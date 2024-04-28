package br.com.rmbrito.kotlinforum.service

import br.com.rmbrito.kotlinforum.domain.Topic
import br.com.rmbrito.kotlinforum.dto.TopicDto
import org.springframework.stereotype.Service
import kotlin.collections.ArrayList

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val courseService: CourseService,
    private val userService: UserService
) {

    fun toList(): List<Topic> {
        return topics
    }

    fun getById(id: Long): Topic {
        return topics.stream().filter { it ->
            it.id == id
        }.findFirst().get()
    }

    fun createTopic(topicDto: TopicDto) {
        topics = topics.plus(
            Topic(
                id = topics.size.toLong() + 1,
                title = topicDto.title,
                message = topicDto.message,
                course = courseService.getById(topicDto.idCourse),
                author = userService.getById(topicDto.idAuthor)
            )
        )
    }
}