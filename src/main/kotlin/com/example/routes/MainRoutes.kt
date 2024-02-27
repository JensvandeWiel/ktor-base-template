package com.example.routes

import com.example.controllers.IndexController
import io.ktor.server.application.call
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import org.koin.ktor.ext.inject

fun Route.mainRoutes() {
    apiRoutes()


    val indexController: IndexController by inject()


    get {
        indexController.index(call)
    }

    post {
        indexController.post(call)
    }
}