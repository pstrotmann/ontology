
<%@ page import="org.strotmann.ontologies.partner.Bankverbindung" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bankverbindung.label', default: 'Bankverbindung')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-bankverbindung" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-bankverbindung" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list bankverbindung">
			
				<g:if test="${bankverbindungInstance?.iban}">
				<li class="fieldcontain">
					<span id="iban-label" class="property-label"><g:message code="bankverbindung.iban.label" default="Iban" /></span>
					
						<span class="property-value" aria-labelledby="iban-label"><g:fieldValue bean="${bankverbindungInstance}" field="iban"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bankverbindungInstance?.bic}">
				<li class="fieldcontain">
					<span id="bic-label" class="property-label"><g:message code="bankverbindung.bic.label" default="Bic" /></span>
					
						<span class="property-value" aria-labelledby="bic-label"><g:fieldValue bean="${bankverbindungInstance}" field="bic"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bankverbindungInstance?.partner}">
				<li class="fieldcontain">
					<span id="partner-label" class="property-label"><g:message code="bankverbindung.partner.label" default="Partner" /></span>
						<g:if test="${bankverbindungInstance.partner.instanceOf(org.strotmann.ontologies.partner.Person)}">
							<span class="property-value" aria-labelledby="partner-label"><g:link controller="person" action="show" id="${bankverbindungInstance?.partner?.id}">${bankverbindungInstance?.partner?.encodeAsHTML()}</g:link></span>
						</g:if>
						<g:else test="${bankverbindungInstance.partner.instanceOf(org.strotmann.ontologies.partner.Organisation)}">
							<span class="property-value" aria-labelledby="partner-label"><g:link controller="organisation" action="show" id="${bankverbindungInstance?.partner?.id}">${bankverbindungInstance?.partner?.encodeAsHTML()}</g:link></span>
						</g:else>
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:bankverbindungInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${bankverbindungInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
