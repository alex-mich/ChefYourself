<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Operations</title>
<script>
	function insertMethod() {
		document.forms["InsertOperations"].submit();
	}

	function insertCuisine() {
		document.forms["InsertOperations2"].submit();
	}

	function insertLocale() {
		document.forms["InsertOperations3"].submit();
	}
	function insertIngredient() {
		document.forms["InsertOperations4"].submit();
	}

	function insertRecipe() {
		document.forms["InsertOperations5"].submit();
	}
</script>
<style>
body {
	background:
		url(http://images.huffingtonpost.com/2015-12-23-1450895141-5774790-food02.jpg)
		no-repeat;
	background-size: 100%;
}
</style>
</head>
<body>
	<br>
	<br>
	<br>
	<h1 align="center">
		<font size="10" style="background-color: buttonface;">Choose Insert Operation</font>
	</h1>
	<form id="InsertOperations" method="post" name="InsertOperations"
		action="Insert_Method.jsp">
		<br>
		<center>
			<br> <input type="submit" id="insertMethod" value="METHOD"
				style="height: 40px; width: 220px; font-size: 20px;"
				onclick="javascript: insertMethod()">
		</center>
	</form>
	<form id="InsertOperations2" method="post" name="InsertOperations2"
		action="Insert_Cuisine.jsp">
		<br>
		<center>
			<input type="submit" id="insertCuisine" value="CUISINE"
				style="height: 40px; width: 220px; font-size: 20px;"
				onclick="javascript: insertCuisine()">
		</center>
	</form>
	<form id="InsertOperations3" method="post" name="InsertOperations3"
		action="Insert_Locale.jsp">
		<br>
		<center>
			<input type="submit" id="insertLocale" value="LOCALE"
				style="height: 40px; width: 220px; font-size: 20px;"
				onclick="javascript: insertLocale()">
		</center>
	</form>
	<form id="InsertOperations4" method="post" name="InsertOperations4"
		action="Insert_Ingredient.jsp">
		<br>
		<center>
			<input type="submit" id="insertIngredient" value="INGREDIENT"
				style="height: 40px; width: 220px; font-size: 20px;"
				onclick="javascript: insertIngredient()">
		</center>
	</form>
	<form id="InsertOperations5" method="post" name="InsertOperations5"
		action="Choose_Cuisine.jsp">
		<br>
		<center>
			<input type="submit" id="insertRecipe" value="RECIPE"
				style="height: 40px; width: 220px; font-size: 20px;"
				onclick="javascript: insertRecipe()">
		</center>
	</form>
	<br>
	<center>
		<input type="button" id="backButton" value="BACK"
			style="height: 40px; width: 220px; font-size: 20px;"
			onClick="history.go(-1);return true;">
	</center>
</body>
</html>