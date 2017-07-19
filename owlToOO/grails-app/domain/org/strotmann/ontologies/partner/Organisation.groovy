package org.strotmann.ontologies.partner
class Organisation extends Partner {
    String branche
    String rechtsform
    static constraints = {
      branche(inList:['Handel', 'Medien', 'Versorgung', 'Transport', 'Informationstechnik', 'Finanzwesen', 'Bergbau'],nullable:true)
      rechtsform(inList:['GmbH&CO_KG', 'oHG', 'GmbH', 'e.V.'],nullable:true)
    }
}
