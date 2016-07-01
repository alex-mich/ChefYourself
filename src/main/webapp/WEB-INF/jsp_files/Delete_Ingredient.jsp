<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Ingredient</title>
<style>
body {
	background:
		url(http://olivethis.com/wp-content/uploads/2012/10/Measured-Ingredients.jpg)
		no-repeat;
	background-size: 100%;
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

		var inid = document.getElementById("inid");
		var valid = true;

		if (inid.value.length <= 0) {
			alert("Ingredient ID field cannot be empty!");
			valid = false;
		} else if (isNaN(inid.value)) {
			alert("Ingredient ID field must be filled with numbers!");
			valid = false;
		}
		return valid;
	};

	function validate2() {

		var tinid = document.getElementById("tinid");
		var valid = true;

		if (tinid.value.length <= 0) {
			alert("Translated Ingredient ID field cannot be empty!");
			valid = false;
		} else if (isNaN(tinid.value)) {
			alert("Translated Ingredient ID field must be filled with numbers!");
			valid = false;
		}
		return valid;
	};
</script>
</head>
<body>
	<br>
	<br>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_ingredients table</font><br>
	</h1>
	<center>
		<form action="./deleteIngredient.ds" method="post"
			onsubmit="return validate();">
			<table width="250">
				<tr>
					<td style="background-color: buttonface;">Ingredient ID:</td>
					<td><input type="text" name="inid" id="inid"></td>
				</tr>
			</table>
			<br> <input type="submit" id="deleteAppIngredient"
				value="DELETE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewIngredientsTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppIngredientsTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;"><br>
		</form>
		<h4>Rows Affected: ${deletedIngredientRowsAffected}</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_ingredients_trans table</font><br>
	</h1>
	<center>
		<form action="./deleteTranslatedIngredient.ds" method="post"
			onsubmit="return validate2();">
			<table width="320">
				<tr>
					<td style="background-color: buttonface;">Translated
						Ingredient ID:</td>
					<td><input type="text" name="tinid" id="tinid"></td>
				</tr>
			</table>
			<br> <input type="submit" id="deleteAppIngredientsTrans"
				value="DELETE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewTranslatedIngredientsTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppIngredientsTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>Rows Affected: ${deletedTranslatedIngredientRowsAffected}</h4>
	</center>
	<form id="GoBack" method="post" name="GoBack"
		action="./Delete_Operations.ds">
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
</body>
</html>