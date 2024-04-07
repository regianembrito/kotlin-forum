package br.com.rmbrito.kotlinforum

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinForumApplication

fun main(args: Array<String>) {
	runApplication<KotlinForumApplication>(*args)
}
