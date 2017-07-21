import org.strotmann.ontologies.partner.Kommunikation
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_owlToOO_kommunikation_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/kommunikation/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: kommunikationInstance, field: 'anwahl', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("kommunikation.anwahl.label"),'default':("Anwahl")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("anwahl"),'required':(""),'value':(kommunikationInstance?.anwahl)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: kommunikationInstance, field: 'kommunikationstyp', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("kommunikation.kommunikationstyp.label"),'default':("Kommunikationstyp")],-1)
printHtmlPart(5)
invokeTag('select','g',19,['name':("kommunikationstyp"),'from':(kommunikationInstance.constraints.kommunikationstyp.inList),'value':(kommunikationInstance?.kommunikationstyp),'valueMessagePrefix':("kommunikation.kommunikationstyp"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: kommunikationInstance, field: 'partner', 'error'))
printHtmlPart(6)
invokeTag('message','g',25,['code':("kommunikation.partner.label"),'default':("Partner")],-1)
printHtmlPart(2)
invokeTag('select','g',28,['id':("partner"),'name':("partner.id"),'from':(org.strotmann.ontologies.partner.Partner.list()),'optionKey':("id"),'required':(""),'value':(kommunikationInstance?.partner?.id),'class':("many-to-one")],-1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1500545438000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
