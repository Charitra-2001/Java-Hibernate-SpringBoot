<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to Empire</h2>
	<form action="addAlien" method="post">
		Enter the id:<input type="text" name="aid"><br>
		Enter the name:<input type="text" name="aname"><br>
		<input type="submit">
	</form>
	
	<form action="getAlien" method="post">
		Enter the id:<input type="text" name="aid">
		<input type="submit">
	</form>
	
	<form action="getAlienByName" method="post">
		Enter the name:<input type="text" name="aname">
		<input type="submit">
	</form>
</body>
</html>