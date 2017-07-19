<%@ page import="org.strotmann.ontologies.partner.Adresse" %>



<div class="fieldcontain ${hasErrors(bean: adresseInstance, field: 'postleitzahl', 'error')} required">
	<label for="postleitzahl">
		<g:message code="adresse.postleitzahl.label" default="Postleitzahl" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="postleitzahl" type="number" value="${adresseInstance.postleitzahl}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: adresseInstance, field: 'ort', 'error')} required">
	<label for="ort">
		<g:message code="adresse.ort.label" default="Ort" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="ort" required="" value="${adresseInstance?.ort}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: adresseInstance, field: 'strasse', 'error')} required">
	<label for="strasse">
		<g:message code="adresse.strasse.label" default="Strasse" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="strasse" required="" value="${adresseInstance?.strasse}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: adresseInstance, field: 'hausnummer', 'error')} required">
	<label for="hausnummer">
		<g:message code="adresse.hausnummer.label" default="Hausnummer" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="hausnummer" type="number" value="${adresseInstance.hausnummer}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: adresseInstance, field: 'hausnummerZusatz', 'error')} ">
	<label for="hausnummerZusatz">
		<g:message code="adresse.hausnummerZusatz.label" default="Hausnummer Zusatz" />
		
	</label>
	<g:textField name="hausnummerZusatz" value="${adresseInstance?.hausnummerZusatz}"/>

</div>

