package com.twitter

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class FollowController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Follow.list(params), model:[followCount: Follow.count()]
    }

    def show(Follow follow) {
        respond follow
    }

    def create() {
        respond new Follow(params)
    }

    @Transactional
    def save(Follow follow) {
        if (follow == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (follow.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond follow.errors, view:'create'
            return
        }

        follow.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'follow.label', default: 'Follow'), follow.id])
                redirect follow
            }
            '*' { respond follow, [status: CREATED] }
        }
    }

    def edit(Follow follow) {
        respond follow
    }

    @Transactional
    def update(Follow follow) {
        if (follow == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (follow.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond follow.errors, view:'edit'
            return
        }

        follow.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'follow.label', default: 'Follow'), follow.id])
                redirect follow
            }
            '*'{ respond follow, [status: OK] }
        }
    }

    @Transactional
    def delete(Follow follow) {

        if (follow == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        follow.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'follow.label', default: 'Follow'), follow.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'follow.label', default: 'Follow'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
