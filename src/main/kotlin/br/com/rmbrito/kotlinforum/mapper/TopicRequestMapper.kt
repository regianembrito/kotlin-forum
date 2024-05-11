package br.com.rmbrito.kotlinforum.mapper

import br.com.rmbrito.kotlinforum.domain.Topic
import br.com.rmbrito.kotlinforum.dto.request.TopicRequest
import br.com.rmbrito.kotlinforum.service.CourseService
import br.com.rmbrito.kotlinforum.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicRequestMapper(
    private val courseService: CourseService,
    private val userService: UserService
) : Mapper<TopicRequest, Topic> {
    override fun map(t: TopicRequest): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            course = courseService.getById(t.idCourse),
            author = userService.getById(t.idAuthor)
        )
    }
}