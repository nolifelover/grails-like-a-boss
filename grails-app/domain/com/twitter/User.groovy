package com.twitter

class User {
	String username
	String fullname
	String text
	static mappedBy = [followers: "toUser", followings: "fromUser"]
	static hasMany = [tweets: Tweet, followers: Follow, followings: Follow]
    static constraints = {
    	username nullable:false, blank:false, minSize: 4
    	fullname nullable:false, blank:false, minSize: 4
    	text nullable:true, blank:true
    }
}
