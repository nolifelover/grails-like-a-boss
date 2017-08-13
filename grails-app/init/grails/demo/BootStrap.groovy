package grails.demo
import com.twitter.*;
class BootStrap {

    def init = { servletContext ->
    	def johnUser = new User(username:"john_doe", fullname: "John Doe", text:"my name is Jonh Doe, Nice to meet u :)")
    	def janeUser = new User(username:"jane_doe", fullname: "Jane Doe", text:"Hello world, Nict to meet u")

    	johnUser.save()
    	janeUser.save()

    	def helloTag = new Tag(text: "hello")
    	def worldTag = new Tag(text: "world")

    	helloTag.save()
    	worldTag.save()

    	def johnTweet = new Tweet(text:"Hello Universe from world #hello #world", user: johnUser)

    	johnTweet.save()

    	def johnTweetHelloTag = new TweetTag(tweet: johnTweet, tag:helloTag)
    	johnTweetHelloTag.save()

    	johnTweet.addToTweetTags(tag: worldTag)

    	johnTweet.save()

    }
    def destroy = {
    }
}
