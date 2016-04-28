<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Greek Recipe</title>
<style>
body {
	background:
		url(http://foodwineclick.files.wordpress.com/2012/05/02-black-bean-cucumber-tomato-salsa-ingredients-01_640.jpg)
		no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_greek recipes table</font><br>
	</h1>
	<center>
		<form action="./deleteGreekRecipe.ds" method="post">
			<table width="300">
				<tr>
					<td style="background-color: buttonface;">Greek Recipe ID:</td>
					<td><input type="text" name="grrid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="deleteGreekRecipe" value="DELETE"
				style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppGreekRecipesTable.ds">
			<br> <input type="submit" id="viewAppGreekRecipesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>Rows Affected: ${deletedGreekRecipesRowsAffected}</h4>
	</center>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_greek_recipes_trans table</font><br>
	</h1>
	<center>
		<form action="./deleteGreekRecipeTrans.ds" method="post">
			<table width="350">
				<tr>
					<td style="background-color: buttonface;">Translated Greek
						Recipe ID:</td>
					<td><input type="text" name="tgrrid"></td>
				</tr>
			</table>
			<br> <input type="submit" id="deleteGreekRecipesTrans"
				value="DELETE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppGreekRecipesTransTable.ds">
			<br> <input type="submit" id="viewAppGreekRecipesTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>Rows Affected: ${greekTranslatedRecipesRowsAffected}</h4>
	</center>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_greek_recipes_ingredients table</font><br>
	</h1>
	<center>
		<form action="./deleteGreekRecipeIngredients.ds" method="post">
			<table width="300">
				<tr>
					<td style="background-color: buttonface;">Greek Ingredient ID:</td>
					<td><input type="text" name="griid"></td>
				</tr>
			</table>
			<br> <input type="submit" id="deleteGreekRecipesIngredient"
				value="DELETE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppGreekRecipesIngredients.ds">
			<br> <input type="submit"
				id="viewAppGreekRecipesIngredientsTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>Rows Affected: ${deleteGreekRecipeIngredientsRowsAffected}</h4>
	</center>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_greek_recipes_description table</font><br>
	</h1>
	<center>
		<form action="./insertGreekRecipeDescription.ds" method="post">
			<table width="350">
				<tr>
					<td style="background-color: buttonface;">Greek Recipe
						Description ID:</td>
					<td><input type="text" name="grrdid"></td>
				</tr>
			</table>
			<br> <input type="submit" id="deleteGreekRecipesDescription"
				value="DELETE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppGreekRecipesDescriptions.ds">
			<br> <input type="submit"
				id="viewAppGreekRecipesDescriptionTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>Rows Affected: ${deleteGreekRecipeDescriptionRowsAffected}</h4>
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