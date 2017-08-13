<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Edit</title>
	<meta name="layout" content="main">
</head>
<body>
edit ${name}
<ui>
	<g:each in="${items}" var="item">
	<li>${item.name}</li>
	</g:each>
</ui>
</body>
</html>