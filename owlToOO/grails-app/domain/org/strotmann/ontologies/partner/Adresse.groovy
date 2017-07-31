package org.strotmann.ontologies.partner
class Adresse  {
    static hasMany=[partner:Partner]
    Integer hausnummer
    String ort
    Integer postleitzahl
    String strasse
    String hausnummerZusatz
    static constraints = {
      hausnummer()
      ort()
      postleitzahl()
      strasse()
      hausnummerZusatz(nullable:true)
    }
    String toString() {"${this.hausnummer } ${this.ort } ${this.postleitzahl } ${this.strasse }     "}
}
