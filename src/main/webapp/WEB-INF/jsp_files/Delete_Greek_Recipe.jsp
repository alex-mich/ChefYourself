<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Greek Recipe</title>
<style>
body {
	background:
		url(http://foodwineclick.files.wordpress.com/2012/05/02-black-bean-cucumber-tomato-salsa-ingredients-01_640.jpg)
		no-repeat;
	background-size: cover;
}
</style>
<script>
	function goBack() {
		document.forms["GoBack"].submit();
	}

	function goHome() {
		document.forms["GoHome"].submit();
	}

	function validate() {

		var grrid1 = document.getElementById("grrid1");
		var valid = true;

		if (grrid1.value.length <= 0) {
			alert("Greek Recipe ID field cannot be empty!");
			valid = false;
		} else if (isNaN(grrid1.value)) {
			alert("Greek Recipe ID field must be filled with numbers!");
			valid = false;
		}
		return valid;
	};

	function validate2() {

		var tgrrid = document.getElementById("tgrrid");
		var valid = true;

		if (tgrrid.value.length <= 0) {
			alert("Translated Greek Recipe ID field cannot be empty!");
			valid = false;
		} else if (isNaN(tgrrid.value)) {
			alert("Translated Greek Recipe ID field must be filled with numbers!");
			valid = false;
		}
		return valid;
	};

	function validate3() {

		var griid = document.getElementById("griid");
		var valid = true;

		if (griid.value.length <= 0) {
			alert("Greek Ingredient ID field cannot be empty!");
			valid = false;
		} else if (isNaN(griid.value)) {
			alert("Greek Ingredient ID field must be filled with numbers!");
			valid = false;
		}
		return valid;
	};

	function validate4() {

		var grrdid = document.getElementById("grrdid");
		var valid = true;

		if (grrdid.value.length <= 0) {
			alert("Greek Recipe Description ID field cannot be empty!");
			valid = false;
		} else if (isNaN(grrdid.value)) {
			alert("Greek Recipe Description ID fixeld must be filled with numbers!");
			valid = false;
		}
		return valid;
	};
</script>
</head>
<body>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_greek recipes table</font><br>
	</h1>
	<center>
		<form action="./deleteGreekRecipe.ds" method="post"
			onsubmit="return validate();">
			<table width="300">
				<tr>
					<td style="background-color: buttonface;">Greek Recipe ID:</td>
					<td><input type="text" name="grrid1" id="grrid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="deleteGreekRecipe" value="DELETE"
				style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewGreekRecipesTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppGreekRecipesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${deletedGreekRecipesRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_greek_recipes_trans table</font><br>
	</h1>
	<center>
		<form action="./deleteGreekRecipeTrans.ds" method="post"
			onsubmit="return validate2();">
			<table width="350">
				<tr>
					<td style="background-color: buttonface;">Translated Greek
						Recipe ID:</td>
					<td><input type="text" name="tgrrid" id="tgrrid"></td>
				</tr>
			</table>
			<br> <input type="submit" id="deleteGreekRecipesTrans"
				value="DELETE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewGreekTranslatedRecipesTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppGreekRecipesTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${deletedGreekTranslatedRecipesRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_greek_recipes_ingredients table</font><br>
	</h1>
	<center>
		<form action="./deleteGreekRecipeIngredient.ds" method="post"
			onsubmit="return validate3();">
			<table width="300">
				<tr>
					<td style="background-color: buttonface;">Greek Ingredient ID:</td>
					<td><input type="text" name="griid" id="griid"></td>
				</tr>
			</table>
			<br> <input type="submit" id="deleteGreekRecipesIngredient"
				value="DELETE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewGreekRecipeIngredientsTable.ds" target="_blank">
			<br> <input type="submit"
				id="viewAppGreekRecipesIngredientsTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${deletedGreekRecipeIngredientsRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_greek_recipes_description table</font><br>
	</h1>
	<center>
		<form action="./deleteGreekRecipeDescription.ds" method="post"
			onsubmit="return validate4();">
			<table width="350">
				<tr>
					<td style="background-color: buttonface;">Greek Recipe
						Description ID:</td>
					<td><input type="text" name="grrdid" id="grrdid"></td>
				</tr>
			</table>
			<br> <input type="submit" id="deleteGreekRecipesDescription"
				value="DELETE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewGreekRecipeDescriptionsTable.ds" target="_blank">
			<br> <input type="submit"
				id="viewAppGreekRecipesDescriptionTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${deletedGreekRecipeDescriptionRowsAffected}</font>
		</h4>
	</center>
	<form id="GoBack" method="post" name="GoBack"
		action="./Choose_Cuisine_Delete.ds">
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