package org.strotmann.ontologies.partner
class Adresse  {
    Integer postleitzahl
    String ort
    String strasse
    Integer hausnummer
    String hausnummerZusatz
    static constraints = {
      postleitzahl()
      ort()
      strasse()
      hausnummer()
      hausnummerZusatz(nullable:true)
    }
    String toString() {"${this.postleitzahl } ${this.ort } ${this.strasse } ${this.hausnummer }     "}
}
