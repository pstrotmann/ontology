package org.strotmann.ontologies.partner



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class BankverbindungController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Bankverbindung.list(params), model:[bankverbindungInstanceCount: Bankverbindung.count()]
    }

    def show(Bankverbindung bankverbindungInstance) {
        respond bankverbindungInstance
    }

    def create() {
        respond new Bankverbindung(params)
    }

    @Transactional
    def save(Bankverbindung bankverbindungInstance) {
        if (bankverbindungInstance == null) {
            notFound()
            return
        }

        if (bankverbindungInstance.hasErrors()) {
            respond bankverbindungInstance.errors, view:'create'
            return
        }

        bankverbindungInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'bankverbindung.label', default: 'Bankverbindung'), bankverbindungInstance.id])
                redirect bankverbindungInstance
            }
            '*' { respond bankverbindungInstance, [status: CREATED] }
        }
    }

    def edit(Bankverbindung bankverbindungInstance) {
        respond bankverbindungInstance
    }

    @Transactional
    def update(Bankverbindung bankverbindungInstance) {
        if (bankverbindungInstance == null) {
            notFound()
            return
        }

        if (bankverbindungInstance.hasErrors()) {
            respond bankverbindungInstance.errors, view:'edit'
            return
        }

        bankverbindungInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Bankverbindung.label', default: 'Bankverbindung'), bankverbindungInstance.id])
                redirect bankverbindungInstance
            }
            '*'{ respond bankverbindungInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Bankverbindung bankverbindungInstance) {

        if (bankverbindungInstance == null) {
            notFound()
            return
        }

        bankverbindungInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Bankverbindung.label', default: 'Bankverbindung'), bankverbindungInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'bankverbindung.label', default: 'Bankverbindung'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
