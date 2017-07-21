import org.strotmann.ontologies.partner.Person
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_owlToOO_person_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/person/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: personInstance, field: 'name', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("person.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("name"),'required':(""),'value':(personInstance?.name)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: personInstance, field: 'adresse', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("person.adresse.label"),'default':("Adresse")],-1)
printHtmlPart(5)
invokeTag('select','g',19,['id':("adresse"),'name':("adresse.id"),'from':(org.strotmann.ontologies.partner.Adresse.list()),'optionKey':("id"),'value':(personInstance?.adresse?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: personInstance, field: 'vorname', 'error'))
printHtmlPart(6)
invokeTag('message','g',25,['code':("person.vorname.label"),'default':("Vorname")],-1)
printHtmlPart(2)
invokeTag('textField','g',28,['name':("vorname"),'required':(""),'value':(personInstance?.vorname)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: personInstance, field: 'geburtsdatum', 'error'))
printHtmlPart(7)
invokeTag('message','g',34,['code':("person.geburtsdatum.label"),'default':("Geburtsdatum")],-1)
printHtmlPart(5)
invokeTag('datePicker','g',37,['name':("geburtsdatum"),'precision':("day"),'value':(personInstance?.geburtsdatum),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: personInstance, field: 'geschlecht', 'error'))
printHtmlPart(8)
invokeTag('message','g',43,['code':("person.geschlecht.label"),'default':("Geschlecht")],-1)
printHtmlPart(5)
invokeTag('select','g',46,['name':("geschlecht"),'from':(personInstance.constraints.geschlecht.inList),'value':(personInstance?.geschlecht),'valueMessagePrefix':("person.geschlecht"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: personInstance, field: 'bankverbindung', 'error'))
printHtmlPart(9)
invokeTag('message','g',52,['code':("person.bankverbindung.label"),'default':("Bankverbindung")],-1)
printHtmlPart(10)
for( b in (personInstance?.bankverbindung) ) {
printHtmlPart(11)
createTagBody(2, {->
expressionOut.print(b?.encodeAsHTML())
})
invokeTag('link','g',58,['controller':("bankverbindung"),'action':("show"),'id':(b.id)],2)
printHtmlPart(12)
}
printHtmlPart(13)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'bankverbindung.label', default: 'Bankverbindung')]))
})
invokeTag('link','g',61,['controller':("bankverbindung"),'action':("create"),'params':(['person.id': personInstance?.id])],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: personInstance, field: 'kommunikation', 'error'))
printHtmlPart(15)
invokeTag('message','g',70,['code':("person.kommunikation.label"),'default':("Kommunikation")],-1)
printHtmlPart(10)
for( k in (personInstance?.kommunikation) ) {
printHtmlPart(11)
createTagBody(2, {->
expressionOut.print(k?.encodeAsHTML())
})
invokeTag('link','g',76,['controller':("kommunikation"),'action':("show"),'id':(k.id)],2)
printHtmlPart(12)
}
printHtmlPart(13)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'kommunikation.label', default: 'Kommunikation')]))
})
invokeTag('link','g',79,['controller':("kommunikation"),'action':("create"),'params':(['person.id': personInstance?.id])],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: personInstance, field: 'rolle', 'error'))
printHtmlPart(16)
invokeTag('message','g',88,['code':("person.rolle.label"),'default':("Rolle")],-1)
printHtmlPart(10)
for( r in (personInstance?.rolle) ) {
printHtmlPart(11)
createTagBody(2, {->
expressionOut.print(r?.encodeAsHTML())
})
invokeTag('link','g',94,['controller':("rolle"),'action':("show"),'id':(r.id)],2)
printHtmlPart(12)
}
printHtmlPart(13)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'rolle.label', default: 'Rolle')]))
})
invokeTag('link','g',97,['controller':("rolle"),'action':("create"),'params':(['person.id': personInstance?.id])],1)
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1500545407000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
