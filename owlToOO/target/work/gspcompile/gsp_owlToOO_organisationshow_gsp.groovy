import org.strotmann.ontologies.partner.Organisation
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_owlToOO_organisationshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/organisation/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'organisation.label', default: 'Organisation'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',14,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("list"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("create"),'action':("create")],2)
printHtmlPart(9)
invokeTag('message','g',20,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (organisationInstance?.name)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("organisation.name.label"),'default':("Name")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(organisationInstance),'field':("name")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (organisationInstance?.adresse)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("organisation.adresse.label"),'default':("Adresse")],-1)
printHtmlPart(19)
createTagBody(3, {->
expressionOut.print(organisationInstance?.adresse?.encodeAsHTML())
})
invokeTag('link','g',39,['controller':("adresse"),'action':("show"),'id':(organisationInstance?.adresse?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (organisationInstance?.branche)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("organisation.branche.label"),'default':("Branche")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',48,['bean':(organisationInstance),'field':("branche")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (organisationInstance?.rechtsform)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("organisation.rechtsform.label"),'default':("Rechtsform")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',57,['bean':(organisationInstance),'field':("rechtsform")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (organisationInstance?.bankverbindung)) {
printHtmlPart(24)
invokeTag('message','g',64,['code':("organisation.bankverbindung.label"),'default':("Bankverbindung")],-1)
printHtmlPart(25)
for( b in (organisationInstance.bankverbindung) ) {
printHtmlPart(26)
createTagBody(4, {->
expressionOut.print(b?.encodeAsHTML())
})
invokeTag('link','g',67,['controller':("bankverbindung"),'action':("show"),'id':(b.id)],4)
printHtmlPart(27)
}
printHtmlPart(28)
}
printHtmlPart(17)
if(true && (organisationInstance?.kommunikation)) {
printHtmlPart(29)
invokeTag('message','g',75,['code':("organisation.kommunikation.label"),'default':("Kommunikation")],-1)
printHtmlPart(25)
for( k in (organisationInstance.kommunikation) ) {
printHtmlPart(30)
createTagBody(4, {->
expressionOut.print(k?.encodeAsHTML())
})
invokeTag('link','g',78,['controller':("kommunikation"),'action':("show"),'id':(k.id)],4)
printHtmlPart(27)
}
printHtmlPart(28)
}
printHtmlPart(17)
if(true && (organisationInstance?.rolle)) {
printHtmlPart(31)
invokeTag('message','g',86,['code':("organisation.rolle.label"),'default':("Rolle")],-1)
printHtmlPart(25)
for( r in (organisationInstance.rolle) ) {
printHtmlPart(32)
createTagBody(4, {->
expressionOut.print(r?.encodeAsHTML())
})
invokeTag('link','g',89,['controller':("rolle"),'action':("show"),'id':(r.id)],4)
printHtmlPart(27)
}
printHtmlPart(28)
}
printHtmlPart(33)
createTagBody(2, {->
printHtmlPart(34)
createTagBody(3, {->
invokeTag('message','g',98,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',98,['class':("edit"),'action':("edit"),'resource':(organisationInstance)],3)
printHtmlPart(35)
invokeTag('actionSubmit','g',99,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(36)
})
invokeTag('form','g',101,['url':([resource:organisationInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(37)
})
invokeTag('captureBody','sitemesh',103,[:],1)
printHtmlPart(38)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1500545415000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
