<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Ingredient</title>
<style>
body {
	background:
		url(http://media.al-sharq.com/PortalImages/News/Small/174263_0.jpg)
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

		var inid1 = document.getElementById("inid1");
		var itype = document.getElementById("itype");
		var valid = true;

		if (inid1.value.length <= 0) {
			alert("Ingredient ID field cannot be empty!");
			valid = false;
		} else if (isNaN(inid1.value)) {
			alert("Ingredient ID field must be filled with numbers!");
			valid = false;
		} else if (inid1.value.length > 0
				&& (isNaN(itype.value) || itype.value.length <= 0)) {
			valid = true;
			alert("Insertion Completed!");
		} else if (inid1.value.length > 0 && !isNaN(itype.value)) {
			alert("Ingredient Type field must be filled with letters!");
			valid = false;
		}
		return valid;
	};

	function validate2() {

		var tinid = document.getElementById("tinid");
		var inid2 = document.getElementById("inid2");
		var loc = document.getElementById("loc");
		var iname = document.getElementById("iname");
		var valid = true;

		if (tinid.value.length <= 0 && inid2.value.length <= 0
				&& loc.value.length <= 0) {
			alert("Translated Ingredient ID, Ingredient ID and Locale fields must not be empty!");
			valid = false;
		} else if (tinid.value.length <= 0 && inid2.value.length <= 0) {
			alert("Translated Ingredient ID and Ingredient ID fields must not be empty!");
			valid = false;
		} else if (inid2.value.length <= 0 && loc.value.length <= 0) {
			alert("Ingredient ID and Locale fields must not be empty!");
			valid = false;
		} else if (tinid.value.length <= 0 && loc.value.length <= 0) {
			alert("Translated Ingredient ID and Locale fields must not be empty!");
			valid = false;
		} else if (tinid.value.length <= 0) {
			alert("Translated Ingredient ID field must not be empty!");
			valid = false;
		} else if (inid2.value.length <= 0) {
			alert("Ingredient ID field must not be empty!");
			valid = false;
		} else if (loc.value.length <= 0) {
			alert("Locale field must not be empty!");
			valid = false;
		} else if (isNaN(tinid.value) && isNaN(inid2.value)
				&& !isNaN(loc.value)) {
			alert("Translated Ingredient ID and Ingredient ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (!isNaN(tinid.value) && isNaN(inid2.value)
				&& !isNaN(loc.value)) {
			alert("Ingredient ID field must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (!isNaN(tinid.value) && !isNaN(inid2.value)
				&& !isNaN(loc.value)) {
			alert("Locale field must be filled with valid letters!");
			valid = false;
		} else if (!isNaN(tinid.value) && isNaN(inid2.value)
				&& isNaN(loc.value)) {
			alert("Ingredient ID field must be filled with numbers!");
			valid = false;
		} else if (isNaN(tinid.value) && !isNaN(inid2.value)
				&& isNaN(loc.value)) {
			alert("Translated Ingredient ID field must be filled with numbers!");
			valid = false;
		} else if (isNaN(tinid.value) && isNaN(inid2.value) && isNaN(loc.value)) {
			alert("Translated Ingredient ID and Ingredient ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(tinid.value) && !isNaN(inid2.value)
				&& !isNaN(loc.value)) {
			alert("Translated Ingredient ID field must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (tinid.value.length > 0 && inid2.value.length > 0
				&& loc.value.length > 0
				&& (isNaN(iname.value) || iname.value.length <= 0)) {
			valid = true;
			alert("Insertion Completed!");
		} else if (!isNaN(iname.value)) {
			alert("Ingredient Name field must be filled with letters!");
			valid = false;
		}
		return valid;
	};
</script>
</head>
<body>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Insert
			into app_ingredients table</font><br>
	</h1>
	<center>
		<form action="./insertIngredient.ds" method="post"
			onsubmit="return validate();">
			<table width="280">
				<tr>
					<td style="background-color: buttonface;">Ingredient ID:</td>
					<td><input type="text" name="inid1" id="inid1"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Ingredient Type:</td>
					<td><input type="text" name="itype" id="itype"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertAppIngredients"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewIngredientsTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppIngredientsTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;"><br>
		</form>
		<h4>
			<font color="white">Rows Affected: ${ingredientRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Insert
			into app_ingredients_trans table</font><br>
	</h1>
	<center>
		<form action="./insertTranslatedIngredient.ds" method="post"
			onsubmit="return validate2();">
			<table width="320">
				<tr>
					<td style="background-color: buttonface;">Translated
						Ingredient ID:</td>
					<td><input type="text" name="tinid" id="tinid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Ingredient ID:</td>
					<td><input type="text" name="inid2" id="inid2"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Locale:</td>
					<td><input type="text" name="loc" id="loc"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Ingredient Name:</td>
					<td><input type="text" name="iname" id="iname"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertAppIngredientsTrans"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewTranslatedIngredientsTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppIngredientsTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${translatedIngredientRowsAffected}</font>
		</h4>
	</center>
	<form id="GoBack" method="post" name="GoBack"
		action="./Insert_Operations.ds">
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