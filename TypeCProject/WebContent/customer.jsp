<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="boxstart">
<h1>Mid 1512148</h1>
<h2>Buy Items Here</h2>
</div>

<form action="customer?action=SearchItem" method="POST">
Search Item: <input type="text" name="searchText" />
<input type="submit" value="Search" />
</form>

<br>
<h3>Item List</h3>
<table class="table table-hover table-bordered">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>price</th>
		
		<th>Operation</th>
	</tr>

	<c:forEach var="item" items="${item}">
		<tr>
			<td>${item.id}</td>
			<td>${item.itemName}</td>
			<td>${item.price}</td>
			
			<td><a href="buy.jsp?itemId=${item.id}">Buy Me! </a>	
			</td>
		</tr>
	</c:forEach>
</table>	


</body>
</html>