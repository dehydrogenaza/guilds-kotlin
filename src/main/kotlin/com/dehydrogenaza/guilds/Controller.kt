package com.dehydrogenaza.guilds

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/intake")
class IntakeController(
    private val service: IntakeService,
) {
    @GetMapping("/{date}")
    fun getReport(
        @PathVariable date: String,
    ): ResponseEntity<IntakeDto> {
        val (err, dto) = service.getReport(date)

        return when {
            err != null -> ResponseEntity(HttpStatus.NOT_FOUND)
            dto != null -> ResponseEntity.ok(dto)
            else -> ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }


    @PostMapping("/{volumeInMl}/{type}")
    fun postDrinkToday(
        @PathVariable volumeInMl: Int,
        @PathVariable type: String,
    ): ResponseEntity<Intake> {
        return service.addDrinkToday(volumeInMl, type)
            ?.let { ResponseEntity(it, HttpStatus.CREATED) }
            ?: ResponseEntity(HttpStatus.BAD_REQUEST)
    }
}