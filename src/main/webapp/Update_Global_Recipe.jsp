<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Global Recipe</title>
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
		<font size="5" style="background-color: buttonface;">Update on
			app_global recipes table</font><br>
	</h1>
	<center>
		<form action="./updateGlobalRecipe.ds">
			<table width="700">
				<tr>
					<td style="background-color: buttonface;">Current Global
						Recipe ID:</td>
					<td><input type="text" name="curglrid1"></td>
					<td style="background-color: buttonface;">New Global Recipe
						ID:</td>
					<td><input type="text" name="newglrid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateGlobalRecipe" value="UPDATE"
				style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppGlobalRecipesTable.ds">
			<br> <input type="submit" id="viewAppGlobalRecipesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="black">Rows Affected:
				${globalRecipesRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_global_recipes_trans table</font><br>
	</h1>
	<center>
		<form action="./updateGlobalRecipeTrans.ds">
			<table width="800">
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Global Recipe ID:</td>
					<td><input type="text" name="curtglrid"></td>
					<td style="background-color: buttonface;">New Translated
						Global Recipe ID:</td>
					<td><input type="text" name="newtglrid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Global
						Recipe ID:</td>
					<td><input type="text" name="curglrid2"></td>
					<td style="background-color: buttonface;">New Global Recipe
						ID:</td>
					<td><input type="text" name="newglrid2"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Cuisine ID:</td>
					<td><input type="text" name="curtcid"></td>
					<td style="background-color: buttonface;">New Translated
						Cuisine ID:</td>
					<td><input type="text" name="newtcid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Locale:</td>
					<td><input type="text" name="curloc"></td>
					<td style="background-color: buttonface;">New Locale:</td>
					<td><input type="text" name="newloc"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Method ID:</td>
					<td><input type="text" name="curtmid"></td>
					<td style="background-color: buttonface;">New Translated
						Method ID:</td>
					<td><input type="text" name="newtmid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Global
						Recipe Name:</td>
					<td><input type="text" name="curglrname"></td>
					<td style="background-color: buttonface;">New Global Recipe
						Name:</td>
					<td><input type="text" name="newglrname"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateGlobalRecipesTrans"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppGlobalRecipesTransTable.ds">
			<br> <input type="submit" id="viewAppGlobalRecipesTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="black">Rows Affected:
				${TranslatedGlobalRecipesRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_global_recipes_ingredients table</font><br>
	</h1>
	<center>
		<form action="./updateGlobalRecipeIngredients.ds">
			<table width="900">
				<tr>
					<td style="background-color: buttonface;">Current Global
						Ingredient ID:</td>
					<td><input type="text" name="curgliid"></td>
					<td style="background-color: buttonface;">New Global
						Ingredient ID:</td>
					<td><input type="text" name="newgliid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Global Recipe ID:</td>
					<td><input type="text" name="curtglrid2"></td>
					<td style="background-color: buttonface;">New Translated
						Global Recipe ID:</td>
					<td><input type="text" name="newtglrid2"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Ingredient ID:</td>
					<td><input type="text" name="curtinid"></td>
					<td style="background-color: buttonface;">New Translated
						Ingredient ID:</td>
					<td><input type="text" name="newtinid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Global
						Recipe Ingredient Quantity:</td>
					<td><input type="text" name="curglriquan"></td>
					<td style="background-color: buttonface;">New Global Recipe
						Ingredient Quantity:</td>
					<td><input type="text" name="newglriquan"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateGlobalRecipesIngredient"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppGlobalRecipesIngredients.ds">
			<br> <input type="submit"
				id="viewAppGlobalRecipesIngredientsTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="black">Rows Affected:
				${globalRecipeIngrdientsRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_global_recipes_description table</font><br>
	</h1>
	<center>
		<form action="./updateGlobalRecipeDescription.ds">
			<table width="850">
				<tr>
					<td style="background-color: buttonface;">Current Global
						Recipe Description ID:</td>
					<td><input type="text" name="curglrdid"></td>
					<td style="background-color: buttonface;">New Global Recipe
						Description ID:</td>
					<td><input type="text" name="newglrdid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Global Recipe ID:</td>
					<td><input type="text" name="curtglrid3"></td>
					<td style="background-color: buttonface;">New Translated
						Global Recipe ID:</td>
					<td><input type="text" name="newtglrid3"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Global
						Recipe Description:</td>
					<td></td>
					<td style="background-color: buttonface;">New Global Recipe
						Description:</td>
				</tr>
			</table>
			<table>
				<tr>
					<td><textarea name="curglrdesc" rows="10" cols="50"></textarea></td>
					<td><textarea name="newglrdesc" rows="10" cols="50"></textarea></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateGlobalRecipesDescription"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppGlobalRecipesDescriptions.ds">
			<br> <input type="submit"
				id="viewAppGlobalRecipesDescriptionTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="black">Rows Affected:
				${globalRecipeDescriptionRowsAffected}</font>
		</h4>
	</center>
	<center>
		<input type="button" id="backButton" value="BACK"
			style="height: 25px; width: 80px; font-size: 15px;"
			onClick="history.go(-1);return true;">
	</center>
	<br>
</body>
</html>