package org.strotmann.ontologies.partner
class Partner  {
    static mapping = {tablePerHierarchy false}
    static hasMany=[bankverbindung:Bankverbindung, kommunikation:Kommunikation, rolle:Rolle]
    String name
    Adresse adresse
    static constraints = {
      name()
      adresse(nullable:true)
    }
    String toString() {"${this.name }     "}
}
