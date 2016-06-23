<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Method</title>
<style>
body {
	background:
		url(http://cook-wise.com/wp-content/uploads/parser/italian-food-ingredients-2.jpg)
		no-repeat;
	background-size: 100%;
}
</style>
<script type="text/javascript">
	function goBack() {
		document.forms["GoBack"].submit();
	}

	function goHome() {
		document.forms["GoHome"].submit();
	}

	function validate() {

		var mid1 = document.getElementById("mid1");
		var valid = true;

		if (mid1.value.length <= 0) {
			alert("Method ID field cannot be empty!");
			valid = false;
		} else if (isNaN(mid1.value)) {
			alert("Method ID field must be filled with numbers!");
			valid = false;
		} else {
			alert("Insertion Completed!");
		}
		return valid;
	};

	function validate2() {

		var tmid = document.getElementById("tmid");
		var mid2 = document.getElementById("mid2");
		var loc = document.getElementById("loc");
		var mname = document.getElementById("mname");
		var valid = true;

		if (tmid.value.length <= 0 && mid2.value.length <= 0
				&& loc.value.length <= 0) {
			alert("Translated Method ID, Method ID and Locale fields must not be empty!");
			valid = false;
		} else if (tmid.value.length <= 0 && mid2.value.length <= 0) {
			alert("Translated Method ID and Method ID fields must not be empty!");
			valid = false;
		} else if (mid2.value.length <= 0 && loc.value.length <= 0) {
			alert("Method ID and Locale fields must not be empty!");
			valid = false;
		} else if (tmid.value.length <= 0 && loc.value.length <= 0) {
			alert("Translated Method ID and Locale fields must not be empty!");
			valid = false;
		} else if (tmid.value.length <= 0) {
			alert("Translated Method ID field must not be empty!");
			valid = false;
		} else if (mid2.value.length <= 0) {
			alert("Method ID field must not be empty!");
			valid = false;
		} else if (loc.value.length <= 0) {
			alert("Locale field must not be empty!");
			valid = false;
		} else if (isNaN(tmid.value) && isNaN(mid2.value) && !isNaN(loc.value)) {
			alert("Translated Method ID and Method ID fields must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (!isNaN(tmid.value) && isNaN(mid2.value) && !isNaN(loc.value)) {
			alert("Method ID field must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (!isNaN(tmid.value) && !isNaN(mid2.value)
				&& !isNaN(loc.value)) {
			alert("Locale field must be filled with valid letters!");
			valid = false;
		} else if (!isNaN(tmid.value) && isNaN(mid2.value) && isNaN(loc.value)) {
			alert("Method ID field must be filled with numbers!");
			valid = false;
		} else if (isNaN(tmid.value) && !isNaN(mid2.value) && isNaN(loc.value)) {
			alert("Translated Method ID field must be filled with numbers!");
			valid = false;
		} else if (isNaN(tmid.value) && isNaN(mid2.value) && isNaN(loc.value)) {
			alert("Translated Method ID and Method ID fields must be filled with numbers!");
			valid = false;
		} else if (isNaN(tmid.value) && !isNaN(mid2.value) && !isNaN(loc.value)) {
			alert("Translated Method ID field must be filled with numbers and Locale field must be filled with valid letters!");
			valid = false;
		} else if (tmid.value.length > 0 && mid2.value.length > 0
				&& loc.value.length > 0
				&& (isNaN(mname.value) || mname.value.length <= 0)) {
			alert("Insertion Completed!");
			valid = true;
		} else if (!isNaN(mname.value)) {
			alert("Method Name field must be filled with letters!");
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
			into app_methods table</font><br>
	</h1>
	<center>
		<form action="./insertMethod.ds" method="post"
			onsubmit="return validate();">
			<table width="300">
				<tr>
					<td style="background-color: buttonface;">Method ID:</td>
					<td><input type="text" name="mid1" id="mid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertAppMethods" value="INSERT"
				style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewMethodsTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppMethodsTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;"><br>
		</form>
		<h4>Rows Affected: ${methodRowsAffected}</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Insert
			into app_methods_trans table</font><br>
	</h1>
	<center>
		<form action="./insertTranslatedMethod.ds" method="post"
			onsubmit="return validate2();">
			<table width="300">
				<tr>
					<td style="background-color: buttonface;">Translated Method
						ID:</td>
					<td><input type="text" name="tmid" id="tmid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Method ID:</td>
					<td><input type="text" name="mid2" id="mid2"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Locale:</td>
					<td><input type="text" name="loc" id="loc"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Method Name:</td>
					<td><input type="text" name="mname" id="mname"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertAppMethodsTrans"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewTranslatedMethodsTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppMethodsTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>Rows Affected: ${translatedMethodRowsAffected}</h4>
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