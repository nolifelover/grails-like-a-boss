<ul>
	<g:each in="${value}" var="tweet">
	<li><g:link controller="tweet" action="show" id="${tweet.id}">${tweet.text}</g:link></li>
	</g:each>
</ul>