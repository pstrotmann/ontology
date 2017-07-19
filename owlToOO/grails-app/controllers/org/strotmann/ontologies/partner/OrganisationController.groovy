package org.strotmann.ontologies.partner



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class OrganisationController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Organisation.list(params), model:[organisationInstanceCount: Organisation.count()]
    }

    def show(Organisation organisationInstance) {
        respond organisationInstance
    }

    def create() {
        respond new Organisation(params)
    }

    @Transactional
    def save(Organisation organisationInstance) {
        if (organisationInstance == null) {
            notFound()
            return
        }

        if (organisationInstance.hasErrors()) {
            respond organisationInstance.errors, view:'create'
            return
        }

        organisationInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'organisation.label', default: 'Organisation'), organisationInstance.id])
                redirect organisationInstance
            }
            '*' { respond organisationInstance, [status: CREATED] }
        }
    }

    def edit(Organisation organisationInstance) {
        respond organisationInstance
    }

    @Transactional
    def update(Organisation organisationInstance) {
        if (organisationInstance == null) {
            notFound()
            return
        }

        if (organisationInstance.hasErrors()) {
            respond organisationInstance.errors, view:'edit'
            return
        }

        organisationInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Organisation.label', default: 'Organisation'), organisationInstance.id])
                redirect organisationInstance
            }
            '*'{ respond organisationInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Organisation organisationInstance) {

        if (organisationInstance == null) {
            notFound()
            return
        }

        organisationInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Organisation.label', default: 'Organisation'), organisationInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'organisation.label', default: 'Organisation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
