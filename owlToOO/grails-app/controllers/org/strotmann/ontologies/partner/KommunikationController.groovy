package org.strotmann.ontologies.partner



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class KommunikationController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Kommunikation.list(params), model:[kommunikationInstanceCount: Kommunikation.count()]
    }

    def show(Kommunikation kommunikationInstance) {
        respond kommunikationInstance
    }

    def create() {
        respond new Kommunikation(params)
    }

    @Transactional
    def save(Kommunikation kommunikationInstance) {
        if (kommunikationInstance == null) {
            notFound()
            return
        }

        if (kommunikationInstance.hasErrors()) {
            respond kommunikationInstance.errors, view:'create'
            return
        }

        kommunikationInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'kommunikation.label', default: 'Kommunikation'), kommunikationInstance.id])
                redirect kommunikationInstance
            }
            '*' { respond kommunikationInstance, [status: CREATED] }
        }
    }

    def edit(Kommunikation kommunikationInstance) {
        respond kommunikationInstance
    }

    @Transactional
    def update(Kommunikation kommunikationInstance) {
        if (kommunikationInstance == null) {
            notFound()
            return
        }

        if (kommunikationInstance.hasErrors()) {
            respond kommunikationInstance.errors, view:'edit'
            return
        }

        kommunikationInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Kommunikation.label', default: 'Kommunikation'), kommunikationInstance.id])
                redirect kommunikationInstance
            }
            '*'{ respond kommunikationInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Kommunikation kommunikationInstance) {

        if (kommunikationInstance == null) {
            notFound()
            return
        }

        kommunikationInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Kommunikation.label', default: 'Kommunikation'), kommunikationInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'kommunikation.label', default: 'Kommunikation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
