package org.strotmann.ontologies.partner
class Rolle  {
    static belongsTo = [partner:Partner]
    String rollenname
    static constraints = {
      rollenname(inList:['Angestellter', 'Ansprechpartner', 'Anspruchsteller', 'Antragsteller', 'Auftraggeber', 'Auftragnehmer', 'Beitragszahler', 'Besteller', 'Bewerber', 'Dozent', 'Geschädigter', 'Gutachter', 'Kontoinhaber', 'Kreditnehmer', 'Kunde', 'Käufer', 'Lieferant', 'Mieter', 'Patient', 'Student', 'Verkäufer', 'Vermieter', 'Vertreter', 'Zahlungsempfänger', 'verletzte_Person', 'versicherte_Person'],nullable:true)
    }
    String toString() {"${this.rollenname }     "}
}
