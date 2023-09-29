package com.dehydrogenaza.guilds

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import java.time.LocalDate

@MappedSuperclass
abstract class BaseEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0
)



@Entity
@NamedEntityGraph(
    name = "intake_graph", attributeNodes = [
        NamedAttributeNode("drinks"),
    ]
)
class Intake(
    var reportDate: LocalDate,

    @OneToMany(mappedBy = "intake")
    @JsonManagedReference
    var drinks: MutableList<Drink>
) : BaseEntity()




@Entity
class Drink(
    var volumeInMl: Int,

    var type: String? = "water",

    @ManyToOne
    @JsonBackReference
    var intake: Intake,
) : BaseEntity()
