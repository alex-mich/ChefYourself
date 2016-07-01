<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Greek Recipe</title>
<style>
body {
	background:
		url(http://www.hotelcielo.com/wp-content/uploads/2012/04/DSC1916.jpg)
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
		var grrid2 = document.getElementById("grrid2");
		var tcid = document.getElementById("tcid");
		var tmid = document.getElementById("tmid");
		var loc = document.getElementById("loc");
		var grrname = document.getElementById("grrname");
		var valid = true;

		if (tgrrid.value.length <= 0 && grrid2.value.length <= 0
				&& tcid.value.length <= 0 && tmid.value.length <= 0 && loc.value.length <= 0) {
			alert("Translated Greek Recipe ID, Greek Recipe ID, Translated Cuisine ID, Translated Method ID and Locale fields must not be empty!");
			valid = false;
		} else if (tgrrid.value.length <= 0 && grrid2.value.length <= 0
				&& tcid.value.length <= 0 && tmid.value.length <= 0) {
			alert("Translated Greek Recipe ID, Greek Recipe ID, Translated Cuisine ID and Translated Method ID fields must not be empty!");
			valid = false;
		} else if (tgrrid.value.length <= 0 && tcid.value.length <= 0
				&& tmid.value.length <= 0 && loc.value.length <= 0) {
			alert("Translated Greek Recipe ID, Translated Cuisine ID, Translated Method ID and Locale fields must not be empty!");
			valid = false;
		} else if (tgrrid.value.length <= 0 && grrid2.value.length <= 0
				&& tmid.value.length <= 0 && loc.value.length <= 0) {
			alert("Translated Greek Recipe ID, Greek Recipe ID, Translated Method ID and Locale fields must not be empty!");
			valid = false;
		} else if (tgrrid.value.length <= 0 && grrid2.value.length <= 0
				&& tcid.value.length <= 0 && loc.value.length <= 0) {
			alert("Translated Greek Recipe ID, Greek Recipe ID, Translated Cuisine ID and Locale fields must not be empty!");
			valid = false;
		} else if (grrid2.value.length <= 0 && tcid.value.length <= 0
				&& tmid.value.length <= 0 && loc.value.length <= 0) {
			alert("Greek Recipe ID, Translated Cuisine ID, Translated Method ID and Locale fields must not be empty!");
			valid = false;
		} else if (tgrrid.value.length <= 0 && grrid2.value.length <= 0 && tcid.value.length <= 0) {
			alert("Translated Greek Recipe ID, Greek Recipe ID and Translated Cuisine ID fields must not be empty!");
			valid = false;
		} else if (tgrrid.value.length <= 0 && grrid2.value.length <= 0 && tmid.value.length <= 0) {
			alert("Translated Greek Recipe ID, Greek Recipe ID and Translated Method ID fields must not be empty!");
			valid = false;
		} else if (tgrrid.value.length <= 0 && grrid2.value.length <= 0 && loc.value.length <= 0) {
			alert("Translated Greek Recipe ID, Greek Recipe ID and Locale fields must not be empty!");
			valid = false;
		} else if (tgrrid.value.length <= 0 && tcid.value.length <= 0 && tmid.value.length <= 0) {
			alert("Translated Greek Recipe ID, Translated Cuisine ID and Translated Method ID fields must not be empty!");
			valid = false;
		} else if (tgrrid.value.length <= 0 && tcid.value.length <= 0 && loc.value.length <= 0) {
			alert("Translated Greek Recipe ID, Translated Cuisine ID and Locale fields must not be empty!");
			valid = false; 
		} else if (tgrrid.value.length <= 0 && tmid.value.length <= 0 && loc.value.length <= 0) {
			alert("Translated Greek Recipe ID, Translated Method ID and Locale fields must not be empty!");
			valid = false;
		} else if (grrid2.value.length <= 0 && tcid.value.length <= 0 && tmid.value.length <= 0) {
			alert("Greek Recipe ID, Translated Cuisine ID and Translated Method ID fields must not be empty!");
			valid = false;
		} else if (grrid2.value.length <= 0 && tcid.value.length <= 0 && loc.value.length <= 0) {
			alert("Greek Recipe ID, Translated Cuisine ID and Locale fields must not be empty!");
			valid = false;
		} else if (grrid2.value.length <= 0 && tmid.value.length <= 0 && loc.value.length <= 0) {
			alert("Greek Recipe ID, Translated Method ID and Locale fields must not be empty!");
			valid = false;
		} else if (tcid.value.length <= 0 && tmid.value.length <= 0 && loc.value.length <= 0) {
			alert("Translated Cuisine ID, Translated Method ID and Locale fields must not be empty!");
			valid = false;
		} else if (tgrrid.value.length <= 0 && grrid2.value.length <= 0) {
			alert("Translated Greek Recipe ID and Greek Recipe ID fields must not be empty!");
			valid = false;
		} else if (tgrrid.value.length <= 0 && tcid.value.length <= 0) {
			alert("Translated Greek Recipe ID and Translated Cuisine ID fields must not be empty!");
			valid = false;
		} else if (tgrrid.value.length <= 0 && tmid.value.length <= 0) {
			alert("Translated Greek Recipe ID and Translated Method ID fields must not be empty!");
			valid = false;
		} else if (tgrrid.value.length <= 0 && loc.value.length <= 0) {
			alert("Translated Greek Recipe ID and Locale fields must not be empty!");
			valid = false;
		} else if (grrid2.value.length <= 0 && tcid.value.length <= 0) {
			alert("Greek Recipe ID and Translated Cuisine ID fields must not be empty!");
			valid = false;
		} else if (grrid2.value.length <= 0 && tmid.value.length <= 0) {
			alert("Greek Recipe ID and Translated Method ID fields must not be empty!");
			valid = false;
		} else if (grrid2.value.length <= 0 && loc.value.length <= 0) {
			alert("Greek Recipe ID and Locale fields must not be empty!");
			valid = false;
		} else if (tcid.value.length <= 0 && tmid.value.length <= 0) {
			alert("Translated Cuisine ID and Translated Method ID fields must not be empty!");
			valid = false;
		} else if (tcid.value.length <= 0 && loc.value.length <= 0) {
			alert("Translated Cuisine ID and Locale fields must not be empty!");
			valid = false;
		} else if (tmid.value.length <= 0 && loc.value.length <= 0) {
			alert("Translated Method ID and Locale fields must not be empty!");
			valid = false;
		} else if (tgrrid.value.length <= 0) {
			alert("Translated Greek Recipe ID field must not be empty!");
			valid = false;
		} else if (grrid2.value.length <= 0) {
			alert("Greek Recipe ID field must not be empty!");
			valid = false;
		} else if (tcid.value.length <= 0) {
			alert("Translated Cuisine ID field must not be empty!");
			valid = false;
		} else if (tmid.value.length <= 0) {
			alert("Translated Method ID field must not be empty!");
			valid = false;
		} else if (loc.value.length <= 0) {
			alert("Locale field must not be empty!");
			valid = false;
		} else if (isNaN(tgrrid.value) && isNaN(grrid2.value)
				&& isNaN(tcid.value) && isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Greek Recipe ID, Greek Recipe ID, Translated Cuisine ID and Translated Method ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (isNaN(tgrrid.value) && isNaN(grrid2.value)
				&& isNaN(tcid.value) && isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Translated Greek Recipe ID, Greek Recipe ID, Translated Cuisine ID and Translated Method ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(tgrrid.value) && isNaN(grrid2.value)
				&& isNaN(tcid.value) && !isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Greek Recipe ID, Greek Recipe ID and Translated Cuisine ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (isNaN(tgrrid.value) && isNaN(grrid2.value)
				&& isNaN(tcid.value) && !isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Translated Greek Recipe ID, Greek Recipe ID and Translated Cuisine ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(tgrrid.value) && isNaN(grrid2.value)
				&& !isNaN(tcid.value) && isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Greek Recipe ID, Greek Recipe ID and Translated Method ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (isNaN(tgrrid.value) && isNaN(grrid2.value)
				&& !isNaN(tcid.value) && isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Translated Greek Recipe ID, Greek Recipe ID and Translated Method ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(tgrrid.value) && isNaN(grrid2.value)
				&& !isNaN(tcid.value) && !isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Greek Recipe ID and Greek Recipe ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (isNaN(tgrrid.value) && isNaN(grrid2.value) 
				&& !isNaN(tcid.value) && !isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Translated Greek Recipe ID and Greek Recipe ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(tgrrid.value) && !isNaN(grrid2.value)
				&& isNaN(tcid.value) && isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Greek Recipe ID, Translated Cuisine ID and Translated Method ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (isNaN(tgrrid.value) && !isNaN(grrid2.value)
				&& isNaN(tcid.value) && isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Translated Greek Recipe ID, Translated Cuisine ID and Translated Method ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(tgrrid.value) && !isNaN(grrid2.value)
				&& isNaN(tcid.value) && !isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Greek Recipe ID and Translated Cuisine ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (isNaN(tgrrid.value) && !isNaN(grrid2.value)
				&& isNaN(tcid.value) && !isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Translated Greek Recipe ID and Translated Cuisine ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(tgrrid.value) && !isNaN(grrid2.value)
				&& !isNaN(tcid.value) && isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Greek Recipe ID and Translated Method ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (isNaN(tgrrid.value) && !isNaN(grrid2.value)
				&& !isNaN(tcid.value) && isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Translated Greek Recipe ID and Translated Method ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(tgrrid.value) && !isNaN(grrid2.value)
				&& !isNaN(tcid.value) && !isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Greek Recipe ID field must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (isNaN(tgrrid.value) && !isNaN(grrid2.value)
				&& !isNaN(tcid.value) && !isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Translated Greek Recipe ID field must be filled with numbers!");
			valid = false;
		} else if (!isNaN(tgrrid.value) && isNaN(grrid2.value)
				&& isNaN(tcid.value) && isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Greek Recipe ID, Translated Cuisine ID and Translated Method ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (!isNaN(tgrrid.value) && isNaN(grrid2.value)
				&& isNaN(tcid.value) && isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Greek Recipe ID, Translated Cuisine ID and Translated Method ID fields must be filled with numbers!");
			valid = false;
		} else if (!isNaN(tgrrid.value) && isNaN(grrid2.value)
				&& isNaN(tcid.value) && !isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Greek Recipe ID and Translated Cuisine ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (!isNaN(tgrrid.value) && isNaN(grrid2.value)
				&& isNaN(tcid.value) && !isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Greek Recipe ID and Translated Cuisine ID fields must be filled with numbers!");
			valid = false;
		} else if (!isNaN(tgrrid.value) && isNaN(grrid2.value)
				&& !isNaN(tcid.value) && isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Greek Recipe ID and Translated Method ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (!isNaN(tgrrid.value) && isNaN(grrid2.value)
				&& !isNaN(tcid.value) && isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Greek Recipe ID and Translated Method ID fields must be filled with numbers!");
			valid = false;
		} else if (!isNaN(tgrrid.value) && isNaN(grrid2.value)
				&& !isNaN(tcid.value) && !isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Greek Recipe ID field must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (!isNaN(tgrrid.value) && isNaN(grrid2.value)
				&& !isNaN(tcid.value) && !isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Greek Recipe ID field must be filled with numbers!");
			valid = false;
		} else if (!isNaN(tgrrid.value) && !isNaN(grrid2.value)
				&& isNaN(tcid.value) && isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Cuisine ID and Translated Method ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (!isNaN(tgrrid.value) && !isNaN(grrid2.value)
				&& isNaN(tcid.value) && isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Translated Cuisine ID and Translated Method ID fields must be filled with numbers!");
			valid = false;
		} else if (!isNaN(tgrrid.value) && !isNaN(grrid2.value)
				&& isNaN(tcid.value) && !isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Cuisine ID field must be filled with numbers and Locale field must be filled with valid valid letters!");
			valid = false;
		} else if (!isNaN(tgrrid.value) && !isNaN(grrid2.value)
				&& isNaN(tcid.value) && !isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Translated Cuisine ID field must be filled with numbers!");
			valid = false;
		} else if (!isNaN(tgrrid.value) && !isNaN(grrid2.value)
				&& !isNaN(tcid.value) && isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Method ID field must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (!isNaN(tgrrid.value) && !isNaN(grrid2.value)
				&& !isNaN(tcid.value) && isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Translated Method ID field must be filled with numbers!");
			valid = false;
		} else if (!isNaN(tgrrid.value) && !isNaN(grrid2.value)
				&& !isNaN(tcid.value) && !isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Locale field must be filled with valid letters!");
			valid = false;
		} else if (tgrrid.value.length > 0 && grrid2.value.length > 0
				&& tcid.value.length > 0 && tmid.value.length > 0
				&& loc.value.length > 0 && (isNaN(grrname.value) || grrname.value.length <= 0)) {
			valid = true;
		} else if (!isNaN(grrname.value)){
			alert("Greek Recipe Name field must be filled with letters!");
			valid = false;
		} 
		return valid;
	};

	function validate3() {

		var griid = document.getElementById("griid");
		var tgrrid2 = document.getElementById("tgrrid2");
		var tinid = document.getElementById("tinid");
		var valid = true;

		if (griid.value.length <= 0 && tgrrid2.value.length <= 0 && tinid.value.length <= 0) {
			alert("Greek Ingredient ID, Translated Greek Recipe ID and Translated Ingredient ID fields must not be empty!");
			valid = false;
		} else if (griid.value.length <= 0 && tgrrid2.value.length <= 0 && tinid.value.length > 0){
			alert("Greek Ingredient ID and Translated Greek Recipe ID fields must not be empty!");
			valid = false;			
		} else if (griid.value.length <= 0 && tgrrid2.value.length > 0 && tinid.value.length <= 0){
			alert("Greek Ingredient ID and Translated Ingredient ID fields must not be empty!");
			valid = false;
		} else if (griid.value.length <= 0 && tgrrid2.value.length > 0 && tinid.value.length > 0){
			alert("Greek Ingredient ID field must not be empty!");
			valid = false;
		} else if (griid.value.length > 0 && tgrrid2.value.length <= 0 && tinid.value.length <= 0){
			alert("Translated Greek Recipe ID and Translated Ingredient ID fields must not be empty!");
			valid = false;
		} else if (griid.value.length > 0 && tgrrid2.value.length <= 0 && tinid.value.length > 0){
			alert("Translated Greek Recipe ID field must not be empty!");
			valid = false;
		} else if (griid.value.length > 0 && tgrrid2.value.length > 0 && tinid.value.length <= 0){
			alert("Translated Ingredient ID field must not be empty!");
			valid = false;
		} else if (isNaN(griid.value) && isNaN(tgrrid2.value) && isNaN(tinid.value)){
			alert("Greek Ingredient ID, Translated Greek Recipe ID and Translated Ingredient ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(griid.value) && isNaN(tgrrid2.value) && !isNaN(tinid.value)){
			alert("Greek Ingredient ID and Translated Greek Recipe ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(griid.value) && !isNaN(tgrrid2.value) && isNaN(tinid.value)){
			alert("Greek Ingredient ID and Translated Ingredient ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(griid.value) && !isNaN(tgrrid2.value) && !isNaN(tinid.value)){
			alert("Greek Ingredient ID field must be filled with numbers!");
			valid = false;
		} else if (!isNaN(griid.value) && isNaN(tgrrid2.value) && isNaN(tinid.value)){
			alert("Translated Greek Recipe ID and Translated Ingredient ID fields must be filled with numbers!");
			valid = false;
		} else if (!isNaN(griid.value) && isNaN(tgrrid2.value) && !isNaN(tinid.value)){
			alert("Translated Greek Recipe ID field must be filled with numbers!");
			valid = false;
		} else if (!isNaN(griid.value) && !isNaN(tgrrid2.value) && isNaN(tinid.value)){
			alert("Translated Ingredient ID field must be filled with numbers!");
			valid = false;
		} 
		return valid;
	};

	function validate4() {

		var grrdid = document.getElementById("grrdid");
		var tgrrid3 = document.getElementById("tgrrid3");
		var valid = true;
		
		if (grrdid.value.length <= 0 && tgrrid3.value.length <= 0) {
			alert("Greek Recipe Description ID and Translated Greek Recipe ID fields must not be empty!");
			valid = false;
		} else if (grrdid.value.length <= 0 && tgrrid3.value.length > 0) {
			alert("Greek Recipe Description ID field must not be empty!");
			valid = false;
		} else if (grrdid.value.length > 0 && tgrrid3.value.length <= 0) {
			alert("Translated Greek Recipe ID field must not be empty!");
			valid = false;
		} else if (isNaN(grrdid.value) && isNaN(tgrrid3.value)){
			alert("Greek Recipe Description ID and Translated Greek Recipe ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(grrdid.value) && !isNaN(tgrrid3.value)){
			alert("Greek Recipe Description ID field must be filled with numbers!");
			valid = false;
		} else if (!isNaN(grrdid.value) && isNaN(tgrrid3.value)){
			alert("Translated Greek Recipe ID field must be filled with numbers!");
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
			into app_greek recipes table</font><br>
	</h1>
	<center>
		<form action="./insertGreekRecipe.ds" method="post"
			onsubmit="return validate();">
			<table width="280">
				<tr>
					<td style="background-color: buttonface;">Greek Recipe ID:</td>
					<td><input type="text" name="grrid1" id="grrid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertGreekRecipe" value="INSERT"
				style="height: 25px; width: 80px; font-size: 15px;" />
		</form>
		<form action="./viewGreekRecipesTable.ds" target="_blank">
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
		<form action="./insertGreekRecipeTrans.ds" method="post"
			onsubmit="return validate2();">
			<table width="350">
				<tr>
					<td style="background-color: buttonface;">Translated Greek
						Recipe ID:</td>
					<td><input type="text" name="tgrrid" id="tgrrid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Greek Recipe ID:</td>
					<td><input type="text" name="grrid2" id="grrid2"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Translated Cuisine
						ID:</td>
					<td><input type="text" name="tcid" id="tcid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Translated Method
						ID:</td>
					<td><input type="text" name="tmid" id="tmid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Locale:</td>
					<td><input type="text" name="loc" id="loc"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Greek Recipe Name:</td>
					<td><input type="text" name="grrname" id="grrname"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertGreekRecipesTrans"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewGreekTranslatedRecipesTable.ds" target="_blank">
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
		<form action="./insertGreekRecipeIngredients.ds" method="post"
			onsubmit="return validate()3;">
			<table width="400">
				<tr>
					<td style="background-color: buttonface;">Greek Ingredient ID:</td>
					<td><input type="text" name="griid" id="griid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Translated Greek
						Recipe ID:</td>
					<td><input type="text" name="tgrrid2" id="tgrrid2"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Translated
						Ingredient ID:</td>
					<td><input type="text" name="tinid" id="tinid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Greek Recipe
						Ingredient Quantity:</td>
					<td><input type="text" name="grriquan" id="grriquan"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertGreekRecipesIngredients"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewGreekRecipeIngredientsTable.ds" target="_blank">
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
		<form action="./insertGreekRecipeDescription.ds" method="post"
			onsubmit="return validate4();">
			<table width="430">
				<tr>
					<td style="background-color: buttonface;">Greek Recipe
						Description ID:</td>
					<td><input type="text" name="grrdid" id="grrdid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Translated Greek
						Recipe ID:</td>
					<td><input type="text" name="tgrrid3" id="tgrrid3"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Greek Recipe
						Description:</td>
				</tr>
			</table>
			<table>
				<tr>
					<td><textarea name="grrdesc" rows="10" cols="50" id="grrdesc"></textarea></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertGreekRecipesDescription"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewGreekRecipeDescriptionsTable.ds" target="_blank">
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