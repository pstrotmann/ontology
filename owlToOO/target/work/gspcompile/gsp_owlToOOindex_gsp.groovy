import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_owlToOOindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',82,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('message','g',84,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(6)
invokeTag('message','g',92,['code':("OWL.import.code"),'default':("generiere Domainklassen aus OWL")],-1)
printHtmlPart(7)
createClosureForHtmlPart(8, 2)
invokeTag('uploadForm','g',96,['controller':("GenDoms")],2)
printHtmlPart(7)
if(true && (flash.messageF)) {
printHtmlPart(9)
expressionOut.print(flash.messageF)
printHtmlPart(10)
}
printHtmlPart(7)
if(true && (flash.message1)) {
printHtmlPart(9)
expressionOut.print(flash.message1)
printHtmlPart(10)
}
printHtmlPart(11)
createClosureForHtmlPart(12, 2)
invokeTag('link','g',105,['controller':("person")],2)
printHtmlPart(13)
createClosureForHtmlPart(14, 2)
invokeTag('link','g',106,['controller':("organisation")],2)
printHtmlPart(13)
createClosureForHtmlPart(15, 2)
invokeTag('link','g',107,['controller':("adresse")],2)
printHtmlPart(13)
createClosureForHtmlPart(16, 2)
invokeTag('link','g',108,['controller':("bankverbindung")],2)
printHtmlPart(13)
createClosureForHtmlPart(17, 2)
invokeTag('link','g',109,['controller':("kommunikation")],2)
printHtmlPart(13)
createClosureForHtmlPart(18, 2)
invokeTag('link','g',110,['controller':("rolle")],2)
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',113,[:],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1499790236000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
