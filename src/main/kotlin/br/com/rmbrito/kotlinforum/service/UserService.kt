package br.com.rmbrito.kotlinforum.service

import br.com.rmbrito.kotlinforum.domain.Course
import br.com.rmbrito.kotlinforum.domain.User
import org.springframework.stereotype.Service

@Service
class UserService(private var users: List<User> = ArrayList()) {

    init {
        val user = User(
            id = 1,
            name = "Iêda Brito",
            email = "iedabrito@gmail.com"
        )
        users = listOf(user)
    }

    fun toList(): List<User> {
        return users
    }

    fun getById(id: Long): User {
        return users.stream().filter {
            it.id == id
        }.findFirst().get()
    }

    fun createCourse(user: User) {
        users.plus(user)
    }

}
