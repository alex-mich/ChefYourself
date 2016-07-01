<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Ingredient</title>
<style>
body {
	background:
		url(http://sladephoto.com/wp-content/uploads/2013/02/Food-Meatloaf-Ingredients-Slade-Photo1.jpg)
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

		var curinid1 = document.getElementById("curinid1");
		var newinid1 = document.getElementById("newinid1");
		var curitype = document.getElementById("curitype");
		var newitype = document.getElementById("newitype");
		var valid = true;

		if (curinid1.value.length <= 0 && curitype.value.length <= 0
				&& newinid1.value.length <= 0 && newitype.value.length <= 0) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if ((curinid1.value.length > 0 || curitype.value.length > 0)
				&& (newinid1.value.length <= 0 && newitype.value.length <= 0)) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if ((curinid1.value.length <= 0 && curitype.value.length <= 0)
				&& (newinid1.value.length > 0 || newitype.value.length > 0)) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if (curinid1.value.length > 0 && isNaN(curinid1.value)) {
			alert("Current Translated Method ID must be filled with valid number, please check the table!");
			valid = false;
		} else if (curitype.value.length > 0 && !isNaN(curitype.value)) {
			alert("Current Ingredient ID field must be filled with valid number, please check the table!");
			valid = false;
		} else if (newinid1.value.length > 0 && isNaN(newinid1.value)) {
			alert("Current Locale field must be filled with valid letters, please check the table");
			valid = false;
		} else if (newitype.value.length > 0 && !isNaN(newitype.value)) {
			alert("Current Ingredient Name must be filled with valid letters, please check the table!");
			valid = false;
		} 
		return valid;
	};

	function validate2() {

		var curtinid = document.getElementById("curtinid");
		var newtinid = document.getElementById("newtinid");
		var curinid2 = document.getElementById("curinid2");
		var newinid2 = document.getElementById("newinid2");
		var curloc = document.getElementById("curloc");
		var newloc = document.getElementById("newloc");
		var curiname = document.getElementById("curiname");
		var newiname = document.getElementById("newiname");
		var valid = true;

		if (curtinid.value.length <= 0 && curinid2.value.length <= 0 && curloc.value.length <= 0 
				&& curiname.value.length <= 0 && newtinid.value.length <= 0 && newinid2.value.length <= 0 
				&& newloc.value.length <= 0 && newiname.value.length <= 0) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if ((curtinid.value.length > 0 || curinid2.value.length > 0 || curloc.value.length > 0 
				|| curiname.value.length > 0)
				&& (newtinid.value.length <= 0 && newinid2.value.length <= 0 && newloc.value.length <= 0 
				&& newiname.value.length <= 0)) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if ((curtinid.value.length <= 0 && curinid2.value.length <= 0 && curloc.value.length <= 0 
				&& curiname.value.length <= 0) 
				&& (newtinid.value.length > 0 || newinid2.value.length > 0 || newloc.value.length > 0 
				|| newiname.value.length > 0)) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if (curtinid.value.length > 0 && isNaN(curtinid.value)){
			alert("Current Translated Ingredient ID must be filled with valid number, please check the table!");
			valid = false;
		} else if (curinid2.value.length > 0 && isNaN(curinid2.value)){
			alert("Current Ingredient ID field must be filled with valid number, please check the table!");
			valid = false;
		} else if (curloc.value.length > 0 && !isNaN(curloc.value)){
			alert("Current Locale field must be filled with valid letters, please check the table");
			valid = false;
		} else if (curiname.value.length > 0 && !isNaN(curiname.value)){
			alert("Current Ingredient Name must be filled with valid letters, please check the table!");
			valid = false;
		} else if (newtinid.value.length > 0 && isNaN(newtinid.value)){
			alert("New Translated Ingredient ID field must be filled with number!");
			valid = false;
		} else if (newinid2.value.length > 0 && isNaN(newinid2.value)){
			alert("New Ingredient ID field must be filled with number!");
			valid = false;
		} else if (newloc.value.length > 0 && !isNaN(newloc.value)){
			alert("New Locale field must be filled with letters!");
			valid = false;
		} else if (newiname.value.length > 0 && !isNaN(newiname.value)){
			alert("New Ingredient Name field must be filled with letters!");
			valid = false;
		} 
		return valid;
	};
</script>
</head>
<body>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_ingredients table</font><br>
	</h1>
	<center>
		<form action="./updateIngredient.ds" method="post"
			onsubmit="return validate();">
			<table width="650">
				<tr>
					<td style="background-color: buttonface;">Current Ingredient
						ID:</td>
					<td><input type="text" name="curinid1" id="curinid1"></td>
					<td style="background-color: buttonface;">New Ingredient ID:</td>
					<td><input type="text" name="newinid1" id="newinid1"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Ingredient
						Type:</td>
					<td><input type="text" name="curitype" id="curitype"></td>
					<td style="background-color: buttonface;">New Ingredient Type:</td>
					<td><input type="text" name="newitype" id="newitype"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateAppIngredients"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewIngredientsTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppIngredientsTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;"><br>
		</form>
		<h4>
			<font color="white">Rows Affected:
				${updatedIngredientRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_ingredients_trans table</font><br>
	</h1>
	<center>
		<form action="./updateTranslatedIngredient.ds" method="post"
			onsubmit="return validate2();">
			<table width="750">
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Ingredient ID:</td>
					<td><input type="text" name="curtinid" id="curtinid"></td>
					<td style="background-color: buttonface;">New Translated
						Ingredient ID:</td>
					<td><input type="text" name="newtinid" id="newtinid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Ingredient
						ID:</td>
					<td><input type="text" name="curinid2" id="curinid2"></td>
					<td style="background-color: buttonface;">New Ingredient ID:</td>
					<td><input type="text" name="newinid2" id="newinid2"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Locale:</td>
					<td><input type="text" name="curloc" id="curloc"></td>
					<td style="background-color: buttonface;">New Locale:</td>
					<td><input type="text" name="newloc" id="newloc"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Ingredient
						Name:</td>
					<td><input type="text" name="curiname" id="curiname"></td>
					<td style="background-color: buttonface;">New Ingredient Name:</td>
					<td><input type="text" name="newiname" id="newiname"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateAppIngredientsTrans"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewTranslatedIngredientsTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppIngredientsTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${updatedTranslatedIngredientRowsAffected}</font>
		</h4>
	</center>
	<form id="GoBack" method="post" name="GoBack"
		action="./Update_Operations.ds">
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