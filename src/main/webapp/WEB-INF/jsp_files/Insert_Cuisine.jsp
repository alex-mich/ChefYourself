<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Cuisine</title>
<script type="text/javascript">
	function goBack() {
		document.forms["GoBack"].submit();
	}

	function goHome() {
		document.forms["GoHome"].submit();
	}

	function validate() {

		var cid1 = document.getElementById("cid1");
		var valid = true;

		if (cid1.value.length <= 0) {
			alert("Cusine ID field cannot be empty!");
			valid = false;
		} else if (isNaN(cid1.value)) {
			alert("Cuisine ID field must be filled with numbers!");
			valid = false;
		}
		return valid;
	};

	function validate2() {

		var tcid = document.getElementById("tcid");
		var cid2 = document.getElementById("cid2");
		var loc = document.getElementById("loc");
		var cname = document.getElementById("cname");
		var valid = true;

		if (tcid.value.length <= 0 && cid2.value.length <= 0 && loc.value.length <= 0) {
			alert("Translated Cusine ID, Cusine ID and Locale fields must not be empty!");
			valid = false;
		} else if (tcid.value.length <= 0 && cid2.value.length <= 0) {
			alert("Translated Cusine ID and Cusine ID fields must not be empty!");
			valid = false;
		} else if (cid2.value.length <= 0 && loc.value.length <= 0) {
			alert("Cusine ID and Locale fields must not be empty!");
			valid = false;
		} else if (tcid.value.length <= 0 && loc.value.length <= 0) {
			alert("Translated Cusine ID and Locale fields must not be empty!");
			valid = false;
		} else if (tcid.value.length <= 0) {
			alert("Translated Cusine ID field must not be empty!");
			valid = false;
		} else if (cid2.value.length <= 0) {
			alert("Cusine ID field must not be empty!");
			valid = false;
		} else if (loc.value.length <= 0) {
			alert("Locale field must not be empty!");
			valid = false;
		} else if (isNaN(tcid.value) && isNaN(cid2.value) && !isNaN(loc.value)) {
			alert("Translated Cusine ID and Cusine ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (!isNaN(tcid.value) && isNaN(cid2.value) && !isNaN(loc.value)) {
			alert("Cusine ID field must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (!isNaN(tcid.value) && !isNaN(cid2.value) && !isNaN(loc.value)) {
			alert("Locale field must be filled with lvalid etters!");
			valid = false;
		} else if (!isNaN(tcid.value) && isNaN(cid2.value) && isNaN(loc.value)) {
			alert("Cusine ID field must be filled with numbers!");
			valid = false;
		} else if (isNaN(tcid.value) && !isNaN(cid2.value) && isNaN(loc.value)) {
			alert("Translated Cusine ID field must be filled with numbers!");
			valid = false;
		} else if (isNaN(tcid.value) && isNaN(cid2.value) && isNaN(loc.value)) {
			alert("Translated Cusine ID and Cusine ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(tcid.value) && !isNaN(cid2.value) && !isNaN(loc.value)) {
			alert("Translated Cusine ID field must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if ((tcid.value.length > 0 && cid2.value.length > 0 && loc.value.length > 0)
				&& (isNaN(cname.vlaue) || cname.value.length <= 0)) {
			valid = true;
		} else if (!isNaN(cname.value)) {
			alert("Cuisine Name field must be filled with letters!");
			valid = false;
		}
		return valid;
	};
</script>
<style>
body {
	background:
		url(http://cdn.playbuzz.com/cdn/d7a1e1b6-e240-4379-b722-32e893381e52/55c49549-861a-438a-8a0f-a73e13e5dc42.jpg)
		no-repeat;
	background-size: 100%;
}
</style>
</head>
<body>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Insert
			into app_cuisines table</font><br>
	</h1>
	<center>
		<form action="./insertCuisine.ds" method="post"
			onsubmit="return validate();">
			<table width="250">
				<tr>
					<td style="background-color: buttonface;">Cuisine ID:</td>
					<td><input type="text" name="cid1" id="cid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertAppCuisines" value="INSERT"
				style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewCuisinesTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppCuisinesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;"><br>
		</form>
		<h4>Rows Affected: ${cuisineRowsAffected}</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Insert
			into app_cuisines_trans table</font><br>
	</h1>
	<center>
		<form action="./insertTranslatedCuisine.ds" method="post"
			onsubmit="return validate2();">
			<table width="300">
				<tr>
					<td style="background-color: buttonface;">Translated Cuisine
						ID:</td>
					<td><input type="text" name="tcid" id="tcid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Cuisine ID:</td>
					<td><input type="text" name="cid2" id="cid2"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Locale:</td>
					<td><input type="text" name="loc" id="loc"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Cuisine Name:</td>
					<td><input type="text" name="cname" id="cname"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertAppCuisinesTrans"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewTranslatedCuisinesTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppCuisinesTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>Rows Affected: ${translatedCuisineRowsAffected}</h4>
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