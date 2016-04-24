<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Spanish Recipe</title>
<style>
body {
	background:
		url(https://upload.wikimedia.org/wikipedia/commons/c/c6/Green_curry_ingredients.jpg)
		no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_spanish recipes table</font><br>
	</h1>
	<center>
		<form action="./deleteSpanishRecipe.ds">
			<table width="300">
				<tr>
					<td style="background-color: buttonface;">Spanish Recipe ID:</td>
					<td><input type="text" id="sprid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="deleteSpanishRecipe"
				value="DELETE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppSpanishRecipes">
			<br> <input type="submit" id="viewAppSpanishRecipesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
	</center>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_spanish_recipes_trans table</font><br>
	</h1>
	<center>
		<form action="./deleteSpanishRecipeTrans.ds">
			<table width="350">
				<tr>
					<td style="background-color: buttonface;">Translated Spanish
						Recipe ID:</td>
					<td><input type="text" id="tsprid"></td>
				</tr>
			</table>
			<br> <input type="submit" id="deleteSpanishRecipesTrans"
				value="DELETE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppSpanishRecipesTransTable.ds">
			<br> <input type="submit" id="viewAppSpanishRecipesTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
	</center>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_spanish_recipes_ingredients table</font><br>
	</h1>
	<center>
		<form action="./deleteSpanishRecipeIngredients.ds">
			<table width="300">
				<tr>
					<td style="background-color: buttonface;">Spanish Ingredient
						ID:</td>
					<td><input type="text" id="spiid"></td>
				</tr>
			</table>
			<br> <input type="submit" id="deleteSpanishRecipesIngredient"
				value="DELETE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppSpanishRecipesIngredients.ds">
			<br> <input type="submit"
				id="viewAppSpanishRecipesIngredientsTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
	</center>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_spanish_recipes_description table</font><br>
	</h1>
	<center>
		<form action="./deleteSpanishRecipeDescription">
			<table width="350">
				<tr>
					<td style="background-color: buttonface;">Spanish Recipe
						Description ID:</td>
					<td><input type="text" id="sprdid"></td>
				</tr>
			</table>
			<br> <input type="submit" id="deleteSpanishRecipesDescription"
				value="DELETE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppSpanishRecipesDescriptions.ds">
			<br> <input type="submit"
				id="viewAppSpanishRecipesDescriptionTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
	</center>
	<br>
	<center>
		<input type="button" id="backButton" value="BACK"
			style="height: 25px; width: 80px; font-size: 15px;"
			onClick="history.go(-1);return true;">
	</center>
	<br>
</body>
</html>