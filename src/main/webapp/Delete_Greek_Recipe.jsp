<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Greek Recipe</title>
<script>
	function goBack() {
		document.forms["GoBack"].submit();
	}
	function goHome() {
		document.forms["GoHome"].submit();
	}
</script>
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
		<form action="./viewGreekRecipesTable.ds">
			<br> <input type="submit" id="viewAppGreekRecipesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${deletedGreekRecipesRowsAffected}</font>
		</h4>
	</center>
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
		<h4>
			<font color="white">Rows Affected:
				${deletedGreekTranslatedRecipesRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_greek_recipes_ingredients table</font><br>
	</h1>
	<center>
		<form action="./deleteGreekRecipeIngredient.ds" method="post">
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
		<h4>
			<font color="white">Rows Affected:
				${deletedGreekRecipeIngredientsRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_greek_recipes_description table</font><br>
	</h1>
	<center>
		<form action="./deleteGreekRecipeDescription.ds" method="post">
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
		<h4>
			<font color="white">Rows Affected:
				${deletedGreekRecipeDescriptionRowsAffected}</font>
		</h4>
	</center>
	<form id="GoBack" method="post" name="GoBack"
		action="Choose_Cuisine_Delete.jsp">
		<center>
			<input type="button" id="backButton" value="BACK"
				style="height: 25px; width: 80px; font-size: 15px;"
				onClick="javascript: goBack()">
		</center>
	</form>
	<br>
	<form id="GoHome" method="post" name="GoHome" action="Main.jsp">
		<center>
			<input type="button" id="homeButton" value="HOME"
				style="height: 25px; width: 80px; font-size: 15px;"
				onClick="javascript: goHome()">
		</center>
	</form>
	<br>
</body>
</html>