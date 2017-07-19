package org.strotmann.ontologies.partner
class Rolle  {
    static belongsTo = [partner:Partner]
    String rollenname
    static constraints = {
      rollenname(inList:['Student', 'Besteller', 'Kreditnehmer', 'Kontoinhaber', 'Angestellter', 'Zahlungsempfänger', 'Mieter', 'Kunde', 'Auftragnehmer', 'Geschädigter', 'Lieferant', 'Patient', 'Vertreter', 'verletzte_Person', 'Käufer', 'Verkäufer', 'Gutachter', 'Dozent', 'Ansprechpartner', 'Vermieter', 'Bewerber', 'Beitragszahler', 'Anspruchsteller', 'Auftraggeber', 'versicherte_Person'],nullable:true)
    }
    String toString() {"${this.rollenname }     "}
}
