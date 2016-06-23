<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Spanish Recipe</title>
<style>
body {
	background:
		url(http://informedexplorer.com/wp-content/uploads/2014/05/assorteddishesrangdebasantidhaba_sandhira_13867531372390.jpg)
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

		var cursprid1 = document.getElementById("cursprid1");
		var newsprid1 = document.getElementById("newsprid1");
		var valid = true;

		if (cursprid1.value.length <= 0 && newsprid1.value.length <= 0) {
			alert("Current Spanish Recipe ID and New Global Recipe ID fields cannot be empty!");
			valid = false;
		} else if (cursprid1.value.length <= 0 && newsprid1.value.length > 0) {
			alert("Current Spanish Recipe ID field cannot be empty!");
			valid = false;
		} else if (cursprid1.value.length > 0 && newsprid1.value.length <= 0) {
			alert("New Spanish Recipe ID field cannot be empty!");
			valid = false;
		} else if (isNaN(cursprid1.value) && isNaN(newsprid1.value)) {
			alert("Current Spanish Recipe ID and New Global Recipe ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(cursprid1.value) && !isNaN(newsprid1.value)) {
			alert("Current Spanish Recipe ID field must be filled with numbers!");
			valid = false;
		} else if (!isNaN(cursprid1.value) && isNaN(newsprid1.value)) {
			alert("New Spanish Recipe ID field must be filled with numbers!");
			valid = false;
		}
		return valid;
	};
	
	function validate2() {
		
		var curtsprid = document.getElementById("curtsprid");
		var newtsprid = document.getElementById("newtsprid");
		var cursprid2 = document.getElementById("cursprid2");
		var newsprid2 = document.getElementById("newsprid2");
		var curtcid = document.getElementById("curtcid");
		var newtcid = document.getElementById("newtcid");
		var curloc = document.getElementById("curloc");
		var newloc = document.getElementById("newloc");
		var curtmid = document.getElementById("curtmid");
		var newtmid = document.getElementById("newtmid");
		var cursprname = document.getElementById("cursprname");
		var newsprname = document.getElementById("newsprname");
		var valid = true;
		
		if (curtsprid.value.length <= 0 && cursprid2.value.length <= 0 && curtcid.value.length <= 0 
				&& curloc.value.length <= 0 && curtmid.value.length <= 0 && cursprname.value.length <= 0 
				&& newtsprid.value.length <= 0 && newsprid2.value.length <= 0 && newtcid.value.length <= 0 
				&& newloc.value.length <= 0 && newtmid.value.length <= 0 && newsprname.value.length <= 0) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if ((curtsprid.value.length > 0 || cursprid2.value.length > 0 || curtcid.value.length > 0 
				|| curloc.value.length > 0 || curtmid.value.length > 0 || cursprname.value.length > 0) 
				&& (newtsprid.value.length <= 0 && newsprid2.value.length <= 0 && newtcid.value.length <= 0 
				&& newloc.value.length <= 0 && newtmid.value.length <= 0 && newsprname.value.length <= 0)) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if ((curtsprid.value.length <= 0 && cursprid2.value.length <= 0 && curtcid.value.length <= 0 
				&& curloc.value.length <= 0 && curtmid.value.length <= 0 && cursprname.value.length <= 0) 
				&& (newtsprid.value.length > 0 || newsprid2.value.length > 0 || newtcid.value.length > 0 
				|| newloc.value.length > 0 || newtmid.value.length > 0 || newsprname.value.length > 0)) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if (curtsprid.value.length > 0 && isNaN(curtsprid.value)){
			alert("Current Translated Spanish Recipe ID must be filled with valid number, please check the table!");
			valid = false;
		} else if (cursprid2.value.length > 0 && isNaN(cursprid2.value)){
			alert("Current Spanish Recipe ID field must be filled with valid number, please check the table!");
			valid = false;
		} else if (curtcid.value.length > 0 && isNaN(curtcid.value)){
			alert("Current Translated Cuisine ID field must be filled with valid number, please check the table");
			valid = false;
		} else if (curloc.value.length > 0 && !isNaN(curloc.value)){
			alert("Current Locale field must be filled with valid letters, please check the table!");
			valid = false;
		} else if (curtmid.value.length > 0 && isNaN(curtmid.value)){
			alert("Current Translated Method field must be filled with valid number, please check the table!");
			valid = false;
		} else if (cursprname.value.length > 0 && !isNaN(cursprname.value)){
			alert("Current Spanish Recipe Name field must be filled with valid letters, please check the table!");
			valid = false;
		} else if (newtsprid.value.length > 0 && isNaN(newtsprid.value)){
			alert("New Translated Spanish Recipe ID field must be filled with number!");
			valid = false;
		} else if (newsprid2.value.length > 0 && isNaN(newsprid2.value)){
			alert("New Spanish Recipe ID field must be filled with number!");
			valid = false;
		} else if (newtcid.value.length > 0 && isNaN(newtcid.value)){
			alert("New Translated Cuisine ID field must be filled with number!");
			valid = false;
		} else if (newloc.value.length > 0 && !isNaN(newloc.value)){
			alert("New Locale field must be filled with letters!");
			valid = false;
		} else if (newtmid.value.length > 0 && isNaN(newtmid.value)){
			alert("New Translated Method ID field must be filled with number!");
			valid = false;
		} else if (newsprname.value.length > 0 && !isNaN(newsprname.value)){
			alert("New Spanish Recipe Name field must be filled with letters!");
			valid = false;
		} else
			alert("Update Completed!")
		return valid;
	};
	
	function validate3() {
		
		var curspiid = document.getElementById("curspiid");
		var newspiid = document.getElementById("newspiid");
		var curtsprid2 = document.getElementById("curtsprid2");
		var newtsprid2 = document.getElementById("newtsprid2");
		var curtinid = document.getElementById("curtinid");
		var newtinid = document.getElementById("newtinid");
		var curspriquan = document.getElementById("curspriquan");
		var newspriquan = document.getElementById("newspriquan");
		var valid = true;
		
		if (curspiid.value.length <= 0 && curtsprid2.value.length <= 0 && curtinid.value.length <= 0 
				&& curspriquan.value.length <= 0 && newspiid.value.length <= 0 && newtsprid2.value.length <= 0 
				&& newtinid.value.length <= 0 && newspriquan.value.length <= 0) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if ((curspiid.value.length > 0 || curtsprid2.value.length > 0 || curtinid.value.length > 0 
				|| curspriquan.value.length > 0)
				&& (newspiid.value.length <= 0 && newtsprid2.value.length <= 0 && newtinid.value.length <= 0 
				&& newspriquan.value.length <= 0)) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if ((curspiid.value.length <= 0 && curtsprid2.value.length <= 0 && curtinid.value.length <= 0 
				&& curspriquan.value.length <= 0) 
				&& (newspiid.value.length > 0 || newtsprid2.value.length > 0 || newtinid.value.length > 0 
				|| newspriquan.value.length > 0)) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if (curspiid.value.length > 0 && isNaN(curspiid.value)){
			alert("Current Spanish Ingredient ID must be filled with valid number, please check the table!");
			valid = false;
		} else if (curtsprid2.value.length > 0 && isNaN(curtsprid2.value)){
			alert("Current Translated Spanish Recipe ID field must be filled with valid number, please check the table!");
			valid = false;
		} else if (curtinid.value.length > 0 && isNaN(curtinid.value)){
			alert("Current Translated Ingredient ID field must be filled with valid number, please check the table");
			valid = false;
		} else if (newspiid.value.length > 0 && isNaN(newspiid.value)){
			alert("New Spanish Ingredient ID field must be filled with number!");
			valid = false;
		} else if (newtsprid2.value.length > 0 && isNaN(newtsprid2.value)){
			alert("New Translated Spanish Recipe ID field must be filled with number!");
			valid = false;
		} else if (newtinid.value.length > 0 && isNaN(newtinid.value)){
			alert("New Translated Ingredient ID field must be filled with number!");
			valid = false;
		} else
			alert("Update Completed!")
		return valid;
	};
	
 	function validate4() {
 		
 		var cursprdid = document.getElementById("cursprdid");
 		var newsprdid = document.getElementById("newsprdid");
 		var curtsprid3 = document.getElementById("curtsprid3");
 		var newtsprid3 = document.getElementById("newtsprid3");
 		var cursprdesc = document.getElementById("cursprdesc");
 		var newsprdesc = document.getElementById("newsprdesc");
 		var valid = true;
 		
 		if (cursprdid.value.length <= 0 && curtsprid3.value.length <= 0 && cursprdesc.value.length <= 0 
				&& newsprdid.value.length <= 0 && newtsprid3.value.length <= 0 && newsprdesc.value.length <= 0) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if ((cursprdid.value.length > 0 || curtsprid3.value.length > 0 || cursprdesc.value.length > 0)
				&& (newsprdid.value.length <= 0 && newtsprid3.value.length <= 0 && newsprdesc.value.length <= 0)) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if ((cursprdid.value.length <= 0 && curtsprid3.value.length <= 0 && cursprdesc.value.length <= 0) 
				&& (newsprdid.value.length > 0 || newtsprid3.value.length > 0 || newsprdesc.value.length > 0)) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if (cursprdid.value.length > 0 && isNaN(cursprdid.value)){
			alert("Current Global Recipe Description ID must be filled with valid number, please check the table!");
			valid = false;
		} else if (curtsprid3.value.length > 0 && isNaN(curtsprid3.value)){
			alert("Current Translated Global Recipe ID field must be filled with valid number, please check the table!");
			valid = false;
		}  else if (newsprdid.value.length > 0 && isNaN(newsprdid.value)){
			alert("New Global Recipe Description ID field must be filled with number!");
			valid = false;
		} else if (newtsprid3.value.length > 0 && isNaN(newtsprid3.value)){
			alert("New Translated Global Recipe ID field must be filled with number!");
			valid = false;
		} else
			alert("Update Completed!")
		return valid;
	};
</script>
</head>
<body>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_spanish recipes table</font><br>
	</h1>
	<center>
		<form action="./updateSpanishRecipe.ds" method="post"
			onsubmit="return validate();">
			<table width="700">
				<tr>
					<td style="background-color: buttonface;">Current Spanish
						Recipe ID:</td>
					<td><input type="text" name="cursprid1" id="cursprid1"></td>
					<td style="background-color: buttonface;">New Spanish Recipe
						ID:</td>
					<td><input type="text" name="newsprid1" id="newsprid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateSpanishRecipes"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewSpanishRecipesTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppSpanishRecipesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${updatedSpanishRecipeRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_spanish_recipes_trans table</font><br>
	</h1>
	<center>
		<form action="./updateTranslatedSpanishRecipe.ds" method="post"
			onsubmit="return validate2();">
			<table width="800">
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Spanish Recipe ID:</td>
					<td><input type="text" name="curtsprid" id="curtsprid"></td>
					<td style="background-color: buttonface;">New Translated
						Spanish Recipe ID:</td>
					<td><input type="text" name="newtsprid" id="newtsprid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Spanish
						Recipe ID:</td>
					<td><input type="text" name="cursprid2" id="cursprid2"></td>
					<td style="background-color: buttonface;">New Spanish Recipe
						ID:</td>
					<td><input type="text" name="newsprid2" id="newsprid2"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Cuisine ID:</td>
					<td><input type="text" name="curtcid" id="curtcid"></td>
					<td style="background-color: buttonface;">New Translated
						Cuisine ID:</td>
					<td><input type="text" name="newtcid" id="newtcid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Method ID:</td>
					<td><input type="text" name="curtmid" id="curtmid"></td>
					<td style="background-color: buttonface;">New Translated
						Method ID:</td>
					<td><input type="text" name="newtmid" id="newtmid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Locale:</td>
					<td><input type="text" name="curloc" id="curloc"></td>
					<td style="background-color: buttonface;">New Locale:</td>
					<td><input type="text" name="newloc" id="newloc"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Spanish
						Recipe Name:</td>
					<td><input type="text" name="cursprname" id="cursprname"></td>
					<td style="background-color: buttonface;">New Spanish Recipe
						Name:</td>
					<td><input type="text" name="newsprname" id="newsprname"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateSpanishRecipesTrans"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewSpanishTranslatedRecipesTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppSpanishRecipesTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${updatedTranslatedSpanishRecipeRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_spanish_recipes_ingredients table</font><br>
	</h1>
	<center>
		<form action="./updateSpanishRecipeIngredient.ds" method="post"
			onsubmit="return validate3();">
			<table width="900">
				<tr>
					<td style="background-color: buttonface;">Current Spanish
						Ingredient ID:</td>
					<td><input type="text" name="curspiid" id="curspiid"></td>
					<td style="background-color: buttonface;">New Spanish
						Ingredient ID:</td>
					<td><input type="text" name="newspiid" id="newspiid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Spanish Recipe ID:</td>
					<td><input type="text" name="curtsprid2" id="curtsprid2"></td>
					<td style="background-color: buttonface;">New Translated
						Spanish Recipe ID:</td>
					<td><input type="text" name="newtsprid2" id="newtsprid2"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Ingredient ID:</td>
					<td><input type="text" name="curtinid" id="curtinid"></td>
					<td style="background-color: buttonface;">New Translated
						Ingredient ID:</td>
					<td><input type="text" name="newtinid" id="newtinid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Spanish
						Recipe Ingredient Quantity:</td>
					<td><input type="text" name="curspriquan" id="curspriquan"></td>
					<td style="background-color: buttonface;">New Spanish Recipe
						Ingredient Quantity:</td>
					<td><input type="text" name="newspriquan" id="newspriquan"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateSpanishRecipesIngredients"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewSpanishRecipeIngredientsTable.ds" target="_blank">
			<br> <input type="submit"
				id="viewAppSpanishRecipesIngredientsTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${updatedSpanishRecipeIngrdientRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_spanish_recipes_description table</font><br>
	</h1>
	<center>
		<form action="./updateSpanishRecipeDescription.ds" method="post"
			onsubmit="return validate4();">
			<table width="850">
				<tr>
					<td style="background-color: buttonface;">Current Spanish
						Recipe Description ID:</td>
					<td><input type="text" name="cursprdid" id="cursprdid"></td>
					<td style="background-color: buttonface;">New Spanish Recipe
						Description ID:</td>
					<td><input type="text" name="newsprdid" id="newsprdid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Spanish Recipe ID:</td>
					<td><input type="text" name="curtsprid3" id="curtsprid3"></td>
					<td style="background-color: buttonface;">New Translated
						Spanish Recipe ID:</td>
					<td><input type="text" name="newtsprid3" id="newtsprid3"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Spanish
						Recipe Description:</td>
					<td></td>
					<td style="background-color: buttonface;">New Spanish Recipe
						Description:</td>
				</tr>
			</table>
			<table>
				<tr>
					<td><textarea name="cursprdesc" id="cursprdesc" rows="10"
							cols="50"></textarea></td>
					<td><textarea name="newsprdesc" id="newsprdesc" rows="10"
							cols="50"></textarea></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateSpanishRecipesDescription"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewSpanishRecipeDescriptionsTable.ds" target="_blank">
			<br> <input type="submit"
				id="viewAppSpanishRecipesDescriptionTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${updatedSpanishRecipeDescriptionRowsAffected}</font>
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