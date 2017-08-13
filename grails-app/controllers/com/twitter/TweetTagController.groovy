package com.twitter

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TweetTagController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond TweetTag.list(params), model:[tweetTagCount: TweetTag.count()]
    }

    def show(TweetTag tweetTag) {
        respond tweetTag
    }

    def create() {
        respond new TweetTag(params)
    }

    @Transactional
    def save(TweetTag tweetTag) {
        if (tweetTag == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (tweetTag.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond tweetTag.errors, view:'create'
            return
        }

        tweetTag.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tweetTag.label', default: 'TweetTag'), tweetTag.id])
                redirect tweetTag
            }
            '*' { respond tweetTag, [status: CREATED] }
        }
    }

    def edit(TweetTag tweetTag) {
        respond tweetTag
    }

    @Transactional
    def update(TweetTag tweetTag) {
        if (tweetTag == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (tweetTag.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond tweetTag.errors, view:'edit'
            return
        }

        tweetTag.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tweetTag.label', default: 'TweetTag'), tweetTag.id])
                redirect tweetTag
            }
            '*'{ respond tweetTag, [status: OK] }
        }
    }

    @Transactional
    def delete(TweetTag tweetTag) {

        if (tweetTag == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        tweetTag.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tweetTag.label', default: 'TweetTag'), tweetTag.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tweetTag.label', default: 'TweetTag'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
