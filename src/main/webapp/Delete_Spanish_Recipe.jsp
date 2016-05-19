<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Spanish Recipe</title>
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
		<form action="./deleteSpanishRecipe.ds" method="post">
			<table width="300">
				<tr>
					<td style="background-color: buttonface;">Spanish Recipe ID:</td>
					<td><input type="text" name="sprid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="deleteSpanishRecipe"
				value="DELETE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewSpanishRecipesTable.ds">
			<br> <input type="submit" id="viewAppSpanishRecipesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${deletedSpanishRecipesRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_spanish_recipes_trans table</font><br>
	</h1>
	<center>
		<form action="./deleteSpanishRecipeTrans.ds" method="post">
			<table width="350">
				<tr>
					<td style="background-color: buttonface;">Translated Spanish
						Recipe ID:</td>
					<td><input type="text" name="tsprid"></td>
				</tr>
			</table>
			<br> <input type="submit" id="deleteSpanishRecipesTrans"
				value="DELETE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewSpanishTranslatedRecipesTable.ds">
			<br> <input type="submit" id="viewAppSpanishRecipesTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="black">Rows Affected:
				${deletedSpanishTranslatedRecipesRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_spanish_recipes_ingredients table</font><br>
	</h1>
	<center>
		<form action="./deleteSpanishRecipeIngredient.ds" method="post">
			<table width="300">
				<tr>
					<td style="background-color: buttonface;">Spanish Ingredient
						ID:</td>
					<td><input type="text" name="spiid"></td>
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
		<h4>
			<font color="black">Rows Affected:
				${deletedSpanishRecipeIngredientsRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_spanish_recipes_description table</font><br>
	</h1>
	<center>
		<form action="./deleteSpanishRecipeDescription.ds" method="post">
			<table width="350">
				<tr>
					<td style="background-color: buttonface;">Spanish Recipe
						Description ID:</td>
					<td><input type="text" name="sprdid"></td>
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
		<h4>
			<font color="black">Rows Affected:
				${deletedSpanishRecipeDescriptionRowsAffected}</font>
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