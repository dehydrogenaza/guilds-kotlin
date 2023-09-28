package com.dehydrogenaza.guilds

import org.springframework.stereotype.Component

interface Converter<in S : BaseEntity, out T> {
    fun S?.toError(): String?
    fun S?.toDto(): T?
}

@Component
class IntakeConverter : Converter<Intake, IntakeDto> {
    override fun Intake?.toError(): String? {
        return if (this == null) "Could not find intake data." else null
    }

    override fun Intake?.toDto(): IntakeDto? {
        return this?.let {
            IntakeDto.builder {
                date = it.reportDate
                drinks = it.drinks.map (::toHeader)
                totalLiquid = "${it.drinks.totalLiquid} ml"
            }
        }
    }


    private fun toHeader(drink: Drink) =
        "${drink.volumeInMl} ml of ${drink.type}"


    private val Collection<Drink>.totalLiquid get() =
        this.fold(0) { acc, drink -> acc + drink.volumeInMl }
}