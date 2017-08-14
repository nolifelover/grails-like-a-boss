package com.twitter

import grails.transaction.Transactional
import java.util.regex.*;

@Transactional
class ProcessTweetService {

    def serviceMethod() {

    }

    def createTweet(text){
    	//TODO using user from login
    	def userInstance = User.first()
    	def tweetInstance = new Tweet(text:text)
    	tweetInstance.user = userInstance
    	def hashtags = processTag(text)
    	if(hashtags && hashtags.size() > 0){
    		hashtags.each{ hashtag ->
				def tagText = hashtag.trim()
				def tagInstance = Tag.findByText(tagText)
				if(!tagInstance){
					tagInstance = new Tag(text:tagText)	
					tagInstance.save()
				}
				def tweetTagInstance = new TweetTag(tag: tagInstance)
				tweetInstance.addToTweetTags(tweetTagInstance)
			}
    	}
    	if(tweetInstance.validate() && tweetInstance.save()){
    		return [success:true]
    	}else{
    		return [success:false, errors: tweetInstance.errors]
    	}
    }

    private def processTag(text){
		Pattern hashtagPattern = Pattern.compile("#(\\S+)");
		Matcher match = hashtagPattern.matcher(text);
		def hashtags = []
		while(match.find()) {
			hashtags.add(match.group(1))
		}
		return hashtags
    }
}
