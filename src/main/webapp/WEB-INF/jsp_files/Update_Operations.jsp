<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Operations</title>
<script>
	function updateMethod() {
		document.forms["UpdateOperations"].submit();
	}

	function updateCuisine() {
		document.forms["UpdateOperations2"].submit();
	}

	function updateLocale() {
		document.forms["UpdateOperations3"].submit();
	}
	function updateIngredient() {
		document.forms["UpdateOperations4"].submit();
	}

	function updateRecipe() {
		document.forms["UpdateOperations5"].submit();
	}
	function goBack() {
		document.forms["GoBack"].submit();
	}
</script>
<style>
body {
	background:
		url(http://www.ezyhealth.com/magazine/wp-content/uploads/2015/03/iStock_000046272610_Large.jpg)
		no-repeat;
	background-size: 100%;
}
</style>
</head>
<body>
</head>
<body>
	<br>
	<br>
	<br>
	<h1 align="center">
		<font size="10" style="background-color: buttonface;">Choose
			Update Operation</font>
	</h1>
	<form id="UpdateOperations" method="post" name="UpdateOperations"
		action="./Update_Method.ds">
		<br>
		<center>
			<br> <input type="submit" id="updateMethod" value="METHOD"
				style="height: 40px; width: 220px; font-size: 20px;"
				onclick="javascript: updateMethod()">
		</center>
	</form>
	<form id="UpdateOperations2" method="post" name="UpdateOperations2"
		action="./Update_Cuisine.ds">
		<br>
		<center>
			<input type="submit" id="updateCuisine" value="CUISINE"
				style="height: 40px; width: 220px; font-size: 20px;"
				onclick="javascript: updateCuisine()">
		</center>
	</form>
	<form id="UpdateOperations3" method="post" name="UpdateOperations3"
		action="./Update_Locale.ds">
		<br>
		<center>
			<input type="submit" id="updateLocale" value="LOCALE"
				style="height: 40px; width: 220px; font-size: 20px;"
				onclick="javascript: updateLocale()">
		</center>
	</form>
	<form id="UpdateOperations4" method="post" name="UpdateOperations4"
		action="./Update_Ingredient.ds">
		<br>
		<center>
			<input type="submit" id="updateIngredient" value="INGREDIENT"
				style="height: 40px; width: 220px; font-size: 20px;"
				onclick="javascript: updateIngredient()">
		</center>
	</form>
	<form id="UpdateOperations5" method="post" name="UpdateOperations5"
		action="./Choose_Cuisine_Update.ds">
		<br>
		<center>
			<input type="submit" id="updateRecipe" value="RECIPE"
				style="height: 40px; width: 220px; font-size: 20px;"
				onclick="javascript: updateRecipe()">
		</center>
	</form>
	<br>
	<form id="GoBack" method="post" name="GoBack" action="Main.jsp">
		<center>
			<input type="button" id="backButton" value="BACK"
				style="height: 40px; width: 220px; font-size: 20px;"
				onClick="javascript: goBack()">
		</center>
	</form>
</body>
</html>