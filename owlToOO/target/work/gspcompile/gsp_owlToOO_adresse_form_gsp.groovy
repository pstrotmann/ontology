import org.strotmann.ontologies.partner.Adresse
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_owlToOO_adresse_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/adresse/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: adresseInstance, field: 'postleitzahl', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("adresse.postleitzahl.label"),'default':("Postleitzahl")],-1)
printHtmlPart(2)
invokeTag('field','g',10,['name':("postleitzahl"),'type':("number"),'value':(adresseInstance.postleitzahl),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: adresseInstance, field: 'ort', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("adresse.ort.label"),'default':("Ort")],-1)
printHtmlPart(2)
invokeTag('textField','g',19,['name':("ort"),'required':(""),'value':(adresseInstance?.ort)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: adresseInstance, field: 'strasse', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("adresse.strasse.label"),'default':("Strasse")],-1)
printHtmlPart(2)
invokeTag('textField','g',28,['name':("strasse"),'required':(""),'value':(adresseInstance?.strasse)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: adresseInstance, field: 'hausnummer', 'error'))
printHtmlPart(6)
invokeTag('message','g',34,['code':("adresse.hausnummer.label"),'default':("Hausnummer")],-1)
printHtmlPart(2)
invokeTag('field','g',37,['name':("hausnummer"),'type':("number"),'value':(adresseInstance.hausnummer),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: adresseInstance, field: 'hausnummerZusatz', 'error'))
printHtmlPart(7)
invokeTag('message','g',43,['code':("adresse.hausnummerZusatz.label"),'default':("Hausnummer Zusatz")],-1)
printHtmlPart(8)
invokeTag('textField','g',46,['name':("hausnummerZusatz"),'value':(adresseInstance?.hausnummerZusatz)],-1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1500545456000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
