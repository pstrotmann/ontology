import org.strotmann.ontologies.partner.Partner
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_owlToOO_partner_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/partner/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: partnerInstance, field: 'name', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("partner.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("name"),'required':(""),'value':(partnerInstance?.name)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: partnerInstance, field: 'adresse', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("partner.adresse.label"),'default':("Adresse")],-1)
printHtmlPart(5)
invokeTag('select','g',19,['id':("adresse"),'name':("adresse.id"),'from':(org.strotmann.ontologies.partner.Adresse.list()),'optionKey':("id"),'value':(partnerInstance?.adresse?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: partnerInstance, field: 'bankverbindung', 'error'))
printHtmlPart(6)
invokeTag('message','g',25,['code':("partner.bankverbindung.label"),'default':("Bankverbindung")],-1)
printHtmlPart(7)
for( b in (partnerInstance?.bankverbindung) ) {
printHtmlPart(8)
createTagBody(2, {->
expressionOut.print(b?.encodeAsHTML())
})
invokeTag('link','g',31,['controller':("bankverbindung"),'action':("show"),'id':(b.id)],2)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'bankverbindung.label', default: 'Bankverbindung')]))
})
invokeTag('link','g',34,['controller':("bankverbindung"),'action':("create"),'params':(['partner.id': partnerInstance?.id])],1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: partnerInstance, field: 'kommunikation', 'error'))
printHtmlPart(12)
invokeTag('message','g',43,['code':("partner.kommunikation.label"),'default':("Kommunikation")],-1)
printHtmlPart(7)
for( k in (partnerInstance?.kommunikation) ) {
printHtmlPart(8)
createTagBody(2, {->
expressionOut.print(k?.encodeAsHTML())
})
invokeTag('link','g',49,['controller':("kommunikation"),'action':("show"),'id':(k.id)],2)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'kommunikation.label', default: 'Kommunikation')]))
})
invokeTag('link','g',52,['controller':("kommunikation"),'action':("create"),'params':(['partner.id': partnerInstance?.id])],1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: partnerInstance, field: 'rolle', 'error'))
printHtmlPart(13)
invokeTag('message','g',61,['code':("partner.rolle.label"),'default':("Rolle")],-1)
printHtmlPart(7)
for( r in (partnerInstance?.rolle) ) {
printHtmlPart(8)
createTagBody(2, {->
expressionOut.print(r?.encodeAsHTML())
})
invokeTag('link','g',67,['controller':("rolle"),'action':("show"),'id':(r.id)],2)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'rolle.label', default: 'Rolle')]))
})
invokeTag('link','g',70,['controller':("rolle"),'action':("create"),'params':(['partner.id': partnerInstance?.id])],1)
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1501489385000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
