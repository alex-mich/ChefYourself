<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Greek Recipe</title>
<style>
body {
	background: url(http://whatfoodlookslike.com/img/thai.jpg) no-repeat;
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

		var curgrrid1 = document.getElementById("curgrrid1");
		var newgrrid1 = document.getElementById("newgrrid1");
		var valid = true;

		if (curgrrid1.value.length <= 0 && newgrrid1.value.length <= 0) {
			alert("Current Greek Recipe ID and New Greek Recipe ID fields cannot be empty!");
			valid = false;
		} else if (curgrrid1.value.length <= 0 && newgrrid1.value.length > 0) {
			alert("Current Greek Recipe ID field cannot be empty!");
			valid = false;
		} else if (curgrrid1.value.length > 0 && newgrrid1.value.length <= 0) {
			alert("New Greek Recipe ID field cannot be empty!");
			valid = false;
		} else if (isNaN(curgrrid1.value) && isNaN(newgrrid1.value)) {
			alert("Current Greek Recipe ID and New Greek Recipe ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(curgrrid1.value) && !isNaN(newgrrid1.value)) {
			alert("Current Greek Recipe ID field must be filled with numbers!");
			valid = false;
		} else if (!isNaN(curgrrid1.value) && isNaN(newgrrid1.value)) {
			alert("New Greek Recipe ID field must be filled with numbers!");
			valid = false;
		} 
		return valid;
	};
	
	function validate2() {
		
		var curtgrrid = document.getElementById("curtgrrid");
		var newtgrrid = document.getElementById("newtgrrid");
		var curgrrid2 = document.getElementById("curgrrid2");
		var newgrrid2 = document.getElementById("newgrrid2");
		var curtcid = document.getElementById("curtcid");
		var newtcid = document.getElementById("newtcid");
		var curloc = document.getElementById("curloc");
		var newloc = document.getElementById("newloc");
		var curtmid = document.getElementById("curtmid");
		var newtmid = document.getElementById("newtmid");
		var curgrrname = document.getElementById("curgrrname");
		var newgrrname = document.getElementById("newgrrname");
		var valid = true;
		
		if (curtgrrid.value.length <= 0 && curgrrid2.value.length <= 0 && curtcid.value.length <= 0 
				&& curloc.value.length <= 0 && curtmid.value.length <= 0 && curgrrname.value.length <= 0 
				&& newtgrrid.value.length <= 0 && newgrrid2.value.length <= 0 && newtcid.value.length <= 0 
				&& newloc.value.length <= 0 && newtmid.value.length <= 0 && newgrrname.value.length <= 0) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if ((curtgrrid.value.length > 0 || curgrrid2.value.length > 0 || curtcid.value.length > 0 
				|| curloc.value.length > 0 || curtmid.value.length > 0 || curgrrname.value.length > 0) 
				&& (newtgrrid.value.length <= 0 && newgrrid2.value.length <= 0 && newtcid.value.length <= 0 
				&& newloc.value.length <= 0 && newtmid.value.length <= 0 && newgrrname.value.length <= 0)) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if ((curtgrrid.value.length <= 0 && curgrrid2.value.length <= 0 && curtcid.value.length <= 0 
				&& curloc.value.length <= 0 && curtmid.value.length <= 0 && curgrrname.value.length <= 0) 
				&& (newtgrrid.value.length > 0 || newgrrid2.value.length > 0 || newtcid.value.length > 0 
				|| newloc.value.length > 0 || newtmid.value.length > 0 || newgrrname.value.length > 0)) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if (curtgrrid.value.length > 0 && isNaN(curtgrrid.value)){
			alert("Current Translated Greek Recipe ID must be filled with valid number, please check the table!");
			valid = false;
		} else if (curgrrid2.value.length > 0 && isNaN(curgrrid2.value)){
			alert("Current Greek Recipe ID field must be filled with valid number, please check the table!");
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
		} else if (curgrrname.value.length > 0 && !isNaN(curgrrname.value)){
			alert("Current Greek Recipe Name field must be filled with valid letters, please check the table!");
			valid = false;
		} else if (newtgrrid.value.length > 0 && isNaN(newtgrrid.value)){
			alert("New Translated Greek Recipe ID field must be filled with number!");
			valid = false;
		} else if (newgrrid2.value.length > 0 && isNaN(newgrrid2.value)){
			alert("New Greek Recipe ID field must be filled with number!");
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
		} else if (newgrrname.value.length > 0 && !isNaN(newgrrname.value)){
			alert("New Greek Recipe Name field must be filled with letters!");
			valid = false;
		}
		return valid;
	};
	
	function validate3() {
		
		var curgriid = document.getElementById("curgriid");
		var newgriid = document.getElementById("newgriid");
		var curtgrrid2 = document.getElementById("curtgrrid2");
		var newtgrrid2 = document.getElementById("newtgrrid2");
		var curtinid = document.getElementById("curtinid");
		var newtinid = document.getElementById("newtinid");
		var curgrriquan = document.getElementById("curgrriquan");
		var newgrriquan = document.getElementById("newgrriquan");
		var valid = true;
		
		if (curgriid.value.length <= 0 && curtgrrid2.value.length <= 0 && curtinid.value.length <= 0 
				&& curgrriquan.value.length <= 0 && newgriid.value.length <= 0 && newtgrrid2.value.length <= 0 
				&& newtinid.value.length <= 0 && newgrriquan.value.length <= 0) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if ((curgriid.value.length > 0 || curtgrrid2.value.length > 0 || curtinid.value.length > 0 
				|| curgrriquan.value.length > 0)
				&& (newgriid.value.length <= 0 && newtgrrid2.value.length <= 0 && newtinid.value.length <= 0 
				&& newgrriquan.value.length <= 0)) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if ((curgriid.value.length <= 0 && curtgrrid2.value.length <= 0 && curtinid.value.length <= 0 
				&& curgrriquan.value.length <= 0) 
				&& (newgriid.value.length > 0 || newtgrrid2.value.length > 0 || newtinid.value.length > 0 
				|| newgrriquan.value.length > 0)) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if (curgriid.value.length > 0 && isNaN(curgriid.value)){
			alert("Current Greek Ingredient ID must be filled with valid number, please check the table!");
			valid = false;
		} else if (curtgrrid2.value.length > 0 && isNaN(curtgrrid2.value)){
			alert("Current Translated Greek Recipe ID field must be filled with valid number, please check the table!");
			valid = false;
		} else if (curtinid.value.length > 0 && isNaN(curtinid.value)){
			alert("Current Translated Ingredient ID field must be filled with valid number, please check the table");
			valid = false;
		} else if (newgriid.value.length > 0 && isNaN(newgriid.value)){
			alert("New Greek Ingredient ID field must be filled with number!");
			valid = false;
		} else if (newtgrrid2.value.length > 0 && isNaN(newtgrrid2.value)){
			alert("New Translated Greek Recipe ID field must be filled with number!");
			valid = false;
		} else if (newtinid.value.length > 0 && isNaN(newtinid.value)){
			alert("New Translated Ingredient ID field must be filled with number!");
			valid = false;
		}
		return valid;
	};
	
 	function validate4() {
 		
 		var curgrrdid = document.getElementById("curgrrdid");
 		var newgrrdid = document.getElementById("newgrrdid");
 		var curtgrrid3 = document.getElementById("curtgrrid3");
 		var newtgrrid3 = document.getElementById("newtgrrid3");
 		var curgrrdesc = document.getElementById("curgrrdesc");
 		var newgrrdesc = document.getElementById("newgrrdesc");
 		var valid = true;
 		
 		if (curgrrdid.value.length <= 0 && curtgrrid3.value.length <= 0 && curgrrdesc.value.length <= 0 
				&& newgrrdid.value.length <= 0 && newtgrrid3.value.length <= 0 && newgrrdesc.value.length <= 0) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if ((curgrrdid.value.length > 0 || curtgrrid3.value.length > 0 || curgrrdesc.value.length > 0)
				&& (newgrrdid.value.length <= 0 && newtgrrid3.value.length <= 0 && newgrrdesc.value.length <= 0)) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if ((curgrrdid.value.length <= 0 && curtgrrid3.value.length <= 0 && curgrrdesc.value.length <= 0) 
				&& (newgrrdid.value.length > 0 || newtgrrid3.value.length > 0 || newgrrdesc.value.length > 0)) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if (curgrrdid.value.length > 0 && isNaN(curgrrdid.value)){
			alert("Current Greek Recipe Description ID must be filled with valid number, please check the table!");
			valid = false;
		} else if (curtgrrid3.value.length > 0 && isNaN(curtgrrid3.value)){
			alert("Current Translated Greek Recipe ID field must be filled with valid number, please check the table!");
			valid = false;
		}  else if (newgrrdid.value.length > 0 && isNaN(newgrrdid.value)){
			alert("New Greek Recipe Description ID field must be filled with number!");
			valid = false;
		} else if (newtgrrid3.value.length > 0 && isNaN(newtgrrid3.value)){
			alert("New Translated Greek Recipe ID field must be filled with number!");
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
			app_greek recipes table</font><br>
	</h1>
	<center>
		<form action="./updateGreekRecipe.ds" method="post"
			onsubmit="return validate();">
			<table width="700">
				<tr>
					<td style="background-color: buttonface;">Current Greek Recipe
						ID:</td>
					<td><input type="text" name="curgrrid1" id="curgrrid1"></td>
					<td style="background-color: buttonface;">New Greek Recipe ID:</td>
					<td><input type="text" name="newgrrid1" id="newgrrid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateGreekRecipe" value="UPDATE"
				style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewGreekRecipesTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppGreekRecipesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="black">Rows Affected:
				${updatedGreekRecipeRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_greek_recipes_trans table</font><br>
	</h1>
	<center>
		<form action="./updateGreekTranslatedRecipe.ds" method="post"
			onsubmit="return validate2();">
			<table width="800">
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Greek Recipe ID:</td>
					<td><input type="text" name="curtgrrid" id="curtgrrid"></td>
					<td style="background-color: buttonface;">New Translated Greek
						Recipe ID:</td>
					<td><input type="text" name="newtgrrid" id="newtgrrid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Greek Recipe
						ID:</td>
					<td><input type="text" name="curgrrid2" id="curgrrid2"></td>
					<td style="background-color: buttonface;">New Greek Recipe ID:</td>
					<td><input type="text" name="newgrrid2" id="newgrrid2"></td>
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
					<td style="background-color: buttonface;">Current Greek Recipe
						Name:</td>
					<td><input type="text" name="curgrrname" id="curgrrname"></td>
					<td style="background-color: buttonface;">New Greek Recipe
						Name:</td>
					<td><input type="text" name="newgrrname" id="newgrrname"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateGreekRecipesTrans"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewGreekTranslatedRecipesTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppGreekRecipesTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="black">Rows Affected:
				${updatedTranslatedGreekRecipeRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_greek_recipes_ingredients table</font><br>
	</h1>
	<center>
		<form action="./updateGreekRecipeIngredient.ds" method="post"
			onsubmit="return validate3();">
			<table width="900">
				<tr>
					<td style="background-color: buttonface;">Current Greek
						Ingredient ID:</td>
					<td><input type="text" name="curgriid" id="curgriid"></td>
					<td style="background-color: buttonface;">New Greek Ingredient
						ID:</td>
					<td><input type="text" name="newgriid" id="newgriid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Greek Recipe ID:</td>
					<td><input type="text" name="curtgrrid2" id="curtgrrid2"></td>
					<td style="background-color: buttonface;">New Translated Greek
						Recipe ID:</td>
					<td><input type="text" name="newtgrrid2" id="newtgrrid2"></td>
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
					<td style="background-color: buttonface;">Current Greek Recipe
						Ingredient Quantity:</td>
					<td><input type="text" name="curgrriquan" id="curgrriquan"></td>
					<td style="background-color: buttonface;">New Greek Recipe
						Ingredient Quantity:</td>
					<td><input type="text" name="newgrriquan" id="newgrriquan"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateGreekRecipesIngredient"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewGreekRecipeIngredientsTable.ds" target="_blank">
			<br> <input type="submit"
				id="viewAppGreekRecipesIngredientsTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="black">Rows Affected:
				${updatedGreekRecipeIngrdientRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_greek_recipes_description table</font><br>
	</h1>
	<center>
		<form action="./updateGreekRecipeDescription.ds" method="post"
			onsubmit="return validate4();">
			<table width="850">
				<tr>
					<td style="background-color: buttonface;">Current Greek Recipe
						Description ID:</td>
					<td><input type="text" name="curgrrdid" id="curgrrdid"></td>
					<td style="background-color: buttonface;">New Greek Recipe
						Description ID:</td>
					<td><input type="text" name="newgrrdid" id="newgrrdid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Greek Recipe ID:</td>
					<td><input type="text" name="curtgrrid3" id="curtgrrid3"></td>
					<td style="background-color: buttonface;">New Translated Greek
						Recipe ID:</td>
					<td><input type="text" name="newtgrrid3" id="newtgrrid3"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Greek Recipe
						Description:</td>
					<td></td>
					<td style="background-color: buttonface;">New Greek Recipe
						Description:</td>
				</tr>
			</table>
			<table>
				<tr>
					<td><textarea name="curgrrdesc" id="curgrrdesc" rows="10"
							cols="50"></textarea></td>
					<td><textarea name="newgrrdesc" id="newgrrdesc" rows="10"
							cols="50"></textarea></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateGreekRecipesDescription"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewGreekRecipeDescriptionsTable.ds" target="_blank">
			<br> <input type="submit"
				id="viewAppGreekRecipesDescriptionTable" value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="black">Rows Affected:
				${updatedGreekRecipeDescriptionRowsAffected}</font>
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