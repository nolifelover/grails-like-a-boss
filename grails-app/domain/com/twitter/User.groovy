package com.twitter

class User {
	String username
	String fullname
	String text
	static mappedBy = [follwers: "fromUser", followings: "toUser"]
	static hasMany = [tweets: Tweet, follwers: Follow, followings: Follow]
    static constraints = {
    	username nullable:false, blank:false, minSize: 4
    	fullname nullable:false, blank:false, minSize: 4
    	text nullable:true, blank:true
    }
}
