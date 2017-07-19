
<%@ page import="org.strotmann.ontologies.partner.Person" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-person" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-person" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list person">
			
				<g:if test="${personInstance?.adresse}">
				<li class="fieldcontain">
					<span id="adresse-label" class="property-label"><g:message code="person.adresse.label" default="Adresse" /></span>
					
						<span class="property-value" aria-labelledby="adresse-label"><g:link controller="adresse" action="show" id="${personInstance?.adresse?.id}">${personInstance?.adresse?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="person.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${personInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.vorname}">
				<li class="fieldcontain">
					<span id="vorname-label" class="property-label"><g:message code="person.vorname.label" default="Vorname" /></span>
					
						<span class="property-value" aria-labelledby="vorname-label"><g:fieldValue bean="${personInstance}" field="vorname"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.geburtsdatum}">
				<li class="fieldcontain">
					<span id="geburtsdatum-label" class="property-label"><g:message code="person.geburtsdatum.label" default="Geburtsdatum" /></span>
					
						<span class="property-value" aria-labelledby="geburtsdatum-label"><g:formatDate date="${personInstance?.geburtsdatum}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.geschlecht}">
				<li class="fieldcontain">
					<span id="geschlecht-label" class="property-label"><g:message code="person.geschlecht.label" default="Geschlecht" /></span>
					
						<span class="property-value" aria-labelledby="geschlecht-label"><g:fieldValue bean="${personInstance}" field="geschlecht"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.bankverbindung}">
				<li class="fieldcontain">
					<span id="bankverbindung-label" class="property-label"><g:message code="person.bankverbindung.label" default="Bankverbindung" /></span>
					
						<g:each in="${personInstance.bankverbindung}" var="b">
						<span class="property-value" aria-labelledby="bankverbindung-label"><g:link controller="bankverbindung" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.kommunikation}">
				<li class="fieldcontain">
					<span id="kommunikation-label" class="property-label"><g:message code="person.kommunikation.label" default="Kommunikation" /></span>
					
						<g:each in="${personInstance.kommunikation}" var="k">
						<span class="property-value" aria-labelledby="kommunikation-label"><g:link controller="kommunikation" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.rolle}">
				<li class="fieldcontain">
					<span id="rolle-label" class="property-label"><g:message code="person.rolle.label" default="Rolle" /></span>
					
						<g:each in="${personInstance.rolle}" var="r">
						<span class="property-value" aria-labelledby="rolle-label"><g:link controller="rolle" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:personInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${personInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
