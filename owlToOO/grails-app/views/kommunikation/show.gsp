
<%@ page import="org.strotmann.ontologies.partner.Kommunikation" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'kommunikation.label', default: 'Kommunikation')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-kommunikation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-kommunikation" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list kommunikation">
			
				<g:if test="${kommunikationInstance?.anwahl}">
				<li class="fieldcontain">
					<span id="anwahl-label" class="property-label"><g:message code="kommunikation.anwahl.label" default="Anwahl" /></span>
					
						<span class="property-value" aria-labelledby="anwahl-label"><g:fieldValue bean="${kommunikationInstance}" field="anwahl"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${kommunikationInstance?.kommunikationstyp}">
				<li class="fieldcontain">
					<span id="kommunikationstyp-label" class="property-label"><g:message code="kommunikation.kommunikationstyp.label" default="Kommunikationstyp" /></span>
					
						<span class="property-value" aria-labelledby="kommunikationstyp-label"><g:fieldValue bean="${kommunikationInstance}" field="kommunikationstyp"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${kommunikationInstance?.partner}">
				<li class="fieldcontain">
					<span id="partner-label" class="property-label"><g:message code="kommunikation.partner.label" default="Partner" /></span>
					
						<span class="property-value" aria-labelledby="partner-label"><g:link controller="partner" action="show" id="${kommunikationInstance?.partner?.id}">${kommunikationInstance?.partner?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:kommunikationInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${kommunikationInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
