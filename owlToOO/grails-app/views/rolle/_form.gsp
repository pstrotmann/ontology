<%@ page import="org.strotmann.ontologies.partner.Rolle" %>



<div class="fieldcontain ${hasErrors(bean: rolleInstance, field: 'rollenname', 'error')} ">
	<label for="rollenname">
		<g:message code="rolle.rollenname.label" default="Rollenname" />
		
	</label>
	<g:select name="rollenname" from="${rolleInstance.constraints.rollenname.inList}" value="${rolleInstance?.rollenname}" valueMessagePrefix="rolle.rollenname" noSelection="['': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rolleInstance, field: 'partner', 'error')} required">
	<label for="partner">
		<g:message code="rolle.partner.label" default="Partner" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="partner" name="partner.id" from="${org.strotmann.ontologies.partner.Partner.list()}" optionKey="id" required="" value="${rolleInstance?.partner?.id}" class="many-to-one"/>

</div>

