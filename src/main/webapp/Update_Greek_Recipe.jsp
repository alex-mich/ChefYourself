<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Greek Recipe</title>
<style>
body {
	background: url(http://whatfoodlookslike.com/img/thai.jpg) no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
	<br>
	<h1 align="center">
		<font size="5">Update on app_greek recipes table</font><br>
	</h1>
	<center>
		<form action="./updateGreekRecipe.ds">
			<table width="280">
				<tr>
					<td>Greek Recipe ID:</td>
					<td><input type="text" name="grrid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateGreekRecipe" value="UPDATE"
				style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppGreekRecipesTable.ds">
			<br> <input type="submit" id="viewAppGreekRecipesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
	</center>
	<h1 align="center">
		<font size="5">Update on app_greek_recipes_trans table</font><br>
	</h1>
	<center>
		<form action="./updateGreekRecipeTrans.ds">
			<table width="350">
				<tr>
					<td>Translated Greek Recipe ID:</td>
					<td><input type="text" name="tgrrid"></td>
				</tr>
				<tr>
					<td>Greek Recipe ID:</td>
					<td><input type="text" name="grrid2"></td>
				</tr>
				<tr>
					<td>Translated Cuisine ID:</td>
					<td><input type="text" name="tcid"></td>
				</tr>
				<tr>
					<td>Locale:</td>
					<td><input type="text" name="loc"></td>
				</tr>
				<tr>
					<td>Translated Method ID:</td>
					<td><input type="text" name="tmid"></td>
				</tr>
				<tr>
					<td>Greek Recipe Name:</td>
					<td><input type="text" name="grrname"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateGreekRecipesTrans"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppGreekRecipesTransTable.ds">
			<br> <input type="submit" id="viewAppGreekRecipesTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
	</center>
	<br>
	<h1 align="center">
		<font size="5">Update on app_greek_recipes_ingredients table</font><br>
	</h1>
	<center>
		<form action="./updateGreekRecipeIngredients.ds">
			<table width="400">
				<tr>
					<td>Greek Ingredient ID:</td>
					<td><input type="text" name="griid"></td>
				</tr>
				<tr>
					<td>Translated Greek Recipe ID:</td>
					<td><input type="text" name="tgrrid2"></td>
				</tr>
				<tr>
					<td>Translated Ingredient ID:</td>
					<td><input type="text" name="tinid"></td>
				</tr>
				<tr>
					<td>Greek Recipe Ingredient Quantity:</td>
					<td><input type="text" name="grriquan"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateGreekRecipesIngredient"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppGreekRecipesIngredients.ds">
			<br> <input type="submit"
				id="viewAppGreekRecipesIngredientsTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
	</center>
	<br>
	<h1 align="center">
		<font size="5">Update on app_greek_recipes_description table</font><br>
	</h1>
	<center>
		<form action="./updateGreekRecipeDescription.ds">
			<table width="500">
				<tr>
					<td>Greek Recipe Description ID:</td>
					<td><input type="text" name="grrdid"></td>
				</tr>
				<tr>
					<td>Translated Greek Recipe ID:</td>
					<td><input type="text" name="tgrrid3"></td>
				</tr>
				<tr>
					<td>Greek Recipe Description:</td>
					<td><textarea name="grrdesc" rows="10" cols="30"></textarea></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateGreekRecipesDescription"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppGreekRecipesDescriptions.ds">
			<br> <input type="submit"
				id="viewAppGreekRecipesDescriptionTable" value="VIEW TABLE"
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