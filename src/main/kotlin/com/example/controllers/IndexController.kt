package com.example.controllers

import com.example.repositories.UserRepository
import io.ktor.server.application.ApplicationCall
import io.ktor.server.request.receive
import io.ktor.server.response.respond

class IndexController(private val userRepository: UserRepository) {
    suspend fun index(call: ApplicationCall) {
        val users = userRepository.getAllUsers()
        call.respond(users)
    }

    suspend fun post(call: ApplicationCall) {
        val user = userRepository.createUser(call.receive())
        call.respond(user)
    }
}