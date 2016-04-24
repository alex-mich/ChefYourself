<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Greek Recipe</title>
<style>
body {
	background:
		url(http://www.hotelcielo.com/wp-content/uploads/2012/04/DSC1916.jpg)
		no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
	<form action="./insertGreekRecipe.ds" method="get">
		<br>
		<h1 align="center">
			<font size="5">Insert into app_greek recipes table</font><br>
		</h1>
		<center>
			<table width="280">
				<tr>
					<td>Greek Recipe ID:</td>
					<td><input type="text" name="grrid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertGreekRecipe" value="INSERT"
				style="height: 25px; width: 80px; font-size: 15px;" />
		</center>
	</form>
	<input type="submit" id="viewAppGreekRecipesTable" value="VIEW TABLE"
		style="height: 25px; width: 100px; font-size: 15px;" />
	<h1 align="center">
		<font size="5">Insert into app_greek_recipes_trans table</font><br>
	</h1>
	<table width="350">
		<tr>
			<td>Translated Greek Recipe ID:</td>
			<td><input type="text" id="tgrrid"></td>
		</tr>
		<tr>
			<td>Greek Recipe ID:</td>
			<td><input type="text" id="grrid2"></td>
		</tr>
		<tr>
			<td>Translated Cuisine ID:</td>
			<td><input type="text" id="tcid"></td>
		</tr>
		<tr>
			<td>Locale:</td>
			<td><input type="text" id="loc"></td>
		</tr>
		<tr>
			<td>Translated Method ID:</td>
			<td><input type="text" id="tmid"></td>
		</tr>
		<tr>
			<td>Greek Recipe Name:</td>
			<td><input type="text" id="grrname"></td>
		</tr>
	</table>
	<br>
	<input type="submit" id="insertGreekRecipesTrans" value="INSERT"
		style="height: 25px; width: 80px; font-size: 15px;">
	<input type="submit" id="viewAppGreekRecipesTransTable"
		value="VIEW TABLE"
		style="height: 25px; width: 100px; font-size: 15px;">
	<br>
	<h1 align="center">
		<font size="5">Insert into app_greek_recipes_ingredients table</font><br>
	</h1>
	<table width="400">
		<tr>
			<td>Greek Ingredient ID:</td>
			<td><input type="text" id="griid"></td>
		</tr>
		<tr>
			<td>Translated Greek Recipe ID:</td>
			<td><input type="text" id="tgrrid2"></td>
		</tr>
		<tr>
			<td>Translated Ingredient ID:</td>
			<td><input type="text" id="tinid"></td>
		</tr>
		<tr>
			<td>Greek Recipe Ingredient Quantity:</td>
			<td><input type="text" id="grriquan"></td>
		</tr>
	</table>
	<br>
	<input type="submit" id="insertGreekRecipesIngredients" value="INSERT"
		style="height: 25px; width: 80px; font-size: 15px;">
	<input type="submit" id="viewAppGreekRecipesIngredientsTable"
		value="VIEW TABLE"
		style="height: 25px; width: 100px; font-size: 15px;">
	<br>
	<h1 align="center">
		<font size="5">Insert into app_greek_recipes_description table</font><br>
	</h1>
	<table width="500">
		<tr>
			<td>Greek Recipe Description ID:</td>
			<td><input type="text" id="grrdid"></td>
		</tr>
		<tr>
			<td>Translated Greek Recipe ID:</td>
			<td><input type="text" id="tgrrid3"></td>
		</tr>
		<tr>
			<td>Greek Recipe Description:</td>
			<td><textarea id="grrdesc" rows="10" cols="30"></textarea></td>
		</tr>
	</table>
	<br>
	<input type="submit" id="insertGreekRecipesDescription" value="INSERT"
		style="height: 25px; width: 80px; font-size: 15px;">
	<input type="submit" id="viewAppGreekRecipesDescriptionTable"
		value="VIEW TABLE"
		style="height: 25px; width: 100px; font-size: 15px;">
	<br>
	<br>
	<input type="button" id="backButton" value="BACK"
		style="height: 25px; width: 80px; font-size: 15px;"
		onClick="history.go(-1);return true;">
	</center>
</body>
</html>