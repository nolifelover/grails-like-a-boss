<ul>
	<g:each in="${value}" var="follow">
	<g:set var="user" value="${follow.fromUser}"/>
	<li><g:link controller="user" action="show" id="${user.id}">${user.username}</g:link></li>
	</g:each>
</ul>