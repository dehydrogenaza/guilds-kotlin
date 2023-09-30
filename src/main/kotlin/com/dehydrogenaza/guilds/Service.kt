package com.dehydrogenaza.guilds

import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.format.DateTimeParseException

@Service
class IntakeService(
    val intakeRepo: IntakeRepo,
    val drinkRepo: DrinkRepo,
    val converter: IntakeConverter,
) : Converter<Intake, IntakeDto> by converter {
    infix fun reportFor(date: String): IntakeWrapper {
        return try {
            LocalDate.parse(date)
                    .let { intakeRepo.findByReportDate(it) }
                    .wrap()
        } catch (e: DateTimeParseException) {
            IntakeWrapper(
                err = "'$date' is not a valid date."
            )
        }.also { println(it) }
    }


    private fun Intake?.wrap(): IntakeWrapper {
        return IntakeWrapper(
                err = this.toError(),
                dto = this.toDto(),
        )
    }


    fun addDrinkToday(volumeInMl: Int, type: String?): Intake? {
        val today = LocalDate.now()

        val intake: Intake = intakeRepo.findByReportDate(today)
            ?: intakeRepo.save(Intake())

        val drink = drinkRepo.save(Drink(volumeInMl, type, intake))
        intake.drinks += drink

        return intakeRepo.saveAndFlush(intake)
    }

}
