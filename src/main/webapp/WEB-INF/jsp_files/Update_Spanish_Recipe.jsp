<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Spanish Recipe</title>
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
		url(http://informedexplorer.com/wp-content/uploads/2014/05/assorteddishesrangdebasantidhaba_sandhira_13867531372390.jpg)
		no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_spanish recipes table</font><br>
	</h1>
	<center>
		<form action="./updateSpanishRecipe.ds" method="post">
			<table width="700">
				<tr>
					<td style="background-color: buttonface;">Current Spanish
						Recipe ID:</td>
					<td><input type="text" name="cursprid1"></td>
					<td style="background-color: buttonface;">New Spanish Recipe
						ID:</td>
					<td><input type="text" name="newsprid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateSpanishRecipes"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewSpanishRecipesTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppSpanishRecipesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${updatedSpanishRecipeRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_spanish_recipes_trans table</font><br>
	</h1>
	<center>
		<form action="./updateTranslatedSpanishRecipe.ds" method="post">
			<table width="800">
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Spanish Recipe ID:</td>
					<td><input type="text" name="curtsprid"></td>
					<td style="background-color: buttonface;">New Translated
						Spanish Recipe ID:</td>
					<td><input type="text" name="newtsprid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Spanish
						Recipe ID:</td>
					<td><input type="text" name="cursprid2"></td>
					<td style="background-color: buttonface;">New Spanish Recipe
						ID:</td>
					<td><input type="text" name="newsprid2"></td>
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
					<td style="background-color: buttonface;">Current Translated
						Method ID:</td>
					<td><input type="text" name="curtmid"></td>
					<td style="background-color: buttonface;">New Translated
						Method ID:</td>
					<td><input type="text" name="newtmid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Locale:</td>
					<td><input type="text" name="curloc"></td>
					<td style="background-color: buttonface;">New Locale:</td>
					<td><input type="text" name="newloc"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Spanish
						Recipe Name:</td>
					<td><input type="text" name="cursprname"></td>
					<td style="background-color: buttonface;">New Spanish Recipe
						Name:</td>
					<td><input type="text" name="newsprname"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateSpanishRecipesTrans"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewSpanishTranslatedRecipesTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppSpanishRecipesTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${updatedTranslatedSpanishRecipeRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_spanish_recipes_ingredients table</font><br>
	</h1>
	<center>
		<form action="./updateSpanishRecipeIngredient.ds" method="post">
			<table width="900">
				<tr>
					<td style="background-color: buttonface;">Current Spanish
						Ingredient ID:</td>
					<td><input type="text" name="curspiid"></td>
					<td style="background-color: buttonface;">New Spanish
						Ingredient ID:</td>
					<td><input type="text" name="newspiid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Spanish Recipe ID:</td>
					<td><input type="text" name="curtsprid2"></td>
					<td style="background-color: buttonface;">New Translated
						Spanish Recipe ID:</td>
					<td><input type="text" name="newtsprid2"></td>
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
					<td style="background-color: buttonface;">Current Spanish
						Recipe Ingredient Quantity:</td>
					<td><input type="text" name="curspriquan"></td>
					<td style="background-color: buttonface;">New Spanish Recipe
						Ingredient Quantity:</td>
					<td><input type="text" name="newspriquan"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateSpanishRecipesIngredients"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewSpanishRecipeIngredientsTable.ds" target="_blank">
			<br> <input type="submit"
				id="viewAppSpanishRecipesIngredientsTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${updatedSpanishRecipeIngrdientRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_spanish_recipes_description table</font><br>
	</h1>
	<center>
		<form action="./updateSpanishRecipeDescription.ds" method="post">
			<table width="850">
				<tr>
					<td style="background-color: buttonface;">Current Spanish
						Recipe Description ID:</td>
					<td><input type="text" name="cursprdid"></td>
					<td style="background-color: buttonface;">New Spanish Recipe
						Description ID:</td>
					<td><input type="text" name="newsprdid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Spanish Recipe ID:</td>
					<td><input type="text" name="curtsprid3"></td>
					<td style="background-color: buttonface;">New Translated
						Spanish Recipe ID:</td>
					<td><input type="text" name="newtsprid3"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Spanish
						Recipe Description:</td>
					<td></td>
					<td style="background-color: buttonface;">New Spanish Recipe
						Description:</td>
				</tr>
			</table>
			<table>
				<tr>
					<td><textarea name="cursprdesc" rows="10" cols="50"></textarea></td>
					<td><textarea name="newsprdesc" rows="10" cols="50"></textarea></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateSpanishRecipesDescription"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewSpanishRecipeDescriptionsTable.ds" target="_blank">
			<br> <input type="submit"
				id="viewAppSpanishRecipesDescriptionTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${updatedSpanishRecipeDescriptionRowsAffected}</font>
		</h4>
	</center>
	<form id="GoBack" method="post" name="GoBack"
		action="./Choose_Cuisine_Update.ds">
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