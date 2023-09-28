package com.dehydrogenaza.guilds

import java.time.LocalDate

data class IntakeWrapper(
    val err: String? = null,
    val dto: IntakeDto? = null,
)

class IntakeDto {
    lateinit var date: LocalDate
    lateinit var drinks: List<String>
    lateinit var totalLiquid: String

    companion object {
        fun builder(init: IntakeDto.() -> Unit): IntakeDto {
            val dto = IntakeDto()
            dto.init()
            return dto
        }
    }
}
