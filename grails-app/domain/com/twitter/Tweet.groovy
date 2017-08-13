package com.twitter

class Tweet {
	String text
	static belongsTo = [user: User]
	static hasMany = [tweetTags: TweetTag]

    static constraints = {
    }

    def getTags(){
		if(tweetTags && tweetTags.size() > 0){
			return tweetTags.tag
		}
	}
}
