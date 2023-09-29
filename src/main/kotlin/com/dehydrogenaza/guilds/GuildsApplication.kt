package com.dehydrogenaza.guilds

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GuildsApplication

fun main() {
    runApplication<GuildsApplication>()

    println("Hello Guilds")
}
