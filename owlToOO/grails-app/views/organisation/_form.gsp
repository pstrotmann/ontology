<%@ page import="org.strotmann.ontologies.partner.Organisation" %>



<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'adresse', 'error')} ">
	<label for="adresse">
		<g:message code="organisation.adresse.label" default="Adresse" />
		
	</label>
	<g:select id="adresse" name="adresse.id" from="${org.strotmann.ontologies.partner.Adresse.list()}" optionKey="id" value="${organisationInstance?.adresse?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="organisation.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${organisationInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'branche', 'error')} ">
	<label for="branche">
		<g:message code="organisation.branche.label" default="Branche" />
		
	</label>
	<g:select name="branche" from="${organisationInstance.constraints.branche.inList}" value="${organisationInstance?.branche}" valueMessagePrefix="organisation.branche" noSelection="['': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'rechtsform', 'error')} ">
	<label for="rechtsform">
		<g:message code="organisation.rechtsform.label" default="Rechtsform" />
		
	</label>
	<g:select name="rechtsform" from="${organisationInstance.constraints.rechtsform.inList}" value="${organisationInstance?.rechtsform}" valueMessagePrefix="organisation.rechtsform" noSelection="['': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'bankverbindung', 'error')} ">
	<label for="bankverbindung">
		<g:message code="organisation.bankverbindung.label" default="Bankverbindung" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${organisationInstance?.bankverbindung?}" var="b">
    <li><g:link controller="bankverbindung" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="bankverbindung" action="create" params="['organisation.id': organisationInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'bankverbindung.label', default: 'Bankverbindung')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'kommunikation', 'error')} ">
	<label for="kommunikation">
		<g:message code="organisation.kommunikation.label" default="Kommunikation" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${organisationInstance?.kommunikation?}" var="k">
    <li><g:link controller="kommunikation" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="kommunikation" action="create" params="['organisation.id': organisationInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'kommunikation.label', default: 'Kommunikation')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'rolle', 'error')} ">
	<label for="rolle">
		<g:message code="organisation.rolle.label" default="Rolle" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${organisationInstance?.rolle?}" var="r">
    <li><g:link controller="rolle" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="rolle" action="create" params="['organisation.id': organisationInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'rolle.label', default: 'Rolle')])}</g:link>
</li>
</ul>


</div>

