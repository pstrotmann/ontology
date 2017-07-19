package org.strotmann.ontologies.partner
class Bankverbindung  {
    static belongsTo = [partner:Partner]
    String iban
    String bic
    static constraints = {
      iban()
      bic(nullable:true)
    }
    String toString() {"${this.iban }     "}
}
