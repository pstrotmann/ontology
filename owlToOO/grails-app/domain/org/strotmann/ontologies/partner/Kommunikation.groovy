package org.strotmann.ontologies.partner
class Kommunikation  {
    static belongsTo = [partner:Partner]
    String anwahl
    String kommunikationstyp
    static constraints = {
      anwahl()
      kommunikationstyp(inList:['Festnetz', 'Mobilphone', 'TwitterAccount', 'Fax', 'eMail', 'Webseite'],nullable:true)
    }
    String toString() {"${this.anwahl } ${this.kommunikationstyp }     "}
}
