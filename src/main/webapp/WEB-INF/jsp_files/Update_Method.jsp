<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Method</title>
<style>
body {
	background:
		url(http://www.eonline.com/eol_images/Entire_Site/2014231/rs_560x415-140331104353-1024.cooking-tips-seasonings.jpg)
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

		var curmid1 = document.getElementById("curmid1");
		var newmid1 = document.getElementById("newmid1");
		var valid = true;

		if (curmid1.value.length <= 0 && newmid1.value.length <= 0) {
			alert("Current Method ID and New Method ID fields cannot be empty!");
			valid = false;
		} else if (curmid1.value.length <= 0 && newmid1.value.length > 0) {
			alert("Current Method ID field cannot be empty!");
			valid = false;
		} else if (curmid1.value.length > 0 && newmid1.value.length <= 0) {
			alert("New Method ID field cannot be empty!");
			valid = false;
		} else if (isNaN(curmid1.value) && isNaN(newmid1.value)) {
			alert("Current Method ID and New Method ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(curmid1.value) && !isNaN(newmid1.value)) {
			alert("Current Method ID field must be filled with numbers!");
			valid = false;
		} else if (!isNaN(curmid1.value) && isNaN(newmid1.value)) {
			alert("New Method ID field must be filled with numbers!");
			valid = false;
		} 
		return valid;
	};
	
	function validate2(){
		
		var curtmid = document.getElementById("curtmid");
		var curmid2 = document.getElementById("curmid2");
		var curloc = document.getElementById("curloc");
		var curmname = document.getElementById("curmname");
		var newtmid = document.getElementById("newtmid");
		var newmid2 = document.getElementById("newmid2");
		var newloc = document.getElementById("newloc");
		var newmname = document.getElementById("newmname");
		var valid = true;
		
	if (curtmid.value.length <= 0 && curmid2.value.length <= 0 && curloc.value.length <= 0 
			&& curmname.value.length <= 0 && newtmid.value.length <= 0 && newmid2.value.length <= 0 
			&& newloc.value.length <= 0 && newmname.value.length <= 0) {
		alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
		valid = false;
	} else if ((curtmid.value.length > 0 || curmid2.value.length > 0 || curloc.value.length > 0 
			|| curmname.value.length > 0)
			&& (newtmid.value.length <= 0 && newmid2.value.length <= 0 && newloc.value.length <= 0 
			&& newmname.value.length <= 0)) {
		alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
		valid = false;
	} else if ((curtmid.value.length <= 0 && curmid2.value.length <= 0 && curloc.value.length <= 0 
			&& curmname.value.length <= 0) 
			&& (newtmid.value.length > 0 || newmid2.value.length > 0 || newloc.value.length > 0 
			|| newmname.value.length > 0)) {
		alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
		valid = false;
	} else if (curtmid.value.length > 0 && isNaN(curtmid.value)){
		alert("Current Translated Method ID must be filled with valid number, please check the table!");
		valid = false;
	} else if (curmid2.value.length > 0 && isNaN(curmid2.value)){
		alert("Current Method ID field must be filled with valid number, please check the table!");
		valid = false;
	} else if (curloc.value.length > 0 && !isNaN(curloc.value)){
		alert("Current Locale field must be filled with valid letters, please check the table");
		valid = false;
	} else if (curmname.value.length > 0 && !isNaN(curmname.value)){
		alert("Current Method Name must be filled with valid letters, please check the table!");
		valid = false;
	} else if (newtmid.value.length > 0 && isNaN(newtmid.value)){
		alert("New Translated Method ID field must be filled with number!");
		valid = false;
	} else if (newmid2.value.length > 0 && isNaN(newmid2.value)){
		alert("New Method ID field must be filled with number!");
		valid = false;
	} else if (newloc.value.length > 0 && !isNaN(newloc.value)){
		alert("New Locale field must be filled with letters!");
		valid = false;
	} else if (newmname.value.length > 0 && !isNaN(newmname.value)){
		alert("New Method Name field must be filled with letters!");
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
			app_methods table</font><br>
	</h1>
	<center>
		<form action="./updateMethod.ds" method="post"
			onsubmit="return validate();">
			<table width="600">
				<tr>
					<td style="background-color: buttonface;">Current Method ID:</td>
					<td><input type="text" name="curmid1" id="curmid1"></td>
					<td style="background-color: buttonface;">New Method ID:</td>
					<td><input type="text" name="newmid1" id="newmid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateAppMethods" value="UPDATE"
				style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewMethodsTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppSpanishMethodsTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;"><br>
		</form>
		<h4>
			<font color=black>Rows Affected: ${updatedMethodRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_methods_trans table</font><br>
	</h1>
	<center>
		<form action="./updateTranslatedMethod.ds" method="post"
			onsubmit="return validate2();">
			<table width="750">
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Method ID:</td>
					<td><input type="text" name="curtmid" id="curtmid"></td>
					<td style="background-color: buttonface;">New Translated
						Method ID:</td>
					<td><input type="text" name="newtmid" id="newtmid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Method ID:</td>
					<td><input type="text" name="curmid2" id="curmid2"></td>
					<td style="background-color: buttonface;">New Method ID:</td>
					<td><input type="text" name="newmid2" id="newmid2"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Locale:</td>
					<td><input type="text" name="curloc" id="curloc"></td>
					<td style="background-color: buttonface;">New Locale:</td>
					<td><input type="text" name="newloc" id="newloc"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Method Name:</td>
					<td><input type="text" name="curmname" id="curmname"></td>
					<td style="background-color: buttonface;">New Method Name:</td>
					<td><input type="text" name="newmname" id="newmname"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateAppMethodsTrans"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewTranslatedMethodsTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppMethodsTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="black">Rows Affected:
				${updatedTranslatedMethodRowsAffected}</font>
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