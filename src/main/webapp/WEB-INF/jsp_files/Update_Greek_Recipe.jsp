<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Greek Recipe</title>
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
	background: url(http://whatfoodlookslike.com/img/thai.jpg) no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_greek recipes table</font><br>
	</h1>
	<center>
		<form action="./updateGreekRecipe.ds" method="post">
			<table width="700">
				<tr>
					<td style="background-color: buttonface;">Current Greek Recipe
						ID:</td>
					<td><input type="text" name="curgrrid1"></td>
					<td style="background-color: buttonface;">New Greek Recipe ID:</td>
					<td><input type="text" name="newgrrid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateGreekRecipe" value="UPDATE"
				style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewGreekRecipesTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppGreekRecipesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="black">Rows Affected:
				${updatedGreekRecipeRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_greek_recipes_trans table</font><br>
	</h1>
	<center>
		<form action="./updateGreekTranslatedRecipe.ds" method="post">
			<table width="800">
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Greek Recipe ID:</td>
					<td><input type="text" name="curtgrrid"></td>
					<td style="background-color: buttonface;">New Translated Greek
						Recipe ID:</td>
					<td><input type="text" name="newtgrrid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Greek Recipe
						ID:</td>
					<td><input type="text" name="curgrrid2"></td>
					<td style="background-color: buttonface;">New Greek Recipe ID:</td>
					<td><input type="text" name="newgrrid2"></td>
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
					<td style="background-color: buttonface;">Current Greek Recipe
						Name:</td>
					<td><input type="text" name="curgrrname"></td>
					<td style="background-color: buttonface;">New Greek Recipe
						Name:</td>
					<td><input type="text" name="newgrrname"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateGreekRecipesTrans"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewGreekTranslatedRecipesTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppGreekRecipesTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="black">Rows Affected:
				${updatedTranslatedGreekRecipeRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_greek_recipes_ingredients table</font><br>
	</h1>
	<center>
		<form action="./updateGreekRecipeIngredient.ds" method="post">
			<table width="900">
				<tr>
					<td style="background-color: buttonface;">Current Greek
						Ingredient ID:</td>
					<td><input type="text" name="curgriid"></td>
					<td style="background-color: buttonface;">New Greek Ingredient
						ID:</td>
					<td><input type="text" name="newgriid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Greek Recipe ID:</td>
					<td><input type="text" name="curtgrrid2"></td>
					<td style="background-color: buttonface;">New Translated Greek
						Recipe ID:</td>
					<td><input type="text" name="newtgrrid2"></td>
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
					<td style="background-color: buttonface;">Current Greek Recipe
						Ingredient Quantity:</td>
					<td><input type="text" name="curgrriquan"></td>
					<td style="background-color: buttonface;">New Greek Recipe
						Ingredient Quantity:</td>
					<td><input type="text" name="newgrriquan"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateGreekRecipesIngredient"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewGreekRecipeIngredientsTable.ds" target="_blank">
			<br> <input type="submit"
				id="viewAppGreekRecipesIngredientsTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="black">Rows Affected:
				${updatedGreekRecipeIngrdientRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_greek_recipes_description table</font><br>
	</h1>
	<center>
		<form action="./updateGreekRecipeDescription.ds" method="post">
			<table width="850">
				<tr>
					<td style="background-color: buttonface;">Current Greek Recipe
						Description ID:</td>
					<td><input type="text" name="curgrrdid"></td>
					<td style="background-color: buttonface;">New Greek Recipe
						Description ID:</td>
					<td><input type="text" name="newgrrdid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Greek Recipe ID:</td>
					<td><input type="text" name="curtgrrid3"></td>
					<td style="background-color: buttonface;">New Translated Greek
						Recipe ID:</td>
					<td><input type="text" name="newtgrrid3"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Greek Recipe
						Description:</td>
					<td></td>
					<td style="background-color: buttonface;">New Greek Recipe
						Description:</td>
				</tr>
			</table>
			<table>
				<tr>
					<td><textarea name="curgrrdesc" rows="10" cols="50"></textarea></td>
					<td><textarea name="newgrrdesc" rows="10" cols="50"></textarea></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateGreekRecipesDescription"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewGreekRecipeDescriptionsTable.ds" target="_blank">
			<br> <input type="submit"
				id="viewAppGreekRecipesDescriptionTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="black">Rows Affected:
				${updatedGreekRecipeDescriptionRowsAffected}</font>
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