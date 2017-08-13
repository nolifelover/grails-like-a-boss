package com.twitter

import grails.test.mixin.*
import spock.lang.*

@TestFor(TweetTagController)
@Mock(TweetTag)
class TweetTagControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        assert false, "TODO: Provide a populateValidParams() implementation for this generated test suite"
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.tweetTagList
            model.tweetTagCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.tweetTag!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def tweetTag = new TweetTag()
            tweetTag.validate()
            controller.save(tweetTag)

        then:"The create view is rendered again with the correct model"
            model.tweetTag!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            tweetTag = new TweetTag(params)

            controller.save(tweetTag)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/tweetTag/show/1'
            controller.flash.message != null
            TweetTag.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def tweetTag = new TweetTag(params)
            controller.show(tweetTag)

        then:"A model is populated containing the domain instance"
            model.tweetTag == tweetTag
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def tweetTag = new TweetTag(params)
            controller.edit(tweetTag)

        then:"A model is populated containing the domain instance"
            model.tweetTag == tweetTag
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/tweetTag/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def tweetTag = new TweetTag()
            tweetTag.validate()
            controller.update(tweetTag)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.tweetTag == tweetTag

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            tweetTag = new TweetTag(params).save(flush: true)
            controller.update(tweetTag)

        then:"A redirect is issued to the show action"
            tweetTag != null
            response.redirectedUrl == "/tweetTag/show/$tweetTag.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/tweetTag/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def tweetTag = new TweetTag(params).save(flush: true)

        then:"It exists"
            TweetTag.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(tweetTag)

        then:"The instance is deleted"
            TweetTag.count() == 0
            response.redirectedUrl == '/tweetTag/index'
            flash.message != null
    }
}
