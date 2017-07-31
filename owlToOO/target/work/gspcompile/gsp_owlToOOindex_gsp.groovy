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
invokeTag('message','g',94,['code':("OWL.import.code"),'default':("Generiere Domainklassen und graphViz- Input aus einer xxxx.owl - Datei")],-1)
printHtmlPart(7)
createClosureForHtmlPart(8, 2)
invokeTag('uploadForm','g',99,['controller':("GenDoms")],2)
printHtmlPart(9)
if(true && (flash.messageF)) {
printHtmlPart(10)
expressionOut.print(flash.messageF)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (flash.message1)) {
printHtmlPart(10)
expressionOut.print(flash.message1)
printHtmlPart(11)
}
printHtmlPart(13)
if(true && (session.klassenNamen)) {
printHtmlPart(14)
for( item in (session.klassenNamen) ) {
printHtmlPart(15)
createTagBody(4, {->
printHtmlPart(16)
expressionOut.print(item)
})
invokeTag('link','g',113,['controller':("GenDoms"),'action':("downloadGroovy"),'params':([klassenName: "${item}"])],4)
printHtmlPart(17)
}
printHtmlPart(18)
}
printHtmlPart(18)
if(true && (session.gvInName)) {
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',117,['controller':("GenDoms"),'action':("downloadGraphViz")],3)
printHtmlPart(21)
}
printHtmlPart(22)
createClosureForHtmlPart(23, 2)
invokeTag('link','g',122,['controller':("person")],2)
printHtmlPart(24)
createClosureForHtmlPart(25, 2)
invokeTag('link','g',123,['controller':("organisation")],2)
printHtmlPart(24)
createClosureForHtmlPart(26, 2)
invokeTag('link','g',124,['controller':("adresse")],2)
printHtmlPart(24)
createClosureForHtmlPart(27, 2)
invokeTag('link','g',125,['controller':("bankverbindung")],2)
printHtmlPart(24)
createClosureForHtmlPart(28, 2)
invokeTag('link','g',126,['controller':("kommunikation")],2)
printHtmlPart(24)
createClosureForHtmlPart(29, 2)
invokeTag('link','g',127,['controller':("rolle")],2)
printHtmlPart(30)
})
invokeTag('captureBody','sitemesh',130,[:],1)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1500833020000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
