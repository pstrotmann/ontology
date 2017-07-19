package org.strotmann.ontologies.partner



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PartnerController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Partner.list(params), model:[partnerInstanceCount: Partner.count()]
    }

    def show(Partner partnerInstance) {
        respond partnerInstance
    }

    def create() {
        respond new Partner(params)
    }

    @Transactional
    def save(Partner partnerInstance) {
        if (partnerInstance == null) {
            notFound()
            return
        }

        if (partnerInstance.hasErrors()) {
            respond partnerInstance.errors, view:'create'
            return
        }

        partnerInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'partner.label', default: 'Partner'), partnerInstance.id])
                redirect partnerInstance
            }
            '*' { respond partnerInstance, [status: CREATED] }
        }
    }

    def edit(Partner partnerInstance) {
        respond partnerInstance
    }

    @Transactional
    def update(Partner partnerInstance) {
        if (partnerInstance == null) {
            notFound()
            return
        }

        if (partnerInstance.hasErrors()) {
            respond partnerInstance.errors, view:'edit'
            return
        }

        partnerInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Partner.label', default: 'Partner'), partnerInstance.id])
                redirect partnerInstance
            }
            '*'{ respond partnerInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Partner partnerInstance) {

        if (partnerInstance == null) {
            notFound()
            return
        }

        partnerInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Partner.label', default: 'Partner'), partnerInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'partner.label', default: 'Partner'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
