package br.com.rmbrito.kotlinforum.service

import br.com.rmbrito.kotlinforum.domain.Topic
import br.com.rmbrito.kotlinforum.dto.request.TopicRequest
import br.com.rmbrito.kotlinforum.dto.response.TopicResponse
import br.com.rmbrito.kotlinforum.mapper.TopicRequestMapper
import br.com.rmbrito.kotlinforum.mapper.TopicResponseMapper
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),

    private val topicResponseMapper: TopicResponseMapper,
    private val topicRequestMapper: TopicRequestMapper
) {

    fun toList(): List<TopicResponse> {
        return topics.stream().map { t ->
            topicResponseMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun getById(id: Long): TopicResponse {
        val topic = topics.stream().filter { t ->
            t.id == id
        }.findFirst().get()

        return topicResponseMapper.map(topic)
    }

    fun createTopic(topicRequest: TopicRequest) {
        val topic = topicRequestMapper.map(topicRequest)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
    }
}