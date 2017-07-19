
<%@ page import="org.strotmann.ontologies.partner.Organisation" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'organisation.label', default: 'Organisation')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-organisation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-organisation" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list organisation">
			
				<g:if test="${organisationInstance?.adresse}">
				<li class="fieldcontain">
					<span id="adresse-label" class="property-label"><g:message code="organisation.adresse.label" default="Adresse" /></span>
					
						<span class="property-value" aria-labelledby="adresse-label"><g:link controller="adresse" action="show" id="${organisationInstance?.adresse?.id}">${organisationInstance?.adresse?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${organisationInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="organisation.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${organisationInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${organisationInstance?.branche}">
				<li class="fieldcontain">
					<span id="branche-label" class="property-label"><g:message code="organisation.branche.label" default="Branche" /></span>
					
						<span class="property-value" aria-labelledby="branche-label"><g:fieldValue bean="${organisationInstance}" field="branche"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${organisationInstance?.rechtsform}">
				<li class="fieldcontain">
					<span id="rechtsform-label" class="property-label"><g:message code="organisation.rechtsform.label" default="Rechtsform" /></span>
					
						<span class="property-value" aria-labelledby="rechtsform-label"><g:fieldValue bean="${organisationInstance}" field="rechtsform"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${organisationInstance?.bankverbindung}">
				<li class="fieldcontain">
					<span id="bankverbindung-label" class="property-label"><g:message code="organisation.bankverbindung.label" default="Bankverbindung" /></span>
					
						<g:each in="${organisationInstance.bankverbindung}" var="b">
						<span class="property-value" aria-labelledby="bankverbindung-label"><g:link controller="bankverbindung" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${organisationInstance?.kommunikation}">
				<li class="fieldcontain">
					<span id="kommunikation-label" class="property-label"><g:message code="organisation.kommunikation.label" default="Kommunikation" /></span>
					
						<g:each in="${organisationInstance.kommunikation}" var="k">
						<span class="property-value" aria-labelledby="kommunikation-label"><g:link controller="kommunikation" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${organisationInstance?.rolle}">
				<li class="fieldcontain">
					<span id="rolle-label" class="property-label"><g:message code="organisation.rolle.label" default="Rolle" /></span>
					
						<g:each in="${organisationInstance.rolle}" var="r">
						<span class="property-value" aria-labelledby="rolle-label"><g:link controller="rolle" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:organisationInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${organisationInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
