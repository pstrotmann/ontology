<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}

			#status li {
				line-height: 1.3;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
	</head>
	<body>
		<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="page-body" role="main">
			<h1>Umsetzen OWL nach OO</h1>
			<p>Dieses Programm liest eine in OWL spezifizierte Ontologie ein und erzeugt daraus Domainklassen für Grails.
			aus diesen Domainklassen kann dann mit grails-generate-all eine Anwendung mit CRUD- Funktionalität erzeugt werden,
			CRUD steht für Create, Retrieve, Update, Delete</p>
		
			<g:message code="OWL.import.code" default="generiere Domainklassen aus OWL"/>
			<g:uploadForm controller='GenDoms'>
 						<input type='file' name='file'/>
 						<input type='submit'/>
			</g:uploadForm>
			<g:if test="${flash.messageF}">
				<div class="message">${flash.messageF}</div>
			</g:if>
			<g:if test="${flash.message1}">
				<div class="message">${flash.message1}</div>
			</g:if>
			<h1>generiertes Partnersystem</h1>
			<ul>
				<li class="controller"><g:link controller="person">Person</g:link></li>
				<li class="controller"><g:link controller="organisation">Organisation</g:link></li>
				<li class="controller"><g:link controller="adresse">Adresse</g:link></li>
				<li class="controller"><g:link controller="bankverbindung">Bankverbindung</g:link></li>
				<li class="controller"><g:link controller="kommunikation">Kommunikation</g:link></li>
				<li class="controller"><g:link controller="rolle">Rolle</g:link></li>
			</ul>
		</div>
	</body>
</html>
