import org.strotmann.ontologies.partner.Organisation
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_owlToOO_organisation_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/organisation/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'name', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("organisation.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("name"),'required':(""),'value':(organisationInstance?.name)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'adresse', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("organisation.adresse.label"),'default':("Adresse")],-1)
printHtmlPart(5)
invokeTag('select','g',19,['id':("adresse"),'name':("adresse.id"),'from':(org.strotmann.ontologies.partner.Adresse.list()),'optionKey':("id"),'value':(organisationInstance?.adresse?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'branche', 'error'))
printHtmlPart(6)
invokeTag('message','g',25,['code':("organisation.branche.label"),'default':("Branche")],-1)
printHtmlPart(5)
invokeTag('select','g',28,['name':("branche"),'from':(organisationInstance.constraints.branche.inList),'value':(organisationInstance?.branche),'valueMessagePrefix':("organisation.branche"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'rechtsform', 'error'))
printHtmlPart(7)
invokeTag('message','g',34,['code':("organisation.rechtsform.label"),'default':("Rechtsform")],-1)
printHtmlPart(5)
invokeTag('select','g',37,['name':("rechtsform"),'from':(organisationInstance.constraints.rechtsform.inList),'value':(organisationInstance?.rechtsform),'valueMessagePrefix':("organisation.rechtsform"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'bankverbindung', 'error'))
printHtmlPart(8)
invokeTag('message','g',43,['code':("organisation.bankverbindung.label"),'default':("Bankverbindung")],-1)
printHtmlPart(9)
for( b in (organisationInstance?.bankverbindung) ) {
printHtmlPart(10)
createTagBody(2, {->
expressionOut.print(b?.encodeAsHTML())
})
invokeTag('link','g',49,['controller':("bankverbindung"),'action':("show"),'id':(b.id)],2)
printHtmlPart(11)
}
printHtmlPart(12)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'bankverbindung.label', default: 'Bankverbindung')]))
})
invokeTag('link','g',52,['controller':("bankverbindung"),'action':("create"),'params':(['organisation.id': organisationInstance?.id])],1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'kommunikation', 'error'))
printHtmlPart(14)
invokeTag('message','g',61,['code':("organisation.kommunikation.label"),'default':("Kommunikation")],-1)
printHtmlPart(9)
for( k in (organisationInstance?.kommunikation) ) {
printHtmlPart(10)
createTagBody(2, {->
expressionOut.print(k?.encodeAsHTML())
})
invokeTag('link','g',67,['controller':("kommunikation"),'action':("show"),'id':(k.id)],2)
printHtmlPart(11)
}
printHtmlPart(12)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'kommunikation.label', default: 'Kommunikation')]))
})
invokeTag('link','g',70,['controller':("kommunikation"),'action':("create"),'params':(['organisation.id': organisationInstance?.id])],1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'rolle', 'error'))
printHtmlPart(15)
invokeTag('message','g',79,['code':("organisation.rolle.label"),'default':("Rolle")],-1)
printHtmlPart(9)
for( r in (organisationInstance?.rolle) ) {
printHtmlPart(10)
createTagBody(2, {->
expressionOut.print(r?.encodeAsHTML())
})
invokeTag('link','g',85,['controller':("rolle"),'action':("show"),'id':(r.id)],2)
printHtmlPart(11)
}
printHtmlPart(12)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'rolle.label', default: 'Rolle')]))
})
invokeTag('link','g',88,['controller':("rolle"),'action':("create"),'params':(['organisation.id': organisationInstance?.id])],1)
printHtmlPart(16)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1500545416000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
