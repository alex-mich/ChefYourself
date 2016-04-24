<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Global Recipe</title>
<style>
body {
	background:
		url(http://paulapuffer.net/wp-content/uploads/2014/02/DSC_30381.jpg)
		no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
	<br>
	<h1 align="center">
		<font size="5">Insert into app_global recipes table</font><br>
	</h1>
	<center>
		<form action="./insertGlobalRecipe.ds" method="get">
			<table width="280">
				<tr>
					<td>Global Recipe ID:</td>
					<td><input type="text" name="glrid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertGlobalRecipe" value="INSERT"
				style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppGlobalRecipesTable.ds">
			<br> <input type="submit" id="viewAppGlobalRecipesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
	</center>
	<h1 align="center">
		<font size="5">Insert into app_global_recipes_trans table</font><br>
	</h1>
	<center>
		<form action="./insertGlobalRecipeTrans.ds">
			<table width="350">
				<tr>
					<td>Translated Global Recipe ID:</td>
					<td><input type="text" id="tglrid"></td>
				</tr>
				<tr>
					<td>Global Recipe ID:</td>
					<td><input type="text" id="glrid2"></td>
				</tr>
				<tr>
					<td>Translated Cuisine ID:</td>
					<td><input type="text" id="tcid"></td>
				</tr>
				<tr>
					<td>Translated Method ID:</td>
					<td><input type="text" id="tmid"></td>
				</tr>
				<tr>
					<td>Locale:</td>
					<td><input type="text" id="loc"></td>
				</tr>
				<tr>
					<td>Global Recipe Name:</td>
					<td><input type="text" id="glrname"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertGlobalRecipesTrans"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action=./viewAppGlobalRecipesTransTable.ds>
			<br> <input type="submit" id="viewAppGlobalRecipesTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
	</center>
	<br>
	<h1 align="center">
		<font size="5">Insert into app_global_recipes_ingredients table</font><br>
	</h1>
	<center>
		<form action="./insertGlobalRecipeIngredients.ds">
			<table width="400">
				<tr>
					<td>Global Ingredient ID:</td>
					<td><input type="text" id="gliid"></td>
				</tr>
				<tr>
					<td>Translated Global Recipe ID:</td>
					<td><input type="text" id="tglrid2"></td>
				</tr>
				<tr>
					<td>Translated Ingredient ID:</td>
					<td><input type="text" id="tinid"></td>
				</tr>
				<tr>
					<td>Global Recipe Ingredient Quantity:</td>
					<td><input type="text" id="glriquan"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertGlobalRecipesIngredients"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppGlobalRecipesIngredients.ds">
			<br> <input type="submit"
				id="viewAppGlobalRecipesIngredientsTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
	</center>
	<br>
	<h1 align="center">
		<font size="5">Insert into app_global_recipes_description table</font><br>
	</h1>
	<center>
		<form action="./insertGlobalRecipeDescription.ds">
			<table width="500">
				<tr>
					<td>Global Recipe Description ID:</td>
					<td><input type="text" id="glrdid"></td>
				</tr>
				<tr>
					<td>Translated Global Recipe ID:</td>
					<td><input type="text" id="tglrid3"></td>
				</tr>
				<tr>
					<td>Global Recipe Description:</td>
					<td><textarea id="glrdesc" rows="10" cols="30"></textarea></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertGlobalRecipesDescription"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppGlobalRecipesDescriptions.ds">
			<br> <input type="submit"
				id="viewAppGlobalRecipesDescriptionTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
	</center>
	<br>
	<center>
		<input type="button" id="backButton" value="BACK"
			style="height: 25px; width: 80px; font-size: 15px;"
			onClick="history.go(-1);return true;">
	</center>
</body>
</html>