package br.com.rmbrito.kotlinforum.controller

import br.com.rmbrito.kotlinforum.dto.request.TopicRequest
import br.com.rmbrito.kotlinforum.dto.response.TopicResponse
import br.com.rmbrito.kotlinforum.service.TopicService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun getTopics(): List<TopicResponse> {
        return service.toList()

    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): TopicResponse {
        return service.getById(id)
    }

    @PostMapping
    fun createTopic(@RequestBody @Valid topicRequest: TopicRequest) {
        service.createTopic(topicRequest)
    }

}