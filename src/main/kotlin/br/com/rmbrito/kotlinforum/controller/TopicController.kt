package br.com.rmbrito.kotlinforum.controller

import br.com.rmbrito.kotlinforum.domain.Topic
import br.com.rmbrito.kotlinforum.service.TopicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun lista(): List<Topic> {
        return service.toList()

    }
}