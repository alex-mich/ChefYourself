<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Spanish Recipe</title>
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
		<font size="5">Insert into app_spanish recipes table</font><br>
	</h1>
	<center>
		<form action="./insertSpanishRecipe.ds" method="get">
			<table width="280">
				<tr>
					<td>Spanish Recipe ID:</td>
					<td><input type="text" name="sprid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertSpanishRecipes"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppSpanishRecipes">
			<br> <input type="submit" id="viewAppSpanishRecipesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
	</center>
	<h1 align="center">
		<font size="5">Insert into app_spanish_recipes_trans table</font><br>
	</h1>
	<center>
		<form action="./insertSpanishRecipeTrans.ds">
			<table width="350">
				<tr>
					<td>Translated Spanish Recipe ID:</td>
					<td><input type="text" name="tsprid"></td>
				</tr>
				<tr>
					<td>Spanish Recipe ID:</td>
					<td><input type="text" name="sprid2"></td>
				</tr>
				<tr>
					<td>Translated Cuisine ID:</td>
					<td><input type="text" name="tcid"></td>
				</tr>
				<tr>
					<td>Translated Method ID:</td>
					<td><input type="text" name="tmid"></td>
				</tr>
				<tr>
					<td>Locale:</td>
					<td><input type="text" name="loc"></td>
				</tr>
				<tr>
					<td>Spanish Recipe Name:</td>
					<td><input type="text" name="sprname"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertSpanishRecipesTrans"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppSpanishRecipesTransTable.ds">
			<br> <input type="submit" id="viewAppSpanishRecipesTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
	</center>
	<br>
	<h1 align="center">
		<font size="5">Insert into app_spanish_recipes_ingredients
			table</font><br>
	</h1>
	<center>
		<form action="./insertSpanishRecipeIngredients.ds">
			<table width="400">
				<tr>
					<td>Spanish Ingredient ID:</td>
					<td><input type="text" name="spiid"></td>
				</tr>
				<tr>
					<td>Translated Spanish Recipe ID:</td>
					<td><input type="text" name="tsprid2"></td>
				</tr>
				<tr>
					<td>Translated Ingredient ID:</td>
					<td><input type="text" name="tinid"></td>
				</tr>
				<tr>
					<td>Spanish Recipe Ingredient Quantity:</td>
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
	</center>
	<br>
	<h1 align="center">
		<font size="5">Insert into app_spanish_recipes_description
			table</font><br>
	</h1>
	<center>
		<form action="./insertSpanishRecipeDescription">
			<table width="500">
				<tr>
					<td>Spanish Recipe Description ID:</td>
					<td><input type="text" name="sprdid"></td>
				</tr>
				<tr>
					<td>Translated Spanish Recipe ID:</td>
					<td><input type="text" name="tsprid3"></td>
				</tr>
				<tr>
					<td>Spanish Recipe Description:</td>
					<td><textarea name="sprdesc" rows="10" cols="30"></textarea></td>
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