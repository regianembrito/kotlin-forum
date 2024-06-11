package br.com.rmbrito.kotlinforum.service

import br.com.rmbrito.kotlinforum.domain.Topic
import br.com.rmbrito.kotlinforum.dto.request.TopicRequest
import br.com.rmbrito.kotlinforum.dto.request.TopicUpdateRequest
import br.com.rmbrito.kotlinforum.dto.response.TopicResponse
import br.com.rmbrito.kotlinforum.exception.NotFoundException
import br.com.rmbrito.kotlinforum.mapper.TopicRequestMapper
import br.com.rmbrito.kotlinforum.mapper.TopicResponseMapper
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val topicResponseMapper: TopicResponseMapper,
    private val topicRequestMapper: TopicRequestMapper,
    private val notFoundMessage: String = "Topic not founded."
) {

    fun toList(): List<TopicResponse> {
        return topics.stream().map { t ->
            topicResponseMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun getById(id: Long): TopicResponse {
        val topic = topics.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow { NotFoundException(notFoundMessage) }

        return topicResponseMapper.map(topic)
    }

    fun createTopic(topicRequest: TopicRequest): TopicResponse {
        val topic = topicRequestMapper.map(topicRequest)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)

        return topicResponseMapper.map(topic)
    }

    fun updateTopic(topicUpdateRequest: TopicUpdateRequest): TopicResponse {
        val topic = topics.stream().filter { t ->
            t.id == topicUpdateRequest.id
        }.findFirst().orElseThrow { NotFoundException(notFoundMessage) }

        val updatedTopic = Topic(
            id = topicUpdateRequest.id,
            title = topicUpdateRequest.title,
            message = topicUpdateRequest.message,
            author = topic.author,
            course = topic.course,
            answers = topic.answers,
            status = topic.status,
            dateCreate = topic.dateCreate
        )

        topics = topics.minus(topic).plus(updatedTopic)

        return topicResponseMapper.map(updatedTopic)
    }

    fun deleteTopic(id: Long) {
        val topic = topics.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow { NotFoundException(notFoundMessage) }

        topics = topics.minus(topic)
    }
}