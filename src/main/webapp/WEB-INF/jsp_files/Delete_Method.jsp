<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Method</title>
<style>
body {
	background:
		url(http://dailystyle.cz/wp-content/uploads/2015/11/ingredients.jpg)
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

		var mid = document.getElementById("mid");
		var valid = true;

		if (mid.value.length <= 0) {
			alert("Method ID field cannot be empty!");
			valid = false;
		} else if (isNaN(mid.value)) {
			alert("Method ID field must be filled with numbers!");
			valid = false;
		}
		return valid;
	};

	function validate2() {

		var tmid = document.getElementById("tmid");
		var valid = true;

		if (tmid.value.length <= 0) {
			alert("Translated Method ID field cannot be empty!");
			valid = false;
		} else if (isNaN(tmid.value)) {
			alert("Translated Method ID field must be filled with numbers!");
			valid = false;
		}
		return valid;
	};
</script>
</head>
<body>
	<br>
	<br>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_methods table</font><br>
	</h1>
	<center>
		<form action="./deleteMethod.ds" method="post"
			onsubmit="return validate();">
			<table width="230">
				<tr>
					<td style="background-color: buttonface;">Method ID:</td>
					<td><input type="text" name="mid" id="mid"></td>
				</tr>
			</table>
			<br> <input type="submit" id="deleteAppMethods" value="DELETE"
				style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewMethodsTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppMethodsTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;"><br>
		</form>
		<h4>
			<font color="black">Rows Affected:
				${deletedMethodRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_methods_trans table</font><br>
	</h1>
	<center>
		<form action="./deleteTranslatedMethod.ds" method="post"
			onsubmit="return validate2();">
			<table width="300">
				<tr>
					<td style="background-color: buttonface;">Translated Method
						ID:</td>
					<td><input type="text" name="tmid" id="tmid"></td>
				</tr>
			</table>
			<br> <input type="submit" id="deleteAppMethodsTrans"
				value="DELETE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewTranslatedMethodsTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppMethodsTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="black">Rows Affected:
				${deletedTranslatedMethodRowsAffected}</font>
		</h4>
	</center>
	<form id="GoBack" method="post" name="GoBack"
		action="./Delete_Operations.ds">
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
</body>
</html>