package org.strotmann.ontologies.partner
class Kommunikation  {
    static belongsTo = [partner:Partner]
    String anwahl
    String kommunikationstyp
    static constraints = {
      anwahl()
      kommunikationstyp(inList:['Fax', 'Festnetz', 'Mobilphone', 'TwitterAccount', 'Webseite', 'eMail'],nullable:true)
    }
    String toString() {"${this.anwahl } ${this.kommunikationstyp }     "}
}
