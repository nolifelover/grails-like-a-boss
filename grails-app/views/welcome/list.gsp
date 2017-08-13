<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>List Product</title>
	<meta name="layout" content="main">
</head>
<body>
${productList.name} ${productList.price}
<table>
	<tr>
		<th>Name</th>
		<th>Number</th>
		<th>Price</th>
	</tr>
	<g:each in="${productList}" var="product">
	<tr>
		<td>${product.name}</td>
		<td>${product.number}</td>
		<td>${product.price}</td>
	</tr>
	</g:each>
</table>
</body>
</html>