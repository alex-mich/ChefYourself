<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Global Recipe</title>
<style>
body {
	background:
		url(http://static.tumblr.com/18b905b6dd20d14351fd482511f65e19/upedghs/ClYnwijci/tumblr_static_bkr0agj1394wwkg480kwkwk0s.jpg)
		no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete from app_global recipes table</font><br>
	</h1>
	<center>
		<table width="300">
			<tr>
				<td style="background-color: buttonface;">Global Recipe ID:</td>
				<td><input type="text" id="glrid1"></td>
			</tr>
		</table>
		<br> <input type="submit" id="deleteGlobalRecipe" value="DELETE"
			style="height: 25px; width: 80px; font-size: 15px;"> <input
			type="submit" id="viewAppGlobalRecipesTable" value="VIEW TABLE"
			style="height: 25px; width: 100px; font-size: 15px;">
		<h1 align="center">
			<font size="5" style="background-color: buttonface;">Delete from app_global_recipes_trans table</font><br>
		</h1>
		<table width="350">
			<tr>
				<td style="background-color: buttonface;">Translated Global Recipe ID:</td>
				<td><input type="text" id="tglrid"></td>
			</tr>
		</table>
		<br> <input type="submit" id="deleteGlobalRecipesTrans"
			value="DELETE" style="height: 25px; width: 80px; font-size: 15px;">
		<input type="submit" id="viewAppGlobalRecipesTransTable"
			value="VIEW TABLE"
			style="height: 25px; width: 100px; font-size: 15px;"> <br>
		<h1 align="center">
			<font size="5" style="background-color: buttonface;">Delete from app_global_recipes_ingredients
				table</font><br>
		</h1>
		<table width="300">
			<tr>
				<td style="background-color: buttonface;">Global Ingredient ID:</td>
				<td><input type="text" id="gliid"></td>
			</tr>
		</table>
		<br> <input type="submit" id="deleteGlobalRecipesIngredient"
			value="DELETE" style="height: 25px; width: 80px; font-size: 15px;">
		<input type="submit" id="viewAppGlobalRecipesIngredientsTable"
			value="VIEW TABLE"
			style="height: 25px; width: 100px; font-size: 15px;"> <br>
		<h1 align="center">
			<font size="5" style="background-color: buttonface;">Delete from app_global_recipes_description
				table</font><br>
		</h1>
		<table width="350">
			<tr>
				<td style="background-color: buttonface;">Global Recipe Description ID:</td>
				<td><input type="text" id="glrdid"></td>
			</tr>
		</table>
		<br> <input type="submit" id="deleteGlobalRecipesDescription"
			value="DELETE" style="height: 25px; width: 80px; font-size: 15px;">
		<input type="submit" id="viewAppGlobalRecipesDescriptionTable"
			value="VIEW TABLE"
			style="height: 25px; width: 100px; font-size: 15px;"> <br>
		<br> <input type="button" id="backButton" value="BACK"
			style="height: 25px; width: 80px; font-size: 15px;"
			onClick="history.go(-1);return true;">
	</center>
</body>
</html>