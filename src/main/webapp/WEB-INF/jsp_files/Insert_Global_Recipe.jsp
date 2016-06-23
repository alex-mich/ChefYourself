<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Global Recipe</title>
<style>
body {
	background:
		url(http://paulapuffer.net/wp-content/uploads/2014/02/DSC_30381.jpg)
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

		var glrid1 = document.getElementById("glrid1");
		var valid = true;

		if (glrid1.value.length <= 0) {
			alert("Global Recipe ID field cannot be empty!");
			valid = false;
		} else if (isNaN(glrid1.value)) {
			alert("Global Recipe ID field must be filled with numbers!");
			valid = false;
		} else {
			alert("Insertion Completed!");
		}
		return valid;
	};

	function validate2() {

		var tglrid = document.getElementById("tglrid");
		var glrid2 = document.getElementById("glrid2");
		var tcid = document.getElementById("tcid");
		var tmid = document.getElementById("tmid");
		var loc = document.getElementById("loc");
		var glrname = document.getElementById("glrname");
		var valid = true;

		if (tglrid.value.length <= 0 && glrid2.value.length <= 0
				&& tcid.value.length <= 0 && tmid.value.length <= 0
				&& loc.value.length <= 0) {
			alert("Translated Global Recipe ID, Global Recipe ID, Translated Cuisine ID, Translated Method ID and Locale fields must not be empty!");
			valid = false;
		} else if (tglrid.value.length <= 0 && glrid2.value.length <= 0
				&& tcid.value.length <= 0 && tmid.value.length <= 0) {
			alert("Translated Global Recipe ID, Global Recipe ID, Translated Cuisine ID and Translated Method ID fields must not be empty!");
			valid = false;
		} else if (tglrid.value.length <= 0 && tcid.value.length <= 0
				&& tmid.value.length <= 0 && loc.value.length <= 0) {
			alert("Translated Global Recipe ID, Translated Cuisine ID, Translated Method ID and Locale fields must not be empty!");
			valid = false;
		} else if (tglrid.value.length <= 0 && glrid2.value.length <= 0
				&& tmid.value.length <= 0 && loc.value.length <= 0) {
			alert("Translated Global Recipe ID, Global Recipe ID, Translated Method ID and Locale fields must not be empty!");
			valid = false;
		} else if (tglrid.value.length <= 0 && glrid2.value.length <= 0
				&& tcid.value.length <= 0 && loc.value.length <= 0) {
			alert("Translated Global Recipe ID, Global Recipe ID, Translated Cuisine ID and Locale fields must not be empty!");
			valid = false;
		} else if (glrid2.value.length <= 0 && tcid.value.length <= 0
				&& tmid.value.length <= 0 && loc.value.length <= 0) {
			alert("Global Recipe ID, Translated Cuisine ID, Translated Method ID and Locale fields must not be empty!");
			valid = false;
		} else if (tglrid.value.length <= 0 && glrid2.value.length <= 0
				&& tcid.value.length <= 0) {
			alert("Translated Global Recipe ID, Global Recipe ID and Translated Cuisine ID fields must not be empty!");
			valid = false;
		} else if (tglrid.value.length <= 0 && glrid2.value.length <= 0
				&& tmid.value.length <= 0) {
			alert("Translated Global Recipe ID, Global Recipe ID and Translated Method ID fields must not be empty!");
			valid = false;
		} else if (tglrid.value.length <= 0 && glrid2.value.length <= 0
				&& loc.value.length <= 0) {
			alert("Translated Global Recipe ID, Global Recipe ID and Locale fields must not be empty!");
			valid = false;
		} else if (tglrid.value.length <= 0 && tcid.value.length <= 0
				&& tmid.value.length <= 0) {
			alert("Translated Global Recipe ID, Translated Cuisine ID and Translated Method ID fields must not be empty!");
			valid = false;
		} else if (tglrid.value.length <= 0 && tcid.value.length <= 0
				&& loc.value.length <= 0) {
			alert("Translated Global Recipe ID, Translated Cuisine ID and Locale fields must not be empty!");
			valid = false;
		} else if (tglrid.value.length <= 0 && tmid.value.length <= 0
				&& loc.value.length <= 0) {
			alert("Translated Global Recipe ID, Translated Method ID and Locale fields must not be empty!");
			valid = false;
		} else if (glrid2.value.length <= 0 && tcid.value.length <= 0
				&& tmid.value.length <= 0) {
			alert("Global Recipe ID, Translated Cuisine ID and Translated Method ID fields must not be empty!");
			valid = false;
		} else if (glrid2.value.length <= 0 && tcid.value.length <= 0
				&& loc.value.length <= 0) {
			alert("Global Recipe ID, Translated Cuisine ID and Locale fields must not be empty!");
			valid = false;
		} else if (glrid2.value.length <= 0 && tmid.value.length <= 0
				&& loc.value.length <= 0) {
			alert("Global Recipe ID, Translated Method ID and Locale fields must not be empty!");
			valid = false;
		} else if (tcid.value.length <= 0 && tmid.value.length <= 0
				&& loc.value.length <= 0) {
			alert("Translated Cuisine ID, Translated Method ID and Locale fields must not be empty!");
			valid = false;
		} else if (tglrid.value.length <= 0 && glrid2.value.length <= 0) {
			alert("Translated Global Recipe ID and Global Recipe ID fields must not be empty!");
			valid = false;
		} else if (tglrid.value.length <= 0 && tcid.value.length <= 0) {
			alert("Translated Global Recipe ID and Translated Cuisine ID fields must not be empty!");
			valid = false;
		} else if (tglrid.value.length <= 0 && tmid.value.length <= 0) {
			alert("Translated Global Recipe ID and Translated Method ID fields must not be empty!");
			valid = false;
		} else if (tglrid.value.length <= 0 && loc.value.length <= 0) {
			alert("Translated Global Recipe ID and Locale fields must not be empty!");
			valid = false;
		} else if (glrid2.value.length <= 0 && tcid.value.length <= 0) {
			alert("Global Recipe ID and Translated Cuisine ID fields must not be empty!");
			valid = false;
		} else if (glrid2.value.length <= 0 && tmid.value.length <= 0) {
			alert("Global Recipe ID and Translated Method ID fields must not be empty!");
			valid = false;
		} else if (glrid2.value.length <= 0 && loc.value.length <= 0) {
			alert("Global Recipe ID and Locale fields must not be empty!");
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
		} else if (tglrid.value.length <= 0) {
			alert("Translated Global Recipe ID field must not be empty!");
			valid = false;
		} else if (glrid2.value.length <= 0) {
			alert("Global Recipe ID field must not be empty!");
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
		} else if (isNaN(tglrid.value) && isNaN(glrid2.value)
				&& isNaN(tcid.value) && isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Global Recipe ID, Global Recipe ID, Translated Cuisine ID and Translated Method ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (isNaN(tglrid.value) && isNaN(glrid2.value)
				&& isNaN(tcid.value) && isNaN(tmid.value)
				&& isNaN(loc.value)) {
			alert("Translated Global Recipe ID, Global Recipe ID, Translated Cuisine ID and Translated Method ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(tglrid.value) && isNaN(glrid2.value)
				&& isNaN(tcid.value) && !isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Global Recipe ID, Global Recipe ID and Translated Cuisine ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (isNaN(tglrid.value) && isNaN(glrid2.value)
				&& isNaN(tcid.value) && !isNaN(tmid.value)
				&& isNaN(loc.value)) {
			alert("Translated Global Recipe ID, Global Recipe ID and Translated Cuisine ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(tglrid.value) && isNaN(glrid2.value)
				&& !isNaN(tcid.value) && isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Global Recipe ID, Global Recipe ID and Translated Method ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (isNaN(tglrid.value) && isNaN(glrid2.value)
				&& !isNaN(tcid.value) && isNaN(tmid.value)
				&& isNaN(loc.value)) {
			alert("Translated Global Recipe ID, Global Recipe ID and Translated Method ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(tglrid.value) && isNaN(glrid2.value)
				&& !isNaN(tcid.value) && !isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Global Recipe ID and Global Recipe ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (isNaN(tglrid.value) && isNaN(glrid2.value)
				&& !isNaN(tcid.value) && !isNaN(tmid.value)
				&& isNaN(loc.value)) {
			alert("Translated Global Recipe ID and Global Recipe ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(tglrid.value) && !isNaN(glrid2.value)
				&& isNaN(tcid.value) && isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Global Recipe ID, Translated Cuisine ID and Translated Method ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (isNaN(tglrid.value) && !isNaN(glrid2.value)
				&& isNaN(tcid.value) && isNaN(tmid.value)
				&& isNaN(loc.value)) {
			alert("Translated Global Recipe ID, Translated Cuisine ID and Translated Method ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(tglrid.value) && !isNaN(glrid2.value)
				&& isNaN(tcid.value) && !isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Global Recipe ID and Translated Cuisine ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (isNaN(tglrid.value) && !isNaN(glrid2.value)
				&& isNaN(tcid.value) && !isNaN(tmid.value)
				&& isNaN(loc.value)) {
			alert("Translated Global Recipe ID and Translated Cuisine ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(tglrid.value) && !isNaN(glrid2.value)
				&& !isNaN(tcid.value) && isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Global Recipe ID and Translated Method ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (isNaN(tglrid.value) && !isNaN(glrid2.value)
				&& !isNaN(tcid.value) && isNaN(tmid.value)
				&& isNaN(loc.value)) {
			alert("Translated Global Recipe ID and Translated Method ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(tglrid.value) && !isNaN(glrid2.value)
				&& !isNaN(tcid.value) && !isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Global Recipe ID field must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (isNaN(tglrid.value) && !isNaN(glrid2.value)
				&& !isNaN(tcid.value) && !isNaN(tmid.value)
				&& isNaN(loc.value)) {
			alert("Translated Global Recipe ID field must be filled with numbers!");
			valid = false;
		} else if (!isNaN(tglrid.value) && isNaN(glrid2.value)
				&& isNaN(tcid.value) && isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Global Recipe ID, Translated Cuisine ID and Translated Method ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (!isNaN(tglrid.value) && isNaN(glrid2.value)
				&& isNaN(tcid.value) && isNaN(tmid.value)
				&& isNaN(loc.value)) {
			alert("Global Recipe ID, Translated Cuisine ID and Translated Method ID fields must be filled with numbers!");
			valid = false;
		} else if (!isNaN(tglrid.value) && isNaN(glrid2.value)
				&& isNaN(tcid.value) && !isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Global Recipe ID and Translated Cuisine ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (!isNaN(tglrid.value) && isNaN(glrid2.value)
				&& isNaN(tcid.value) && !isNaN(tmid.value)
				&& isNaN(loc.value)) {
			alert("Global Recipe ID and Translated Cuisine ID fields must be filled with numbers!");
			valid = false;
		} else if (!isNaN(tglrid.value) && isNaN(glrid2.value)
				&& !isNaN(tcid.value) && isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Global Recipe ID and Translated Method ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (!isNaN(tglrid.value) && isNaN(glrid2.value)
				&& !isNaN(tcid.value) && isNaN(tmid.value)
				&& isNaN(loc.value)) {
			alert("Global Recipe ID and Translated Method ID fields must be filled with numbers!");
			valid = false;
		} else if (!isNaN(tglrid.value) && isNaN(glrid2.value)
				&& !isNaN(tcid.value) && !isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Global Recipe ID field must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (!isNaN(tglrid.value) && isNaN(glrid2.value)
				&& !isNaN(tcid.value) && !isNaN(tmid.value)
				&& isNaN(loc.value)) {
			alert("Global Recipe ID field must be filled with numbers!");
			valid = false;
		} else if (!isNaN(tglrid.value) && !isNaN(glrid2.value)
				&& isNaN(tcid.value) && isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Cuisine ID and Translated Method ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (!isNaN(tglrid.value) && !isNaN(glrid2.value)
				&& isNaN(tcid.value) && isNaN(tmid.value)
				&& isNaN(loc.value)) {
			alert("Translated Cuisine ID and Translated Method ID fields must be filled with numbers!");
			valid = false;
		} else if (!isNaN(tglrid.value) && !isNaN(glrid2.value)
				&& isNaN(tcid.value) && !isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Cuisine ID field must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (!isNaN(tglrid.value) && !isNaN(glrid2.value)
				&& isNaN(tcid.value) && !isNaN(tmid.value)
				&& isNaN(loc.value)) {
			alert("Translated Cuisine ID field must be filled with numbers!");
			valid = false;
		} else if (!isNaN(tglrid.value) && !isNaN(glrid2.value)
				&& !isNaN(tcid.value) && isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Translated Method ID field must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (!isNaN(tglrid.value) && !isNaN(glrid2.value)
				&& !isNaN(tcid.value) && isNaN(tmid.value)
				&& isNaN(loc.value)) {
			alert("Translated Method ID field must be filled with numbers!");
			valid = false;
		} else if (!isNaN(tglrid.value) && !isNaN(glrid2.value)
				&& !isNaN(tcid.value) && !isNaN(tmid.value) && !isNaN(loc.value)) {
			alert("Locale field must be filled with valid letters!");
			valid = false;
		} else if (tglrid.value.length > 0 && glrid2.value.length > 0
				&& tcid.value.length > 0 && tmid.value.length > 0
				&& loc.value.length > 0 && (isNaN(glrname.value) || glrname.value.length <= 0)) {
			alert("Insertion Completed!");
			valid = true;
		} else if (!isNaN(glrname.value)){
			alert("Global Recipe Name field must be filled with letters!");
			valid = false;
		} 
		return valid;
	};

	function validate3() {

		var gliid = document.getElementById("gliid");
		var tglrid2 = document.getElementById("tglrid2");
		var tinid = document.getElementById("tinid");
		var valid = true;

		if (gliid.value.length <= 0 && tglrid2.value.length <= 0
				&& tinid.value.length <= 0) {
			alert("Global Ingredient ID, Translated Global Recipe ID and Translated Ingredient ID fields must not be empty!");
			valid = false;
		} else if (gliid.value.length <= 0 && tglrid2.value.length <= 0
				&& tinid.value.length > 0){
			alert("Global Ingredient ID and Translated Global Recipe ID fields must not be empty!");
			valid = false;			
		} else if (gliid.value.length <= 0 && tglrid2.value.length > 0
				&& tinid.value.length <= 0){
			alert("Global Ingredient ID and Translated Ingredient ID fields must not be empty!");
			valid = false;
		} else if (gliid.value.length <= 0 && tglrid2.value.length > 0
				&& tinid.value.length > 0){
			alert("Global Ingredient ID field must not be empty!");
			valid = false;
		} else if (gliid.value.length > 0 && tglrid2.value.length <= 0
				&& tinid.value.length <= 0){
			alert("Translated Global Recipe ID and Translated Ingredient ID fields must not be empty!");
			valid = false;
		} else if (gliid.value.length > 0 && tglrid2.value.length <= 0
				&& tinid.value.length > 0){
			alert("Translated Global Recipe ID field must not be empty!");
			valid = false;
		} else if (gliid.value.length > 0 && tglrid2.value.length > 0
				&& tinid.value.length <= 0){
			alert("Translated Ingredient ID field must not be empty!");
			valid = false;
		} else if (isNaN(gliid.value) && isNaN(tglrid2.value)
				&& isNaN(tinid.value)){
			alert("Global Ingredient ID, Translated Global Recipe ID and Translated Ingredient ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(gliid.value) && isNaN(tglrid2.value)
				&& !isNaN(tinid.value)){
			alert("Global Ingredient ID and Translated Global Recipe ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(gliid.value) && !isNaN(tglrid2.value)
				&& isNaN(tinid.value)){
			alert("Global Ingredient ID and Translated Ingredient ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(gliid.value) && !isNaN(tglrid2.value)
				&& !isNaN(tinid.value)){
			alert("Global Ingredient ID field must be filled with numbers!");
			valid = false;
		} else if (!isNaN(gliid.value) && isNaN(tglrid2.value)
				&& isNaN(tinid.value)){
			alert("Translated Global Recipe ID and Translated Ingredient ID fields must be filled with numbers!");
			valid = false;
		} else if (!isNaN(gliid.value) && isNaN(tglrid2.value)
				&& !isNaN(tinid.value)){
			alert("Translated Global Recipe ID field must be filled with numbers!");
			valid = false;
		} else if (!isNaN(gliid.value) && !isNaN(tglrid2.value)
				&& isNaN(tinid.value)){
			alert("Translated Ingredient ID field must be filled with numbers!");
			valid = false;
		} else {
			alert("Insertion Completed!");
		}
		return valid;
	};

	function validate4() {

		var glrdid = document.getElementById("glrdid");
		var tglrid3 = document.getElementById("tglrid3");
		var valid = true;
		
		if (glrdid.value.length <= 0 && tglrid3.value.length <= 0) {
			alert("Global Recipe Description ID and Translated Global Recipe ID fields must not be empty!");
			valid = false;
		} else if (glrdid.value.length <= 0 && tglrid3.value.length > 0) {
			alert("Global Recipe Description ID field must not be empty!");
			valid = false;
		} else if (glrdid.value.length > 0 && tglrid3.value.length <= 0) {
			alert("Translated Global Recipe ID field must not be empty!");
			valid = false;
		} else if (isNaN(glrdid.value) && isNaN(tglrid3.value)){
			alert("Global Recipe Description ID and Translated Global Recipe ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(glrdid.value) && !isNaN(tglrid3.value)){
			alert("Global Recipe Description ID field must be filled with numbers!");
			valid = false;
		} else if (!isNaN(glrdid.value) && isNaN(tglrid3.value)){
			alert("Translated Global Recipe ID field must be filled with numbers!");
			valid = false;
		} else {
			alert("Insertion Completed!");
		}
		return valid;
	};
</script>
</head>
<body>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Insert
			into app_global recipes table</font><br>
	</h1>
	<center>
		<form action="./insertGlobalRecipe.ds" method="post"
			onsubmit="return validate();">
			<table width="280">
				<tr>
					<td style="background-color: buttonface;">Global Recipe ID:</td>
					<td><input type="text" name="glrid1" id="glrid1"></td>
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
		<form action="./insertGlobalRecipeTrans.ds" method="post"
			onsubmit="return validate2();">
			<table width="350">
				<tr>
					<td style="background-color: buttonface;">Translated Global
						Recipe ID:</td>
					<td><input type="text" name="tglrid" id="tglrid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Global Recipe ID:</td>
					<td><input type="text" name="glrid2" id="glrid2"></td>
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
					<td style="background-color: buttonface;">Global Recipe Name:</td>
					<td><input type="text" name="glrname" id="glrname"></td>
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
		<form action="./insertGlobalRecipeIngredients.ds" method="post"
			onsubmit="return validate3();">
			<table width="400">
				<tr>
					<td style="background-color: buttonface;">Global Ingredient
						ID:</td>
					<td><input type="text" name="gliid" id="gliid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Translated Global
						Recipe ID:</td>
					<td><input type="text" name="tglrid2" id="tglrid2"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Translated
						Ingredient ID:</td>
					<td><input type="text" name="tinid" id="tinid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Global Recipe
						Ingredient Quantity:</td>
					<td><input type="text" name="glriquan" id="glriquan"></td>
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
		<form action="./insertGlobalRecipeDescription.ds" method="post"
			onsubmit="return validate4();">
			<table width="430">
				<tr>
					<td style="background-color: buttonface;">Global Recipe
						Description ID:</td>
					<td><input type="text" name="glrdid" id="glrdid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Translated Global
						Recipe ID:</td>
					<td><input type="text" name="tglrid3" id="tglrid3"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Global Recipe
						Description:</td>
				</tr>
			</table>
			<table>
				<tr>
					<td><textarea name="glrdesc" rows="10" cols="50" id="glrdesc"></textarea></td>
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