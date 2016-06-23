<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Locale</title>
<style>
body {
	background: url(http://shaakinternational.com/images/image2.jpg)
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

		var lid = document.getElementById("lid");
		var valid = true;

		if (lid.value.length <= 0) {
			alert("Locale ID field cannot be empty!");
			valid = false;
		} else if (isNaN(lid.value)) {
			alert("Locale ID field must be filled with numbers!");
			valid = false;
		} else {
			alert("Deletion Completed!");
		}
		return valid;
	};
</script>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_locale table</font><br>
	</h1>
	<center>
		<form action="./deleteLocale.ds" method="post"
			onsubmit="return validate();">
			<table width="300">
				<tr>
					<td style="background-color: buttonface;">Locale ID:</td>
					<td><input type="text" name="lid" id="lid"></td>
				</tr>
			</table>
			<br> <input type="submit" id="deleteAppLocale" value="DELETE"
				style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewLanguagesTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppLocalesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;"> <br>
		</form>
		<h4>
			<font color="black">Rows Affected:
				${deletedLanguageRowsAffected}</font>
		</h4>
		<form id="GoBack" method="post" name="GoBack"
			action="./Delete_Operations.ds">
			<input type="button" id="backButton" value="BACK"
				style="height: 25px; width: 80px; font-size: 15px;"
				onClick="javascript: goBack()">
		</form>
		<br>
		<form id="GoHome" method="post" name="GoHome" action="Main.jsp">
			<center>
				<input type="button" id="homeButton" value="HOME"
					style="height: 25px; width: 80px; font-size: 15px;"
					onClick="javascript: goHome()">
			</center>
		</form>
	</center>
</body>
</html>