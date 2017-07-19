
<%@ page import="org.strotmann.ontologies.partner.Adresse" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'adresse.label', default: 'Adresse')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-adresse" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-adresse" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list adresse">
			
				<g:if test="${adresseInstance?.postleitzahl}">
				<li class="fieldcontain">
					<span id="postleitzahl-label" class="property-label"><g:message code="adresse.postleitzahl.label" default="Postleitzahl" /></span>
					
						<span class="property-value" aria-labelledby="postleitzahl-label"><g:fieldValue bean="${adresseInstance}" field="postleitzahl"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${adresseInstance?.ort}">
				<li class="fieldcontain">
					<span id="ort-label" class="property-label"><g:message code="adresse.ort.label" default="Ort" /></span>
					
						<span class="property-value" aria-labelledby="ort-label"><g:fieldValue bean="${adresseInstance}" field="ort"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${adresseInstance?.strasse}">
				<li class="fieldcontain">
					<span id="strasse-label" class="property-label"><g:message code="adresse.strasse.label" default="Strasse" /></span>
					
						<span class="property-value" aria-labelledby="strasse-label"><g:fieldValue bean="${adresseInstance}" field="strasse"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${adresseInstance?.hausnummer}">
				<li class="fieldcontain">
					<span id="hausnummer-label" class="property-label"><g:message code="adresse.hausnummer.label" default="Hausnummer" /></span>
					
						<span class="property-value" aria-labelledby="hausnummer-label"><g:fieldValue bean="${adresseInstance}" field="hausnummer"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${adresseInstance?.hausnummerZusatz}">
				<li class="fieldcontain">
					<span id="hausnummerZusatz-label" class="property-label"><g:message code="adresse.hausnummerZusatz.label" default="Hausnummer Zusatz" /></span>
					
						<span class="property-value" aria-labelledby="hausnummerZusatz-label"><g:fieldValue bean="${adresseInstance}" field="hausnummerZusatz"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:adresseInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${adresseInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
