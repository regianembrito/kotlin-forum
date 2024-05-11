package br.com.rmbrito.kotlinforum.mapper

interface Mapper<T, U> {

    fun map(t: T): U
}