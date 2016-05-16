<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Global Recipe</title>
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
		url(http://static.tumblr.com/18b905b6dd20d14351fd482511f65e19/upedghs/ClYnwijci/tumblr_static_bkr0agj1394wwkg480kwkwk0s.jpg)
		no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_global recipes table</font><br>
	</h1>
	<center>
		<form action="./deleteGlobalRecipe.ds" method="post">
			<table width="300">
				<tr>
					<td style="background-color: buttonface;">Global Recipe ID:</td>
					<td><input type="text" name="glrid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="deleteGlobalRecipe" value="DELETE"
				style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppGlobalRecipesTable.ds">
			<br> <input type="submit" id="viewAppGlobalRecipesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>Rows Affected: ${deletedGlobalRecipesRowsAffected}</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_global_recipes_trans table</font><br>
	</h1>
	<center>
		<form action="./deleteGlobalRecipeTrans.ds" method="post">
			<table width="350">
				<tr>
					<td style="background-color: buttonface;">Translated Global
						Recipe ID:</td>
					<td><input type="text" name="tglrid"></td>
				</tr>
			</table>
			<br> <input type="submit" id="deleteGlobalRecipesTrans"
				value="DELETE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppGlobalRecipesTransTable.ds">
			<br> <input type="submit" id="viewAppGlobalRecipesTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;"> <br>
		</form>
		<h4>Rows Affected: ${deletedGlobalTranslatedRecipesRowsAffected}</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_global_recipes_ingredients table</font><br>
	</h1>
	<center>
		<form action="./deleteGlobalRecipeIngredient.ds" method="post">
			<table width="300">
				<tr>
					<td style="background-color: buttonface;">Global Ingredient
						ID:</td>
					<td><input type="text" name="gliid"></td>
				</tr>
			</table>
			<br> <input type="submit" id="deleteGlobalRecipesIngredient"
				value="DELETE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppGlobalRecipesIngredients.ds">
			<br> <input type="submit"
				id="viewAppGlobalRecipesIngredientsTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>Rows Affected: ${deletedGlobalRecipeIngredientsRowsAffected}</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_global_recipes_description table</font><br>
	</h1>
	<center>
		<form action="./deleteGlobalRecipeDescription.ds" method="post">
			<table width="350">
				<tr>
					<td style="background-color: buttonface;">Global Recipe
						Description ID:</td>
					<td><input type="text" name="glrdid"></td>
				</tr>
			</table>
			<br> <input type="submit" id="deleteGlobalRecipesDescription"
				value="DELETE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppGlobalRecipesDescriptions.ds">
			<br> <input type="submit"
				id="viewAppGlobalRecipesDescriptionTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>Rows Affected: ${deletedGlobalRecipeDescriptionRowsAffected}</h4>
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