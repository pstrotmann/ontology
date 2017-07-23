package org.strotmann.ontologies.partner
class Organisation extends Partner {
    String branche
    String rechtsform
    static constraints = {
      branche(inList:['Bergbau', 'Finanzwesen', 'Handel', 'Informationstechnik', 'Medien', 'Transport', 'Versorgung'],nullable:true)
      rechtsform(inList:['GmbH', 'GmbH&CO_KG', 'e.V.', 'oHG'],nullable:true)
    }
}
