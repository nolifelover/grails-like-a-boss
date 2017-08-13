package com.twitter

class Tag {
	String text
	static hasMany = [tweetTags: TweetTag]
    static constraints = {
    }

    def getTweets(){
    	if(tweetTags && tweetTags.size() > 0){
    		return tweetTags.tweet
    	}
    }
}
