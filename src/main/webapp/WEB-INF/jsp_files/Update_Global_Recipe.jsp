<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Global Recipe</title>
<style>
body {
	background: url(http://whatfoodlookslike.com/img/thai.jpg) no-repeat;
	background-size: cover;
}
</style>
<script>
	function goBack() {
		document.forms["GoBack"].submit();
	};

	function goHome() {
		document.forms["GoHome"].submit();
	};
	
	function validate() {

		var curglrid1 = document.getElementById("curglrid1");
		var newglrid1 = document.getElementById("newglrid1");
		var valid = true;

		if (curglrid1.value.length <= 0 && newglrid1.value.length <= 0) {
			alert("Current Global Recipe ID and New Global Recipe ID fields cannot be empty!");
			valid = false;
		} else if (curglrid1.value.length <= 0 && newglrid1.value.length > 0) {
			alert("Current Global Recipe ID field cannot be empty!");
			valid = false;
		} else if (curglrid1.value.length > 0 && newglrid1.value.length <= 0) {
			alert("New Global Recipe ID field cannot be empty!");
			valid = false;
		} else if (isNaN(curglrid1.value) && isNaN(newglrid1.value)) {
			alert("Current Global Recipe ID and New Global Recipe ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(curglrid1.value) && !isNaN(newglrid1.value)) {
			alert("Current Global Recipe ID field must be filled with numbers!");
			valid = false;
		} else if (!isNaN(curglrid1.value) && isNaN(newglrid1.value)) {
			alert("New Global Recipe ID field must be filled with numbers!");
			valid = false;
		} 
		return valid;
	};
	
	function validate2() {
		
		var curtglrid = document.getElementById("curtglrid");
		var newtglrid = document.getElementById("newtglrid");
		var curglrid2 = document.getElementById("curglrid2");
		var newglrid2 = document.getElementById("newglrid2");
		var curtcid = document.getElementById("curtcid");
		var newtcid = document.getElementById("newtcid");
		var curloc = document.getElementById("curloc");
		var newloc = document.getElementById("newloc");
		var curtmid = document.getElementById("curtmid");
		var newtmid = document.getElementById("newtmid");
		var curglrname = document.getElementById("curglrname");
		var newglrname = document.getElementById("newglrname");
		var valid = true;
		
		if (curtglrid.value.length <= 0 && curglrid2.value.length <= 0 && curtcid.value.length <= 0 
				&& curloc.value.length <= 0 && curtmid.value.length <= 0 && curglrname.value.length <= 0 
				&& newtglrid.value.length <= 0 && newglrid2.value.length <= 0 && newtcid.value.length <= 0 
				&& newloc.value.length <= 0 && newtmid.value.length <= 0 && newglrname.value.length <= 0) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if ((curtglrid.value.length > 0 || curglrid2.value.length > 0 || curtcid.value.length > 0 
				|| curloc.value.length > 0 || curtmid.value.length > 0 || curglrname.value.length > 0) 
				&& (newtglrid.value.length <= 0 && newglrid2.value.length <= 0 && newtcid.value.length <= 0 
				&& newloc.value.length <= 0 && newtmid.value.length <= 0 && newglrname.value.length <= 0)) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if ((curtglrid.value.length <= 0 && curglrid2.value.length <= 0 && curtcid.value.length <= 0 
				&& curloc.value.length <= 0 && curtmid.value.length <= 0 && curglrname.value.length <= 0) 
				&& (newtglrid.value.length > 0 || newglrid2.value.length > 0 || newtcid.value.length > 0 
				|| newloc.value.length > 0 || newtmid.value.length > 0 || newglrname.value.length > 0)) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if (curtglrid.value.length > 0 && isNaN(curtglrid.value)){
			alert("Current Translated Global Recipe ID must be filled with valid number, please check the table!");
			valid = false;
		} else if (curglrid2.value.length > 0 && isNaN(curglrid2.value)){
			alert("Current Global Recipe ID field must be filled with valid number, please check the table!");
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
		} else if (curglrname.value.length > 0 && !isNaN(curglrname.value)){
			alert("Current Global Recipe Name field must be filled with valid letters, please check the table!");
			valid = false;
		} else if (newtglrid.value.length > 0 && isNaN(newtglrid.value)){
			alert("New Translated Global Recipe ID field must be filled with number!");
			valid = false;
		} else if (newglrid2.value.length > 0 && isNaN(newglrid2.value)){
			alert("New Global Recipe ID field must be filled with number!");
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
		} else if (newglrname.value.length > 0 && !isNaN(newglrname.value)){
			alert("New Global Recipe Name field must be filled with letters!");
			valid = false;
		} 
		return valid;
	};
	
	function validate3() {
		
		var curgliid = document.getElementById("curgliid");
		var newgliid = document.getElementById("newgliid");
		var curtglrid2 = document.getElementById("curtglrid2");
		var newtglrid2 = document.getElementById("newtglrid2");
		var curtinid = document.getElementById("curtinid");
		var newtinid = document.getElementById("newtinid");
		var curglriquan = document.getElementById("curglriquan");
		var newglriquan = document.getElementById("newglriquan");
		var valid = true;
		
		if (curgliid.value.length <= 0 && curtglrid2.value.length <= 0 && curtinid.value.length <= 0 
				&& curglriquan.value.length <= 0 && newgliid.value.length <= 0 && newtglrid2.value.length <= 0 
				&& newtinid.value.length <= 0 && newglriquan.value.length <= 0) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if ((curgliid.value.length > 0 || curtglrid2.value.length > 0 || curtinid.value.length > 0 
				|| curglriquan.value.length > 0)
				&& (newgliid.value.length <= 0 && newtglrid2.value.length <= 0 && newtinid.value.length <= 0 
				&& newglriquan.value.length <= 0)) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if ((curgliid.value.length <= 0 && curtglrid2.value.length <= 0 && curtinid.value.length <= 0 
				&& curglriquan.value.length <= 0) 
				&& (newgliid.value.length > 0 || newtglrid2.value.length > 0 || newtinid.value.length > 0 
				|| newglriquan.value.length > 0)) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if (curgliid.value.length > 0 && isNaN(curgliid.value)){
			alert("Current Global Ingredient ID must be filled with valid number, please check the table!");
			valid = false;
		} else if (curtglrid2.value.length > 0 && isNaN(curtglrid2.value)){
			alert("Current Translated Global Recipe ID field must be filled with valid number, please check the table!");
			valid = false;
		} else if (curtinid.value.length > 0 && isNaN(curtinid.value)){
			alert("Current Translated Ingredient ID field must be filled with valid number, please check the table");
			valid = false;
		} else if (newgliid.value.length > 0 && isNaN(newgliid.value)){
			alert("New Global Ingredient ID field must be filled with number!");
			valid = false;
		} else if (newtglrid2.value.length > 0 && isNaN(newtglrid2.value)){
			alert("New Translated Global Recipe ID field must be filled with number!");
			valid = false;
		} else if (newtinid.value.length > 0 && isNaN(newtinid.value)){
			alert("New Translated Ingredient ID field must be filled with number!");
			valid = false;
		} 
		return valid;
	};
	
 	function validate4() {
 		
 		var curglrdid = document.getElementById("curglrdid");
 		var newglrdid = document.getElementById("newglrdid");
 		var curtglrid3 = document.getElementById("curtglrid3");
 		var newtglrid3 = document.getElementById("newtglrid3");
 		var curglrdesc = document.getElementById("curglrdesc");
 		var newglrdesc = document.getElementById("newglrdesc");
 		var valid = true;
 		
 		if (curglrdid.value.length <= 0 && curtglrid3.value.length <= 0 && curglrdesc.value.length <= 0 
				&& newglrdid.value.length <= 0 && newtglrid3.value.length <= 0 && newglrdesc.value.length <= 0) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if ((curglrdid.value.length > 0 || curtglrid3.value.length > 0 || curglrdesc.value.length > 0)
				&& (newglrdid.value.length <= 0 && newtglrid3.value.length <= 0 && newglrdesc.value.length <= 0)) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if ((curglrdid.value.length <= 0 && curtglrid3.value.length <= 0 && curglrdesc.value.length <= 0) 
				&& (newglrdid.value.length > 0 || newtglrid3.value.length > 0 || newglrdesc.value.length > 0)) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if (curglrdid.value.length > 0 && isNaN(curglrdid.value)){
			alert("Current Global Recipe Description ID must be filled with valid number, please check the table!");
			valid = false;
		} else if (curtglrid3.value.length > 0 && isNaN(curtglrid3.value)){
			alert("Current Translated Global Recipe ID field must be filled with valid number, please check the table!");
			valid = false;
		}  else if (newglrdid.value.length > 0 && isNaN(newglrdid.value)){
			alert("New Global Recipe Description ID field must be filled with number!");
			valid = false;
		} else if (newtglrid3.value.length > 0 && isNaN(newtglrid3.value)){
			alert("New Translated Global Recipe ID field must be filled with number!");
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
			app_global recipes table</font><br>
	</h1>
	<center>
		<form action="./updateGlobalRecipe.ds" method="post"
			onsubmit="return validate();">
			<table width="700">
				<tr>
					<td style="background-color: buttonface;">Current Global
						Recipe ID:</td>
					<td><input type="text" name="curglrid1" id="curglrid1"></td>
					<td style="background-color: buttonface;">New Global Recipe
						ID:</td>
					<td><input type="text" name="newglrid1" id="newglrid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateGlobalRecipe" value="UPDATE"
				style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewGlobalRecipesTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppGlobalRecipesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="black">Rows Affected:
				${updatedGlobalRecipeRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_global_recipes_trans table</font><br>
	</h1>
	<center>
		<form action="./updateGlobalTranslatedRecipe.ds" method="post"
			onsubmit="return validate2();">
			<table width="800">
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Global Recipe ID:</td>
					<td><input type="text" name="curtglrid" id="curtglrid"></td>
					<td style="background-color: buttonface;">New Translated
						Global Recipe ID:</td>
					<td><input type="text" name="newtglrid" id="newtglrid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Global
						Recipe ID:</td>
					<td><input type="text" name="curglrid2" id="curglrid2"></td>
					<td style="background-color: buttonface;">New Global Recipe
						ID:</td>
					<td><input type="text" name="newglrid2" id="newglrid2"></td>
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
					<td style="background-color: buttonface;">Current Locale:</td>
					<td><input type="text" name="curloc" id="curloc"></td>
					<td style="background-color: buttonface;">New Locale:</td>
					<td><input type="text" name="newloc" id="newloc"></td>
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
					<td style="background-color: buttonface;">Current Global
						Recipe Name:</td>
					<td><input type="text" name="curglrname" id="curglrname"></td>
					<td style="background-color: buttonface;">New Global Recipe
						Name:</td>
					<td><input type="text" name="newglrname" id="newglrname"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateGlobalRecipesTrans"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewGlobalTranslatedRecipesTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppGlobalRecipesTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="black">Rows Affected:
				${updatedTranslatedGlobalRecipeRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_global_recipes_ingredients table</font><br>
	</h1>
	<center>
		<form action="./updateGlobalRecipeIngredient.ds" method="post"
			onsubmit="return validate3();">
			<table width="900">
				<tr>
					<td style="background-color: buttonface;">Current Global
						Ingredient ID:</td>
					<td><input type="text" name="curgliid" id="curgliid"></td>
					<td style="background-color: buttonface;">New Global
						Ingredient ID:</td>
					<td><input type="text" name="newgliid" id="newgliid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Global Recipe ID:</td>
					<td><input type="text" name="curtglrid2" id="curtglrid2"></td>
					<td style="background-color: buttonface;">New Translated
						Global Recipe ID:</td>
					<td><input type="text" name="newtglrid2" id="newtglrid2"></td>
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
					<td style="background-color: buttonface;">Current Global
						Recipe Ingredient Quantity:</td>
					<td><input type="text" name="curglriquan" id="curglriquan"></td>
					<td style="background-color: buttonface;">New Global Recipe
						Ingredient Quantity:</td>
					<td><input type="text" name="newglriquan" id="newglriquan"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateGlobalRecipesIngredient"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewGlobalRecipeIngredientsTable.ds" target="_blank">
			<br> <input type="submit"
				id="viewAppGlobalRecipesIngredientsTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="black">Rows Affected:
				${updatedGlobalRecipeIngrdientRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_global_recipes_description table</font><br>
	</h1>
	<center>
		<form action="./updateGlobalRecipeDescription.ds" method="post"
			onsubmit="return validate4();">
			<table width="850">
				<tr>
					<td style="background-color: buttonface;">Current Global
						Recipe Description ID:</td>
					<td><input type="text" name="curglrdid" id="curglrdid"></td>
					<td style="background-color: buttonface;">New Global Recipe
						Description ID:</td>
					<td><input type="text" name="newglrdid" id="newglrdid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Global Recipe ID:</td>
					<td><input type="text" name="curtglrid3" id="curtglrid3"></td>
					<td style="background-color: buttonface;">New Translated
						Global Recipe ID:</td>
					<td><input type="text" name="newtglrid3" id="newtglrid3"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Global
						Recipe Description:</td>
					<td></td>
					<td style="background-color: buttonface;">New Global Recipe
						Description:</td>
				</tr>
			</table>
			<table>
				<tr>
					<td><textarea name="curglrdesc" id="curglrdesc" rows="10"
							cols="50"></textarea></td>
					<td><textarea name="newglrdesc" id="newglrdesc" rows="10"
							cols="50"></textarea></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateGlobalRecipesDescription"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewGlobalRecipeDescriptionsTable.ds" target="_blank">
			<br> <input type="submit"
				id="viewAppGlobalRecipesDescriptionTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="black">Rows Affected:
				${updatedGlobalRecipeDescriptionRowsAffected}</font>
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