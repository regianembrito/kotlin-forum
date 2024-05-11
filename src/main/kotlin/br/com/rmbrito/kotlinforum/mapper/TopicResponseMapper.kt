package br.com.rmbrito.kotlinforum.mapper

import br.com.rmbrito.kotlinforum.domain.Topic
import br.com.rmbrito.kotlinforum.dto.response.TopicResponse
import org.springframework.stereotype.Component

@Component
class TopicResponseMapper : Mapper<Topic, TopicResponse> {
    override fun map(t: Topic): TopicResponse {
        return TopicResponse(
            id = t.id,
            title = t.title,
            message = t.message,
            dateCreate = t.dateCreate,
            status = t.status
        )
    }
}