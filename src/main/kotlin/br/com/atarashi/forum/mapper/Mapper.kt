package br.com.atarashi.forum.mapper

interface Mapper<T, U> {

    fun map(t: T): U
}