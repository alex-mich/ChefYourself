<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Cuisine</title>
<style>
body {
	background:
		url(http://loveinshallah.files.wordpress.com/2014/04/flm2.jpg)
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

		var curcid1 = document.getElementById("curcid1");
		var newcid1 = document.getElementById("newcid1");
		var valid = true;

		if (curcid1.value.length <= 0 && newcid1.value.length <= 0) {
			alert("Current Cuisine ID and New Cuisine ID fields cannot be empty!");
			valid = false;
		} else if (curcid1.value.length <= 0 && newcid1.value.length > 0) {
			alert("Current Cuisine ID field cannot be empty!");
			valid = false;
		} else if (curcid1.value.length > 0 && newcid1.value.length <= 0) {
			alert("New Cuisine ID field cannot be empty!");
			valid = false;
		} else if (isNaN(curcid1.value) && isNaN(newcid1.value)) {
			alert("Current Cuisine ID and New Cuisine ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(curcid1.value) && !isNaN(newcid1.value)) {
			alert("Current Cuisine ID field must be filled with valid numbers!Check the table!");
			valid = false;
		} else if (!isNaN(curcid1.value) && isNaN(newcid1.value)) {
			alert("New Cuisine ID field must be filled with numbers!");
			valid = false;
		}
		return valid;
	};
	
function validate2(){
		
		var curtcid = document.getElementById("curtcid");
		var curcid2 = document.getElementById("curcid2");
		var curloc = document.getElementById("curloc");
		var curcname = document.getElementById("curcname");
		var newtcid = document.getElementById("newtcid");
		var newcid2 = document.getElementById("newcid2");
		var newloc = document.getElementById("newloc");
		var newcname = document.getElementById("newcname");
		var valid = true;
		
		if (curtcid.value.length <= 0 && curcid2.value.length <= 0 && curloc.value.length <= 0 
				&& curcname.value.length <= 0 && newtcid.value.length <= 0 && newcid2.value.length <= 0 
				&& newloc.value.length <= 0 && newcname.value.length <= 0) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if ((curtcid.value.length > 0 || curcid2.value.length > 0 || curloc.value.length > 0 
				|| curcname.value.length > 0)
				&& (newtcid.value.length <= 0 && newcid2.value.length <= 0 && newloc.value.length <= 0 
				&& newcname.value.length <= 0)) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if ((curtcid.value.length <= 0 && curcid2.value.length <= 0 && curloc.value.length <= 0 
				&& curcname.value.length <= 0) 
				&& (newtcid.value.length > 0 || newcid2.value.length > 0 || newloc.value.length > 0 
				|| newcname.value.length > 0)) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if (curtcid.value.length > 0 && isNaN(curtcid.value)){
			alert("Current Translated Cuisine ID must be filled with valid number, please check the table!");
			valid = false;
		} else if (curcid2.value.length > 0 && isNaN(curcid2.value)){
			alert("Current Cuisine ID field must be filled with valid number, please check the table!");
			valid = false;
		} else if (curloc.value.length > 0 && !isNaN(curloc.value)){
			alert("Current Locale field must be filled with valid letters, please check the table");
			valid = false;
		} else if (curcname.value.length > 0 && !isNaN(curcname.value)){
			alert("Current Cuisine Name must be filled with valid letters, please check the table!");
			valid = false;
		} else if (newtcid.value.length > 0 && isNaN(newtcid.value)){
			alert("New Translated Cuisine ID field must be filled with number!");
			valid = false;
		} else if (newcid2.value.length > 0 && isNaN(newcid2.value)){
			alert("New Cuisine ID field must be filled with number!");
			valid = false;
		} else if (newloc.value.length > 0 && !isNaN(newloc.value)){
			alert("New Locale field must be filled with letters!");
			valid = false;
		} else if (newcname.value.length > 0 && !isNaN(newcname.value)){
			alert("New Cuisine Name field must be filled with letters!");
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
			app_cuisines table</font><br>
	</h1>
	<center>
		<form action="./updateCuisine.ds" method="post"
			onsubmit="return validate();">
			<table width="600">
				<tr>
					<td style="background-color: buttonface;">Current Cuisine ID:</td>
					<td><input type="text" name="curcid1" id="curcid1"></td>
					<td style="background-color: buttonface;">New Cuisine ID:</td>
					<td><input type="text" name="newcid1" id="newcid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateAppCuisines" value="UPDATE"
				style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewCuisinesTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppCuisinesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;"><br>
		</form>
		<h4>
			<font color="black">Rows Affected:
				${updatedCuisineRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_cuisines_trans table</font><br>
	</h1>
	<center>
		<form action="./updateTranslatedCuisine.ds" method="post"
			onsubmit="return validate2();">
			<table width="750">
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Cuisine ID:</td>
					<td><input type="text" name="curtcid" id="curtcid"></td>
					<td style="background-color: buttonface;">New Translated
						Cuisine ID:</td>
					<td><input type="text" name="newtcid" id="newtcid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Cuisine ID:</td>
					<td><input type="text" name="curcid2" id="curcid2"></td>
					<td style="background-color: buttonface;">New Cuisine ID:</td>
					<td><input type="text" name="newcid2" id="newcid2"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Locale:</td>
					<td><input type="text" name="curloc" id="curloc"></td>
					<td style="background-color: buttonface;">New Locale:</td>
					<td><input type="text" name="newloc" id="newloc"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Cuisine
						Name:</td>
					<td><input type="text" name="curcname" id="curcname"></td>
					<td style="background-color: buttonface;">New Cuisine Name:</td>
					<td><input type="text" name="newcname" id="newcname"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateAppCuisinesTrans"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewTranslatedCuisinesTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppCuisinesTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="black">Rows Affected:
				${updatedTranslatedCuisineRowsAffected}</font>
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