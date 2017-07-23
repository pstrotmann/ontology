package org.strotmann.ontologies.partner
class Person extends Partner {
    String vorname
    Date geburtsdatum
    String geschlecht
    static constraints = {
      vorname()
      geburtsdatum(nullable:true)
      geschlecht(inList:['Frau', 'Mann'],nullable:true)
    }
}
