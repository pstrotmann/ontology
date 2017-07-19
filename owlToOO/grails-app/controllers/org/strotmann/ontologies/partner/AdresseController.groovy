package org.strotmann.ontologies.partner



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AdresseController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Adresse.list(params), model:[adresseInstanceCount: Adresse.count()]
    }

    def show(Adresse adresseInstance) {
        respond adresseInstance
    }

    def create() {
        respond new Adresse(params)
    }

    @Transactional
    def save(Adresse adresseInstance) {
        if (adresseInstance == null) {
            notFound()
            return
        }

        if (adresseInstance.hasErrors()) {
            respond adresseInstance.errors, view:'create'
            return
        }

        adresseInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'adresse.label', default: 'Adresse'), adresseInstance.id])
                redirect adresseInstance
            }
            '*' { respond adresseInstance, [status: CREATED] }
        }
    }

    def edit(Adresse adresseInstance) {
        respond adresseInstance
    }

    @Transactional
    def update(Adresse adresseInstance) {
        if (adresseInstance == null) {
            notFound()
            return
        }

        if (adresseInstance.hasErrors()) {
            respond adresseInstance.errors, view:'edit'
            return
        }

        adresseInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Adresse.label', default: 'Adresse'), adresseInstance.id])
                redirect adresseInstance
            }
            '*'{ respond adresseInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Adresse adresseInstance) {

        if (adresseInstance == null) {
            notFound()
            return
        }

        adresseInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Adresse.label', default: 'Adresse'), adresseInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'adresse.label', default: 'Adresse'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
