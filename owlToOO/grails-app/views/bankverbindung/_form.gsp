<%@ page import="org.strotmann.ontologies.partner.Bankverbindung" %>



<div class="fieldcontain ${hasErrors(bean: bankverbindungInstance, field: 'iban', 'error')} required">
	<label for="iban">
		<g:message code="bankverbindung.iban.label" default="Iban" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="iban" required="" value="${bankverbindungInstance?.iban}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: bankverbindungInstance, field: 'bic', 'error')} ">
	<label for="bic">
		<g:message code="bankverbindung.bic.label" default="Bic" />
		
	</label>
	<g:textField name="bic" value="${bankverbindungInstance?.bic}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: bankverbindungInstance, field: 'partner', 'error')} required">
	<label for="partner">
		<g:message code="bankverbindung.partner.label" default="Partner" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="partner" name="partner.id" from="${org.strotmann.ontologies.partner.Partner.list()}" optionKey="id" required="" value="${bankverbindungInstance?.partner?.id}" class="many-to-one"/>

</div>

