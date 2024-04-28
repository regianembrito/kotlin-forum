package br.com.rmbrito.kotlinforum.service

import br.com.rmbrito.kotlinforum.domain.Course
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

@Service
class CourseService(private var courses: List<Course> = ArrayList()) {

    init {
        val course = Course(
            id = 1,
            name = "Kotlin REST API",
            category = "Development"
        )
        courses = listOf(course)
    }

    fun toList(): List<Course> {
        return courses
    }

    fun getById(id: Long): Course {
        return courses.stream().filter {
            it.id == id
        }.findFirst().get()
    }

    fun createCourse(course: Course) {
        courses.plus(course)
    }
}