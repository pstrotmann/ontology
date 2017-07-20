<%@ page import="org.strotmann.ontologies.partner.Person" %>



<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="person.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${personInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'adresse', 'error')} ">
	<label for="adresse">
		<g:message code="person.adresse.label" default="Adresse" />
		
	</label>
	<g:select id="adresse" name="adresse.id" from="${org.strotmann.ontologies.partner.Adresse.list()}" optionKey="id" value="${personInstance?.adresse?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'vorname', 'error')} required">
	<label for="vorname">
		<g:message code="person.vorname.label" default="Vorname" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="vorname" required="" value="${personInstance?.vorname}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'geburtsdatum', 'error')} ">
	<label for="geburtsdatum">
		<g:message code="person.geburtsdatum.label" default="Geburtsdatum" />
		
	</label>
	<g:datePicker name="geburtsdatum" precision="day"  value="${personInstance?.geburtsdatum}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'geschlecht', 'error')} ">
	<label for="geschlecht">
		<g:message code="person.geschlecht.label" default="Geschlecht" />
		
	</label>
	<g:select name="geschlecht" from="${personInstance.constraints.geschlecht.inList}" value="${personInstance?.geschlecht}" valueMessagePrefix="person.geschlecht" noSelection="['': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'bankverbindung', 'error')} ">
	<label for="bankverbindung">
		<g:message code="person.bankverbindung.label" default="Bankverbindung" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${personInstance?.bankverbindung?}" var="b">
    <li><g:link controller="bankverbindung" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="bankverbindung" action="create" params="['person.id': personInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'bankverbindung.label', default: 'Bankverbindung')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'kommunikation', 'error')} ">
	<label for="kommunikation">
		<g:message code="person.kommunikation.label" default="Kommunikation" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${personInstance?.kommunikation?}" var="k">
    <li><g:link controller="kommunikation" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="kommunikation" action="create" params="['person.id': personInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'kommunikation.label', default: 'Kommunikation')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'rolle', 'error')} ">
	<label for="rolle">
		<g:message code="person.rolle.label" default="Rolle" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${personInstance?.rolle?}" var="r">
    <li><g:link controller="rolle" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="rolle" action="create" params="['person.id': personInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'rolle.label', default: 'Rolle')])}</g:link>
</li>
</ul>


</div>

