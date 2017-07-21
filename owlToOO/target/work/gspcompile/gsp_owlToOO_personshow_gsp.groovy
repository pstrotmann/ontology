import org.strotmann.ontologies.partner.Person
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_owlToOO_personshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/person/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'person.label', default: 'Person'))],-1)
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
if(true && (personInstance?.name)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("person.name.label"),'default':("Name")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(personInstance),'field':("name")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.adresse)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("person.adresse.label"),'default':("Adresse")],-1)
printHtmlPart(19)
createTagBody(3, {->
expressionOut.print(personInstance?.adresse?.encodeAsHTML())
})
invokeTag('link','g',39,['controller':("adresse"),'action':("show"),'id':(personInstance?.adresse?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.vorname)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("person.vorname.label"),'default':("Vorname")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',48,['bean':(personInstance),'field':("vorname")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.geburtsdatum)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("person.geburtsdatum.label"),'default':("Geburtsdatum")],-1)
printHtmlPart(23)
invokeTag('formatDate','g',57,['date':(personInstance?.geburtsdatum)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.geschlecht)) {
printHtmlPart(24)
invokeTag('message','g',64,['code':("person.geschlecht.label"),'default':("Geschlecht")],-1)
printHtmlPart(25)
invokeTag('fieldValue','g',66,['bean':(personInstance),'field':("geschlecht")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.bankverbindung)) {
printHtmlPart(26)
invokeTag('message','g',73,['code':("person.bankverbindung.label"),'default':("Bankverbindung")],-1)
printHtmlPart(27)
for( b in (personInstance.bankverbindung) ) {
printHtmlPart(28)
createTagBody(4, {->
expressionOut.print(b?.encodeAsHTML())
})
invokeTag('link','g',76,['controller':("bankverbindung"),'action':("show"),'id':(b.id)],4)
printHtmlPart(29)
}
printHtmlPart(30)
}
printHtmlPart(17)
if(true && (personInstance?.kommunikation)) {
printHtmlPart(31)
invokeTag('message','g',84,['code':("person.kommunikation.label"),'default':("Kommunikation")],-1)
printHtmlPart(27)
for( k in (personInstance.kommunikation) ) {
printHtmlPart(32)
createTagBody(4, {->
expressionOut.print(k?.encodeAsHTML())
})
invokeTag('link','g',87,['controller':("kommunikation"),'action':("show"),'id':(k.id)],4)
printHtmlPart(29)
}
printHtmlPart(30)
}
printHtmlPart(17)
if(true && (personInstance?.rolle)) {
printHtmlPart(33)
invokeTag('message','g',95,['code':("person.rolle.label"),'default':("Rolle")],-1)
printHtmlPart(27)
for( r in (personInstance.rolle) ) {
printHtmlPart(34)
createTagBody(4, {->
expressionOut.print(r?.encodeAsHTML())
})
invokeTag('link','g',98,['controller':("rolle"),'action':("show"),'id':(r.id)],4)
printHtmlPart(29)
}
printHtmlPart(30)
}
printHtmlPart(35)
createTagBody(2, {->
printHtmlPart(36)
createTagBody(3, {->
invokeTag('message','g',107,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',107,['class':("edit"),'action':("edit"),'resource':(personInstance)],3)
printHtmlPart(37)
invokeTag('actionSubmit','g',108,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(38)
})
invokeTag('form','g',110,['url':([resource:personInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(39)
})
invokeTag('captureBody','sitemesh',112,[:],1)
printHtmlPart(40)
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
