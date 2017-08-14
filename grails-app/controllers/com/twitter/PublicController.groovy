package com.twitter

class PublicController {

    def index() {
    	def tweetList = Tweet.list()
    	respond tweetList
    }
}
