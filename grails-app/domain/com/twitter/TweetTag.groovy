package com.twitter

class TweetTag {
	static belongsTo = [tweet: Tweet, tag: Tag]
    static constraints = {
    }
}
