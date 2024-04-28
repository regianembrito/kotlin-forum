package br.com.rmbrito.kotlinforum.controller

import br.com.rmbrito.kotlinforum.domain.Topic
import br.com.rmbrito.kotlinforum.dto.TopicDto
import br.com.rmbrito.kotlinforum.service.TopicService
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
    fun getTopics(): List<Topic> {
        return service.toList()

    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Topic {
        return service.getById(id)
    }

    @PostMapping
    fun createTopic(@RequestBody topicDto: TopicDto) {
        service.createTopic(topicDto)
    }

}