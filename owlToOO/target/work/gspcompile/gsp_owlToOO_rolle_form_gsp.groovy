import org.strotmann.ontologies.partner.Rolle
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_owlToOO_rolle_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/rolle/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: rolleInstance, field: 'rollenname', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("rolle.rollenname.label"),'default':("Rollenname")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['name':("rollenname"),'from':(rolleInstance.constraints.rollenname.inList),'value':(rolleInstance?.rollenname),'valueMessagePrefix':("rolle.rollenname"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: rolleInstance, field: 'partner', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("rolle.partner.label"),'default':("Partner")],-1)
printHtmlPart(5)
invokeTag('select','g',19,['id':("partner"),'name':("partner.id"),'from':(org.strotmann.ontologies.partner.Partner.list()),'optionKey':("id"),'required':(""),'value':(rolleInstance?.partner?.id),'class':("many-to-one")],-1)
printHtmlPart(6)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1500545429000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
