package br.com.rmbrito.kotlinforum.controller

import br.com.rmbrito.kotlinforum.dto.request.TopicRequest
import br.com.rmbrito.kotlinforum.dto.request.TopicUpdateRequest
import br.com.rmbrito.kotlinforum.dto.response.TopicResponse
import br.com.rmbrito.kotlinforum.service.TopicService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

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
    fun createTopic(
        @RequestBody @Valid topicRequest: TopicRequest,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicResponse> {
        val topicResponse = service.createTopic(topicRequest)
        val uri = uriBuilder.path("/topics/${topicResponse.id}").build().toUri()

        return ResponseEntity.created(uri).body(topicResponse)
    }

    @PutMapping
    fun updateTopic(@RequestBody @Valid topicUpdateRequest: TopicUpdateRequest): ResponseEntity<TopicResponse> {
        val topicResponse = service.updateTopic(topicUpdateRequest)
        return ResponseEntity.ok(topicResponse)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTopic(@PathVariable id: Long) {
        service.deleteTopic(id)
    }
}