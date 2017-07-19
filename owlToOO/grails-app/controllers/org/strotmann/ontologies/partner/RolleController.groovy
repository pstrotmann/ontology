package org.strotmann.ontologies.partner



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RolleController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Rolle.list(params), model:[rolleInstanceCount: Rolle.count()]
    }

    def show(Rolle rolleInstance) {
        respond rolleInstance
    }

    def create() {
        respond new Rolle(params)
    }

    @Transactional
    def save(Rolle rolleInstance) {
        if (rolleInstance == null) {
            notFound()
            return
        }

        if (rolleInstance.hasErrors()) {
            respond rolleInstance.errors, view:'create'
            return
        }

        rolleInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'rolle.label', default: 'Rolle'), rolleInstance.id])
                redirect rolleInstance
            }
            '*' { respond rolleInstance, [status: CREATED] }
        }
    }

    def edit(Rolle rolleInstance) {
        respond rolleInstance
    }

    @Transactional
    def update(Rolle rolleInstance) {
        if (rolleInstance == null) {
            notFound()
            return
        }

        if (rolleInstance.hasErrors()) {
            respond rolleInstance.errors, view:'edit'
            return
        }

        rolleInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Rolle.label', default: 'Rolle'), rolleInstance.id])
                redirect rolleInstance
            }
            '*'{ respond rolleInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Rolle rolleInstance) {

        if (rolleInstance == null) {
            notFound()
            return
        }

        rolleInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Rolle.label', default: 'Rolle'), rolleInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'rolle.label', default: 'Rolle'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
