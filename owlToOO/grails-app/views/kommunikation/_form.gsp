<%@ page import="org.strotmann.ontologies.partner.Kommunikation" %>



<div class="fieldcontain ${hasErrors(bean: kommunikationInstance, field: 'anwahl', 'error')} required">
	<label for="anwahl">
		<g:message code="kommunikation.anwahl.label" default="Anwahl" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="anwahl" required="" value="${kommunikationInstance?.anwahl}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: kommunikationInstance, field: 'kommunikationstyp', 'error')} ">
	<label for="kommunikationstyp">
		<g:message code="kommunikation.kommunikationstyp.label" default="Kommunikationstyp" />
		
	</label>
	<g:select name="kommunikationstyp" from="${kommunikationInstance.constraints.kommunikationstyp.inList}" value="${kommunikationInstance?.kommunikationstyp}" valueMessagePrefix="kommunikation.kommunikationstyp" noSelection="['': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: kommunikationInstance, field: 'partner', 'error')} required">
	<label for="partner">
		<g:message code="kommunikation.partner.label" default="Partner" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="partner" name="partner.id" from="${org.strotmann.ontologies.partner.Partner.list()}" optionKey="id" required="" value="${kommunikationInstance?.partner?.id}" class="many-to-one"/>

</div>

