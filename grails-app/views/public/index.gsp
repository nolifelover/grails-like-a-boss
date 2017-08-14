<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="layout" content="public">
	<title>Public</title>
</head>
<body>
	<div class="create-tweet">
		<g:render template="createTweet"/>
	</div>
	<span class="timeline">${timelineTitle}</span>
	<g:each in="${tweetList}" var="tweet">
		<div class="media">
		  <div class="media-left">
		    <a href="#">
		      <asset:image src="apple-touch-icon.png" width="40"/>
		    </a>
		  </div>
		  <div class="media-body">
		    <h4 class="media-heading">@${tweet.user.username}</h4>
		    ${tweet.text}
		  </div>
		</div>
	</g:each>
</body>
</html>