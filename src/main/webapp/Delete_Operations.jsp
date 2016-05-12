<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Operations</title>
<script>
	function deleteMethod() {
		document.forms["DeleteOperations"].submit();
	}

	function deleteCuisine() {
		document.forms["DeleteOperations2"].submit();
	}

	function deleteLocale() {
		document.forms["DeleteOperations3"].submit();
	}
	function deleteIngredient() {
		document.forms["DeleteOperations4"].submit();
	}

	function deleteRecipe() {
		document.forms["DeleteOperations5"].submit();
	}
</script>
<style>
body {
	background:
		url(http://www.tasteforlife.com/sites/default/files/styles/desktop/public/field/image/whythai.jpeg?itok=3XQ-eHtF)
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
		<font size="10" style="background-color: buttonface;">Choose Delete Operation</font>
	</h1>
	<form id="DeleteOperations" method="post" name="DeleteOperations"
		action="Delete_Method.jsp">
		<br>
		<center>
			<br> <input type="submit" id="deleteMethod" value="METHOD"
				style="height: 40px; width: 220px; font-size: 20px;"
				onclick="javascript: deleteMethod()">
		</center>
	</form>
	<form id="DeleteOperations2" method="post" name="DeleteOperations2"
		action="Delete_Cuisine.jsp">
		<br>
		<center>
			<input type="submit" id="deleteCuisine" value="CUISINE"
				style="height: 40px; width: 220px; font-size: 20px;"
				onclick="javascript: deleteCuisine()">
		</center>
	</form>
	<form id="DeleteOperations3" method="post" name="DeleteOperations3"
		action="Delete_Locale.jsp">
		<br>
		<center>
			<input type="submit" id="deleteLocale" value="LOCALE"
				style="height: 40px; width: 220px; font-size: 20px;"
				onclick="javascript: deleteLocale()">
		</center>
	</form>
	<form id="DeleteOperations4" method="post" name="DeleteOperations4"
		action="Delete_Ingredient.jsp">
		<br>
		<center>
			<input type="submit" id="deleteIngredient" value="INGREDIENT"
				style="height: 40px; width: 220px; font-size: 20px;"
				onclick="javascript: deleteIngredient()">
		</center>
	</form>
	<form id="DeleteOperations5" method="post" name="DeleteOperations5"
		action="Choose_Cuisine3.jsp">
		<br>
		<center>
			<input type="submit" id="deleteRecipe" value="RECIPE"
				style="height: 40px; width: 220px; font-size: 20px;"
				onclick="javascript: deleteRecipe()">
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