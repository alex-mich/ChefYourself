<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Spanish Recipe</title>
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
		url(http://foodandphotography.blog.com/files/2012/05/salsa-for-blog-1024x1024.jpg)
		no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Insert
			into app_spanish recipes table</font><br>
	</h1>
	<center>
		<form action="./insertSpanishRecipe.ds" method="post">
			<table width="280">
				<tr>
					<td style="background-color: buttonface;">Spanish Recipe ID:</td>
					<td><input type="text" name="sprid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertSpanishRecipes"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewSpanishRecipesTable.ds">
			<br> <input type="submit" id="viewAppSpanishRecipesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${spanishRecipesRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Insert
			into app_spanish_recipes_trans table</font><br>
	</h1>
	<center>
		<form action="./insertSpanishRecipeTrans.ds" method="post">
			<table width="350">
				<tr>
					<td style="background-color: buttonface;">Translated Spanish
						Recipe ID:</td>
					<td><input type="text" name="tsprid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Spanish Recipe ID:</td>
					<td><input type="text" name="sprid2"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Translated Cuisine
						ID:</td>
					<td><input type="text" name="tcid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Translated Method
						ID:</td>
					<td><input type="text" name="tmid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Locale:</td>
					<td><input type="text" name="loc"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Spanish Recipe Name:</td>
					<td><input type="text" name="sprname"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertSpanishRecipesTrans"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewSpanishTranslatedRecipesTable.ds">
			<br> <input type="submit" id="viewAppSpanishRecipesTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${spanishTranslatedRecipesRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Insert
			into app_spanish_recipes_ingredients table</font><br>
	</h1>
	<center>
		<form action="./insertSpanishRecipeIngredients.ds" method="post">
			<table width="400">
				<tr>
					<td style="background-color: buttonface;">Spanish Ingredient
						ID:</td>
					<td><input type="text" name="spiid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Translated Spanish
						Recipe ID:</td>
					<td><input type="text" name="tsprid2"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Translated
						Ingredient ID:</td>
					<td><input type="text" name="tinid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Spanish Recipe
						Ingredient Quantity:</td>
					<td><input type="text" name="spriquan"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertSpanishRecipesIngredients"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppSpanishRecipesIngredients.ds">
			<br> <input type="submit"
				id="viewAppSpanishRecipesIngredientsTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${spanishRecipeIngredientsRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Insert
			into app_spanish_recipes_description table</font><br>
	</h1>
	<center>
		<form action="./insertSpanishRecipeDescription.ds" method="post">
			<table width="430">
				<tr>
					<td style="background-color: buttonface;">Spanish Recipe
						Description ID:</td>
					<td><input type="text" name="sprdid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Translated Spanish
						Recipe ID:</td>
					<td><input type="text" name="tsprid3"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Spanish Recipe
						Description:</td>
				</tr>
			</table>
			<table>
				<tr>
					<td><textarea name="sprdesc" rows="10" cols="50"></textarea></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertSpanishRecipesDescription"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppSpanishRecipesDescriptions.ds">
			<br> <input type="submit"
				id="viewAppSpanishRecipesDescriptionTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${spanishDescriptionRowsAffected}</font>
		</h4>
	</center>
	<form id="GoBack" method="post" name="GoBack"
		action="Choose_Cuisine_Insert.jsp">
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