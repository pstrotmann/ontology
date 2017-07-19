<%@ page import="org.strotmann.ontologies.partner.Partner" %>



<div class="fieldcontain ${hasErrors(bean: partnerInstance, field: 'adresse', 'error')} ">
	<label for="adresse">
		<g:message code="partner.adresse.label" default="Adresse" />
		
	</label>
	<g:select id="adresse" name="adresse.id" from="${org.strotmann.ontologies.partner.Adresse.list()}" optionKey="id" value="${partnerInstance?.adresse?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: partnerInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="partner.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${partnerInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: partnerInstance, field: 'bankverbindung', 'error')} ">
	<label for="bankverbindung">
		<g:message code="partner.bankverbindung.label" default="Bankverbindung" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${partnerInstance?.bankverbindung?}" var="b">
    <li><g:link controller="bankverbindung" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="bankverbindung" action="create" params="['partner.id': partnerInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'bankverbindung.label', default: 'Bankverbindung')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: partnerInstance, field: 'kommunikation', 'error')} ">
	<label for="kommunikation">
		<g:message code="partner.kommunikation.label" default="Kommunikation" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${partnerInstance?.kommunikation?}" var="k">
    <li><g:link controller="kommunikation" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="kommunikation" action="create" params="['partner.id': partnerInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'kommunikation.label', default: 'Kommunikation')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: partnerInstance, field: 'rolle', 'error')} ">
	<label for="rolle">
		<g:message code="partner.rolle.label" default="Rolle" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${partnerInstance?.rolle?}" var="r">
    <li><g:link controller="rolle" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="rolle" action="create" params="['partner.id': partnerInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'rolle.label', default: 'Rolle')])}</g:link>
</li>
</ul>


</div>

