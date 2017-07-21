import grails.plugin.umlclassdiagram.*
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='uml-class-diagram', version='0.4.0')
class gsp_umlClassDiagram_uml_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/uml-class-diagram-0.4.0/grails-app/views/uml/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('render','g',18,['template':("oneFilter"),'bean':(configurationCommandInstance),'var':("filterName"),'collection':('package class field link'.split().collect{ it + 'Filter'})],-1)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: configurationCommandInstance, field: 'diagramType', 'error'))
printHtmlPart(2)
invokeTag('message','g',25,['code':("configurationCommand.diagramType.label"),'default':("Diagram Type")],-1)
printHtmlPart(3)
invokeTag('select','g',28,['name':("diagramType"),'from':(DiagramType?.values()),'keys':(DiagramType.values()*.name()),'required':(""),'value':(configurationCommandInstance?.diagramType?.name())],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: configurationCommandInstance, field: 'filterGrailsFields', 'error'))
printHtmlPart(5)
invokeTag('message','g',33,['code':("configurationCommand.filterGrailsFields.label"),'default':("Filter Grails Fields")],-1)
printHtmlPart(6)
invokeTag('checkBox','g',35,['name':("filterGrailsFields"),'value':(configurationCommandInstance?.filterGrailsFields)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: configurationCommandInstance, field: 'showCanonicalJavaClassNames', 'error'))
printHtmlPart(7)
invokeTag('message','g',40,['code':("configurationCommand.showCanonicalJavaClassNames.label"),'default':("Show Canonical Class Names")],-1)
printHtmlPart(6)
invokeTag('checkBox','g',42,['name':("showCanonicalJavaClassNames"),'value':(configurationCommandInstance?.showCanonicalJavaClassNames)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: configurationCommandInstance, field: 'showGrailsInternalClasses', 'error'))
printHtmlPart(8)
invokeTag('message','g',47,['code':("configurationCommand.showGrailsInternalClasses.label"),'default':("Show Grails Internals")],-1)
printHtmlPart(6)
invokeTag('checkBox','g',49,['name':("showGrailsInternalClasses"),'value':(configurationCommandInstance?.showGrailsInternalClasses)],-1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1427231290000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
