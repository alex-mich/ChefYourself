<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Greek Recipe</title>
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
		url(http://www.hotelcielo.com/wp-content/uploads/2012/04/DSC1916.jpg)
		no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Insert
			into app_greek recipes table</font><br>
	</h1>
	<center>
		<form action="./insertGreekRecipe.ds" method="post">
			<table width="280">
				<tr>
					<td style="background-color: buttonface;">Greek Recipe ID:</td>
					<td><input type="text" name="grrid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertGreekRecipe" value="INSERT"
				style="height: 25px; width: 80px; font-size: 15px;" />
		</form>
		<form action="./viewAppGreekRecipesTable.ds">
			<br> <input type="submit" id="viewAppGreekRecipesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;" />
		</form>
		<h4>
			<font color="white">Rows Affected: ${greekRecipesRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Insert
			into app_greek_recipes_trans table</font><br>
	</h1>
	<center>
		<form action="./insertGreekRecipeTrans.ds" method="post">
			<table width="350">
				<tr>
					<td style="background-color: buttonface;">Translated Greek
						Recipe ID:</td>
					<td><input type="text" name="tgrrid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Greek Recipe ID:</td>
					<td><input type="text" name="grrid2"></td>
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
					<td><input type="text" name="loc" maxlength="5"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Greek Recipe Name:</td>
					<td><input type="text" name="grrname" maxlength="40"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertGreekRecipesTrans"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppGreekRecipesTransTable.ds">
			<br> <input type="submit" id="viewAppGreekRecipesTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${greekTranslatedRecipesRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Insert
			into app_greek_recipes_ingredients table</font><br>
	</h1>
	<center>
		<form action="./insertGreekRecipeIngredients.ds" method="post">
			<table width="400">
				<tr>
					<td style="background-color: buttonface;">Greek Ingredient ID:</td>
					<td><input type="text" name="griid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Translated Greek
						Recipe ID:</td>
					<td><input type="text" name="tgrrid2"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Translated
						Ingredient ID:</td>
					<td><input type="text" name="tinid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Greek Recipe
						Ingredient Quantity:</td>
					<td><input type="text" name="grriquan"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertGreekRecipesIngredients"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppGreekRecipesIngredients.ds">
			<br> <input type="submit"
				id="viewAppGreekRecipesIngredientsTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${greekRecipeIngredientsRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Insert
			into app_greek_recipes_description table</font><br>
	</h1>
	<center>
		<form action="./insertGreekRecipeDescription.ds" method="post">
			<table width="430">
				<tr>
					<td style="background-color: buttonface;">Greek Recipe
						Description ID:</td>
					<td><input type="text" name="grrdid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Translated Greek
						Recipe ID:</td>
					<td><input type="text" name="tgrrid3"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Greek Recipe
						Description:</td>
				</tr>
			</table>
			<table>
				<tr>
					<td><textarea name="grrdesc" rows="10" cols="50"></textarea></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertGreekRecipesDescription"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppGreekRecipesDescriptions.ds">
			<br> <input type="submit"
				id="viewAppGreekRecipesDescriptionTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${greekDescriptionRowsAffected}</font>
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