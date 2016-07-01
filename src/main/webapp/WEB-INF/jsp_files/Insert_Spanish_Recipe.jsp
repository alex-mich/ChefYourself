<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Spanish Recipe</title>
<style>
body {
	background:
		url(http://foodandphotography.blog.com/files/2012/05/salsa-for-blog-1024x1024.jpg)
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

		var sprid1 = document.getElementById("sprid1");
		var valid = true;

		if (sprid1.value.length <= 0) {
			alert("Spanish Recipe ID field cannot be empty!");
			valid = false;
		} else if (isNaN(sprid1.value)) {
			alert("Spanish Recipe ID field must be filled with numbers!");
			valid = false;
		} 
		return valid;
	};

	function validate2() {

		var tsprid = document.getElementById("tsprid");
		var sprid2 = document.getElementById("sprid2");
		var tcid = document.getElementById("tcid");
		var tmid = document.getElementById("tmid");
		var loc = document.getElementById("loc");
		var sprname = document.getElementById("sprname");
		var valid = true;

		if (tsprid.value.length <= 0 && sprid2.value.length <= 0
				&& tcid.value.length <= 0 && tmid.value.length <= 0 && loc.value.length <= 0) {
			alert("Translated Spanish Recipe ID, Spanish Recipe ID, Translated Cuisine ID, Translated Method ID and Locale fields must not be empty!");
			valid = false;
		} else if (tsprid.value.length <= 0 && sprid2.value.length <= 0
				&& tcid.value.length <= 0 && tmid.value.length <= 0) {
			alert("Translated Spanish Recipe ID, Spanish Recipe ID, Translated Cuisine ID and Translated Method ID fields must not be empty!");
			valid = false;
		} else if (tsprid.value.length <= 0 && tcid.value.length <= 0
				&& tmid.value.length <= 0 && loc.value.length <= 0) {
			alert("Translated Spanish Recipe ID, Translated Cuisine ID, Translated Method ID and Locale fields must not be empty!");
			valid = false;
		} else if (tsprid.value.length <= 0 && sprid2.value.length <= 0
				&& tmid.value.length <= 0 && loc.value.length <= 0) {
			alert("Translated Spanish Recipe ID, Spanish Recipe ID, Translated Method ID and Locale fields must not be empty!");
			valid = false;
		} else if (tsprid.value.length <= 0 && sprid2.value.length <= 0
				&& tcid.value.length <= 0 && loc.value.length <= 0) {
			alert("Translated Spanish Recipe ID, Spanish Recipe ID, Translated Cuisine ID and Locale fields must not be empty!");
			valid = false;
		} else if (sprid2.value.length <= 0 && tcid.value.length <= 0
				&& tmid.value.length <= 0 && loc.value.length <= 0) {
			alert("Spanish Recipe ID, Translated Cuisine ID, Translated Method ID and Locale fields must not be empty!");
			valid = false;
		} else if (tsprid.value.length <= 0 && sprid2.value.length <= 0 && tcid.value.length <= 0) {
			alert("Translated Spanish Recipe ID, Spanish Recipe ID and Translated Cuisine ID fields must not be empty!");
			valid = false;
		} else if (tsprid.value.length <= 0 && sprid2.value.length <= 0 && tmid.value.length <= 0) {
			alert("Translated Spanish Recipe ID, Spanish Recipe ID and Translated Method ID fields must not be empty!");
			valid = false;
		} else if (tsprid.value.length <= 0 && sprid2.value.length <= 0 && loc.value.length <= 0) {
			alert("Translated Spanish Recipe ID, Spanish Recipe ID and Locale fields must not be empty!");
			valid = false;
		} else if (tsprid.value.length <= 0 && tcid.value.length <= 0 && tmid.value.length <= 0) {
			alert("Translated Spanish Recipe ID, Translated Cuisine ID and Translated Method ID fields must not be empty!");
			valid = false;
		} else if (tsprid.value.length <= 0 && tcid.value.length <= 0 && loc.value.length <= 0) {
			alert("Translated Spanish Recipe ID, Translated Cuisine ID and Locale fields must not be empty!");
			valid = false;
		} else if (tsprid.value.length <= 0 && tmid.value.length <= 0 && loc.value.length <= 0) {
			alert("Translated Spanish Recipe ID, Translated Method ID and Locale fields must not be empty!");
			valid = false;
		} else if (sprid2.value.length <= 0 && tcid.value.length <= 0 && tmid.value.length <= 0) {
			alert("Spanish Recipe ID, Translated Cuisine ID and Translated Method ID fields must not be empty!");
			valid = false;
		} else if (sprid2.value.length <= 0 && tcid.value.length <= 0 && loc.value.length <= 0) {
			alert("Spanish Recipe ID, Translated Cuisine ID and Locale fields must not be empty!");
			valid = false;
		} else if (sprid2.value.length <= 0 && tmid.value.length <= 0 && loc.value.length <= 0) {
			alert("Spanish Recipe ID, Translated Method ID and Locale fields must not be empty!");
			valid = false;
		} else if (tcid.value.length <= 0 && tmid.value.length <= 0 && loc.value.length <= 0) {
			alert("Translated Cuisine ID, Translated Method ID and Locale fields must not be empty!");
			valid = false;
		} else if (tsprid.value.length <= 0 && sprid2.value.length <= 0) {
			alert("Translated Spanish Recipe ID and Spanish Recipe ID fields must not be empty!");
			valid = false;
		} else if (tsprid.value.length <= 0 && tcid.value.length <= 0) {
			alert("Translated Spanish Recipe ID and Translated Cuisine ID fields must not be empty!");
			valid = false;
		} else if (tsprid.value.length <= 0 && tmid.value.length <= 0) {
			alert("Translated Spanish Recipe ID and Translated Method ID fields must not be empty!");
			valid = false;
		} else if (tsprid.value.length <= 0 && loc.value.length <= 0) {
			alert("Translated Spanish Recipe ID and Locale fields must not be empty!");
			valid = false;
		} else if (sprid2.value.length <= 0 && tcid.value.length <= 0) {
			alert("Spanish Recipe ID and Translated Cuisine ID fields must not be empty!");
			valid = false;
		} else if (sprid2.value.length <= 0 && tmid.value.length <= 0) {
			alert("Spanish Recipe ID and Translated Method ID fields must not be empty!");
			valid = false;
		} else if (sprid2.value.length <= 0 && loc.value.length <= 0) {
			alert("Spanish Recipe ID and Locale fields must not be empty!");
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
		} else if (tsprid.value.length <= 0) {
			alert("Translated Spanish Recipe ID field must not be empty!");
			valid = false;
		} else if (sprid2.value.length <= 0) {
			alert("Spanish Recipe ID field must not be empty!");
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
		} else if (isNaN(tsprid.value) && isNaN(sprid2.value)
				&& isNaN(tcid.value) && isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Spanish Recipe ID, Spanish Recipe ID, Translated Cuisine ID and Translated Method ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (isNaN(tsprid.value) && isNaN(sprid2.value)
				&& isNaN(tcid.value) && isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Translated Spanish Recipe ID, Spanish Recipe ID, Translated Cuisine ID and Translated Method ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(tsprid.value) && isNaN(sprid2.value)
				&& isNaN(tcid.value) && !isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Spanish Recipe ID, Spanish Recipe ID and Translated Cuisine ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (isNaN(tsprid.value) && isNaN(sprid2.value)
				&& isNaN(tcid.value) && !isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Translated Spanish Recipe ID, Spanish Recipe ID and Translated Cuisine ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(tsprid.value) && isNaN(sprid2.value)
				&& !isNaN(tcid.value) && isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Spanish Recipe ID, Spanish Recipe ID and Translated Method ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (isNaN(tsprid.value) && isNaN(sprid2.value)
				&& !isNaN(tcid.value) && isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Translated Spanish Recipe ID, Spanish Recipe ID and Translated Method ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(tsprid.value) && isNaN(sprid2.value)
				&& !isNaN(tcid.value) && !isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Spanish Recipe ID and Spanish Recipe ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (isNaN(tsprid.value) && isNaN(sprid2.value)
				&& !isNaN(tcid.value) && !isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Translated Spanish Recipe ID and Spanish Recipe ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(tsprid.value) && !isNaN(sprid2.value)
				&& isNaN(tcid.value) && isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Spanish Recipe ID, Translated Cuisine ID and Translated Method ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (isNaN(tsprid.value) && !isNaN(sprid2.value)
				&& isNaN(tcid.value) && isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Translated Spanish Recipe ID, Translated Cuisine ID and Translated Method ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(tsprid.value) && !isNaN(sprid2.value)
				&& isNaN(tcid.value) && !isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Spanish Recipe ID and Translated Cuisine ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (isNaN(tsprid.value) && !isNaN(sprid2.value)
				&& isNaN(tcid.value) && !isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Translated Spanish Recipe ID and Translated Cuisine ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(tsprid.value) && !isNaN(sprid2.value)
				&& !isNaN(tcid.value) && isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Spanish Recipe ID and Translated Method ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (isNaN(tsprid.value) && !isNaN(sprid2.value)
				&& !isNaN(tcid.value) && isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Translated Spanish Recipe ID and Translated Method ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(tsprid.value) && !isNaN(sprid2.value)
				&& !isNaN(tcid.value) && !isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Spanish Recipe ID field must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (isNaN(tsprid.value) && !isNaN(sprid2.value)
				&& !isNaN(tcid.value) && !isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Translated Spanish Recipe ID field must be filled with numbers!");
			valid = false;
		} else if (!isNaN(tsprid.value) && isNaN(sprid2.value)
				&& isNaN(tcid.value) && isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Spanish Recipe ID, Translated Cuisine ID and Translated Method ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (!isNaN(tsprid.value) && isNaN(sprid2.value)
				&& isNaN(tcid.value) && isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Spanish Recipe ID, Translated Cuisine ID and Translated Method ID fields must be filled with numbers!");
			valid = false;
		} else if (!isNaN(tsprid.value) && isNaN(sprid2.value)
				&& isNaN(tcid.value) && !isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Spanish Recipe ID and Translated Cuisine ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (!isNaN(tsprid.value) && isNaN(sprid2.value)
				&& isNaN(tcid.value) && !isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Spanish Recipe ID and Translated Cuisine ID fields must be filled with numbers!");
			valid = false;
		} else if (!isNaN(tsprid.value) && isNaN(sprid2.value)
				&& !isNaN(tcid.value) && isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Spanish Recipe ID and Translated Method ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (!isNaN(tsprid.value) && isNaN(sprid2.value)
				&& !isNaN(tcid.value) && isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Spanish Recipe ID and Translated Method ID fields must be filled with numbers!");
			valid = false;
		} else if (!isNaN(tsprid.value) && isNaN(sprid2.value)
				&& !isNaN(tcid.value) && !isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Spanish Recipe ID field must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (!isNaN(tsprid.value) && isNaN(sprid2.value)
				&& !isNaN(tcid.value) && !isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Spanish Recipe ID field must be filled with numbers!");
			valid = false;
		} else if (!isNaN(tsprid.value) && !isNaN(sprid2.value)
				&& isNaN(tcid.value) && isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Cuisine ID and Translated Method ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (!isNaN(tsprid.value) && !isNaN(sprid2.value)
				&& isNaN(tcid.value) && isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Translated Cuisine ID and Translated Method ID fields must be filled with numbers!");
			valid = false;
		} else if (!isNaN(tsprid.value) && !isNaN(sprid2.value)
				&& isNaN(tcid.value) && !isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Cuisine ID field must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (!isNaN(tsprid.value) && !isNaN(sprid2.value)
				&& isNaN(tcid.value) && !isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Translated Cuisine ID field must be filled with numbers!");
			valid = false;
		} else if (!isNaN(tsprid.value) && !isNaN(sprid2.value)
				&& !isNaN(tcid.value) && isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Method ID field must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (!isNaN(tsprid.value) && !isNaN(sprid2.value)
				&& !isNaN(tcid.value) && isNaN(tmid.value) && isNaN(loc.value)) {
			alert("Translated Method ID field must be filled with numbers!");
			valid = false;
		} else if (!isNaN(tsprid.value) && !isNaN(sprid2.value)
				&& !isNaN(tcid.value) && !isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Locale field must be filled with valid letters!");
			valid = false;
		} else if (tsprid.value.length > 0 && sprid2.value.length > 0
				&& tcid.value.length > 0 && tmid.value.length > 0
				&& loc.value.length > 0 && (isNaN(sprname.value) || sprname.value.length <= 0)) {
			valid = true;
		} else if (!isNaN(sprname.value)){
			alert("Spanish Recipe Name field must be filled with letters!");
			valid = false;
		}
		return valid;
	};

	function validate3() {

		var spiid = document.getElementById("spiid");
		var tsprid2 = document.getElementById("tsprid2");
		var tinid = document.getElementById("tinid");
		var valid = true;

		if (spiid.value.length <= 0 && tsprid2.value.length <= 0 && tinid.value.length <= 0) {
			alert("Spanish Ingredient ID, Translated Spanish Recipe ID and Translated Ingredient ID fields must not be empty!");
			valid = false;
		} else if (spiid.value.length <= 0 && tsprid2.value.length <= 0 && tinid.value.length > 0){
			alert("Spanish Ingredient ID and Translated Spanish Recipe ID fields must not be empty!");
			valid = false;			
		} else if (spiid.value.length <= 0 && tsprid2.value.length > 0 && tinid.value.length <= 0){
			alert("Spanish Ingredient ID and Translated Ingredient ID fields must not be empty!");
			valid = false;
		} else if (spiid.value.length <= 0 && tsprid2.value.length > 0 && tinid.value.length > 0){
			alert("Spanish Ingredient ID field must not be empty!");
			valid = false;
		} else if (spiid.value.length > 0 && tsprid2.value.length <= 0 && tinid.value.length <= 0){
			alert("Translated Spanish Recipe ID and Translated Ingredient ID fields must not be empty!");
			valid = false;
		} else if (spiid.value.length > 0 && tsprid2.value.length <= 0 && tinid.value.length > 0){
			alert("Translated Spanish Recipe ID field must not be empty!");
			valid = false;
		} else if (spiid.value.length > 0 && tsprid2.value.length > 0 && tinid.value.length <= 0){
			alert("Translated Ingredient ID field must not be empty!");
			valid = false;
		} else if (isNaN(spiid.value) && isNaN(tsprid2.value) && isNaN(tinid.value)){
			alert("Spanish Ingredient ID, Translated Spanish Recipe ID and Translated Ingredient ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(spiid.value) && isNaN(tsprid2.value) && !isNaN(tinid.value)){
			alert("Spanish Ingredient ID and Translated Spanish Recipe ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(spiid.value) && !isNaN(tsprid2.value) && isNaN(tinid.value)){
			alert("Spanish Ingredient ID and Translated Ingredient ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(spiid.value) && !isNaN(tsprid2.value) && !isNaN(tinid.value)){
			alert("Spanish Ingredient ID field must be filled with numbers!");
			valid = false;
		} else if (!isNaN(spiid.value) && isNaN(tsprid2.value) && isNaN(tinid.value)){
			alert("Translated Spanish Recipe ID and Translated Ingredient ID fields must be filled with numbers!");
			valid = false;
		} else if (!isNaN(spiid.value) && isNaN(tsprid2.value) && !isNaN(tinid.value)){
			alert("Translated Spanish Recipe ID field must be filled with numbers!");
			valid = false;
		} else if (!isNaN(spiid.value) && !isNaN(tsprid2.value) && isNaN(tinid.value)){
			alert("Translated Ingredient ID field must be filled with numbers!");
			valid = false;
		} 
		return valid;
	};

	function validate4() {

		var sprdid = document.getElementById("sprdid");
		var tsprid3 = document.getElementById("tsprid3");
		var valid = true;
		
		if (sprdid.value.length <= 0 && tsprid3.value.length <= 0) {
			alert("Spanish Recipe Description ID and Translated Spanish Recipe ID fields must not be empty!");
			valid = false;
		} else if (sprdid.value.length <= 0 && tsprid3.value.length > 0) {
			alert("Spanish Recipe Description ID field must not be empty!");
			valid = false;
		} else if (sprdid.value.length > 0 && tsprid3.value.length <= 0) {
			alert("Translated Spanish Recipe ID field must not be empty!");
			valid = false;
		} else if (isNaN(sprdid.value) && isNaN(tsprid3.value)){
			alert("Spanish Recipe Description ID and Translated Spanish Recipe ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(sprdid.value) && !isNaN(tsprid3.value)){
			alert("Spanish Recipe Description ID field must be filled with numbers!");
			valid = false;
		} else if (!isNaN(sprdid.value) && isNaN(tsprid3.value)){
			alert("Translated Spanish Recipe ID field must be filled with numbers!");
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
			into app_spanish recipes table</font><br>
	</h1>
	<center>
		<form action="./insertSpanishRecipe.ds" method="post"
			onsubmit="return validate();">
			<table width="280">
				<tr>
					<td style="background-color: buttonface;">Spanish Recipe ID:</td>
					<td><input type="text" name="sprid1" id="sprid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertSpanishRecipes"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewSpanishRecipesTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppSpanishRecipesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${spanishRecipesRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Insert
			into app_spanish_recipes_trans table</font><br>
	</h1>
	<center>
		<form action="./insertSpanishRecipeTrans.ds" method="post"
			onsubmit="return validate2();">
			<table width="350">
				<tr>
					<td style="background-color: buttonface;">Translated Spanish
						Recipe ID:</td>
					<td><input type="text" name="tsprid" id="tsprid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Spanish Recipe ID:</td>
					<td><input type="text" name="sprid2" id="sprid2"></td>
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
					<td style="background-color: buttonface;">Spanish Recipe Name:</td>
					<td><input type="text" name="sprname" id="sprname"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertSpanishRecipesTrans"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewSpanishTranslatedRecipesTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppSpanishRecipesTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${spanishTranslatedRecipesRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Insert
			into app_spanish_recipes_ingredients table</font><br>
	</h1>
	<center>
		<form action="./insertSpanishRecipeIngredients.ds" method="post"
			onsubmit="return validate3();">
			<table width="400">
				<tr>
					<td style="background-color: buttonface;">Spanish Ingredient
						ID:</td>
					<td><input type="text" name="spiid" id="spiid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Translated Spanish
						Recipe ID:</td>
					<td><input type="text" name="tsprid2" id="tsprid2"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Translated
						Ingredient ID:</td>
					<td><input type="text" name="tinid" id="tinid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Spanish Recipe
						Ingredient Quantity:</td>
					<td><input type="text" name="spriquan" id="spriquan"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertSpanishRecipesIngredients"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewSpanishRecipeIngredientsTable.ds" target="_blank">
			<br> <input type="submit"
				id="viewAppSpanishRecipesIngredientsTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${spanishRecipeIngredientsRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Insert
			into app_spanish_recipes_description table</font><br>
	</h1>
	<center>
		<form action="./insertSpanishRecipeDescriptionTable.ds" method="post"
			onsubmit="return validate4();">
			<table width="430">
				<tr>
					<td style="background-color: buttonface;">Spanish Recipe
						Description ID:</td>
					<td><input type="text" name="sprdid" id="sprdid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Translated Spanish
						Recipe ID:</td>
					<td><input type="text" name="tsprid3" id="tsprid3"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Spanish Recipe
						Description:</td>
				</tr>
			</table>
			<table>
				<tr>
					<td><textarea name="sprdesc" rows="10" cols="50" id="sprdesc"></textarea></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertSpanishRecipesDescription"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewSpanishRecipeDescriptions.ds" target="_blank">
			<br> <input type="submit"
				id="viewAppSpanishRecipesDescriptionTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${spanishDescriptionRowsAffected}</font>
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