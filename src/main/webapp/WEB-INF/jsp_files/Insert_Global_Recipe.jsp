<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Global Recipe</title>
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
		url(http://paulapuffer.net/wp-content/uploads/2014/02/DSC_30381.jpg)
		no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Insert
			into app_global recipes table</font><br>
	</h1>
	<center>
		<form action="./insertGlobalRecipe.ds" method="post">
			<table width="280">
				<tr>
					<td style="background-color: buttonface;">Global Recipe ID:</td>
					<td><input type="text" name="glrid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertGlobalRecipe" value="INSERT"
				style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewGlobalRecipesTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppGlobalRecipesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${globalRecipesRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Insert
			into app_global_recipes_trans table</font><br>
	</h1>
	<center>
		<form action="./insertGlobalRecipeTrans.ds" method="post">
			<table width="350">
				<tr>
					<td style="background-color: buttonface;">Translated Global
						Recipe ID:</td>
					<td><input type="text" name="tglrid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Global Recipe ID:</td>
					<td><input type="text" name="glrid2"></td>
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
					<td style="background-color: buttonface;">Global Recipe Name:</td>
					<td><input type="text" name="glrname"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertGlobalRecipesTrans"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action=./viewGlobalTranslatedRecipesTable.ds target="_blank">
			<br> <input type="submit" id="viewAppGlobalRecipesTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>Rows Affected: ${globalTranslatedRecipesRowsAffected}</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Insert
			into app_global_recipes_ingredients table</font><br>
	</h1>
	<center>
		<form action="./insertGlobalRecipeIngredients.ds" method="post">
			<table width="400">
				<tr>
					<td style="background-color: buttonface;">Global Ingredient
						ID:</td>
					<td><input type="text" name="gliid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Translated Global
						Recipe ID:</td>
					<td><input type="text" name="tglrid2"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Translated
						Ingredient ID:</td>
					<td><input type="text" name="tinid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Global Recipe
						Ingredient Quantity:</td>
					<td><input type="text" name="glriquan"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertGlobalRecipesIngredients"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewGlobalRecipeIngredientsTable.ds" target="_blank">
			<br> <input type="submit"
				id="viewAppGlobalRecipesIngredientsTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>Rows Affected: ${globalRecipeIngredientsRowsAffected}</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Insert
			into app_global_recipes_description table</font><br>
	</h1>
	<center>
		<form action="./insertGlobalRecipeDescription.ds" method="post">
			<table width="430">
				<tr>
					<td style="background-color: buttonface;">Global Recipe
						Description ID:</td>
					<td><input type="text" name="glrdid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Translated Global
						Recipe ID:</td>
					<td><input type="text" name="tglrid3"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Global Recipe
						Description:</td>
				</tr>
			</table>
			<table>
				<tr>
					<td><textarea name="glrdesc" rows="10" cols="50"></textarea></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertGlobalRecipesDescription"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewGlobalRecipeDescriptionsTable.ds" target="_blank">
			<br> <input type="submit"
				id="viewAppGlobalRecipesDescriptionTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>Rows Affected: ${globalDescriptionRowsAffected}</h4>
	</center>
	<form id="GoBack" method="post" name="GoBack"
		action="./Choose_Cuisine_Insert.ds">
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