import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='uml-class-diagram', version='0.4.0')
class gsp_umlClassDiagram_uml_oneFilter_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/uml-class-diagram-0.4.0/grails-app/views/uml/_oneFilter.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(
  bean: filterCommand, 
  field: 'regexps', 
  'error'))
printHtmlPart(1)
expressionOut.print(filterName)
printHtmlPart(2)
invokeTag('message','g',7,['code':("configurationCommand.${filterName}.label"),'default':(filterName)],-1)
printHtmlPart(3)
invokeTag('set','g',10,['var':("filterCommand"),'value':(configurationCommandInstance ? configurationCommandInstance[filterName] : [:])],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
expressionOut.print(it.label)
printHtmlPart(6)
expressionOut.print(it.radio)
printHtmlPart(7)
})
invokeTag('radioGroup','g',17,['name':("${filterName}.inclusion"),'labels':(['Inclusion','Exclusion']),'values':([true,false]),'value':(filterCommand?.inclusion as boolean)],1)
printHtmlPart(8)
loop:{
int i = 0
for( regexp in (filterCommand?.regexps ?: ' ') ) {
printHtmlPart(9)
invokeTag('textField','g',20,['name':("${filterName}.regexps"),'value':(regexp),'id':("${filterName}.regexps${i}")],-1)
printHtmlPart(10)
i++
}
}
printHtmlPart(11)
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
