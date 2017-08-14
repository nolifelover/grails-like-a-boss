package com.twitter

class PublicController {
	def processTweetService
    def index() {
    	def tweetList = [] 
    	def timelineTitle = "Timeline"
    	if(params.tag){
    		def tagParams = params.tag.trim()
    		tweetList = Tweet.withCriteria {
	    		tweetTags{
	    			tag{
	    				eq("text", tagParams)
	    			}
	    		}
	    	}
	    	timelineTitle = "Timeline #${params.tag}"
    	}else{
    		tweetList = Tweet.list(sort: "id", order: "desc")
    	}
    	respond tweetList, model:[timelineTitle: timelineTitle]
    }

    def sidebar(){
    	def tagList = Tag.list()
    	respond tagList
    }

    def createTweet(){
    	def text = params.text
    	//TODO using user from login
    	/*def userInstance = User.first()

    	def tweetInstance = new Tweet(params)
    	tweetInstance.user = userInstance
		*/
		def result = processTweetService.createTweet(text)
    	if(result.success){
    		flash.css = "success"
    		flash.message = "Success created Tweet"
    	}else{
    		flash.css = "warning"
    		flash.message = "${result.errors}"
    	}
    	redirect action:'index'
    }
}
