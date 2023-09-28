package com.dehydrogenaza.guilds

import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType.LOAD
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface IntakeRepo : JpaRepository<Intake, Long> {
    @EntityGraph(type = LOAD, value = "intake_graph")
    fun findByReportDate(date: LocalDate): Intake?
}

@Repository
interface DrinkRepo : JpaRepository<Drink, Long>