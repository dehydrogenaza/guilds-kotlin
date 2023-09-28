package com.dehydrogenaza.guilds

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GuildsApplication

fun main(args: Array<String>) {
    runApplication<GuildsApplication>(*args)

    println("Hello Guilds")
}
