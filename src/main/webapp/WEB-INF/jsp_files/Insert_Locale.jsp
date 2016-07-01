<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Locale</title>
<style>
body {
	background:
		url(http://photo.elsoar.com/wp-content/images/Spices-and-herbs.-Food-and-cuisine-ingredients.jpg)
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
		var locale = document.getElementById("locale");
		var lang = document.getElementById("lang");
		var valid = true;

		if (lid.value.length <= 0 && locale.value.length <= 0) {
			alert("Locale ID and Locale fields must not be empty!");
			valid = false;
		} else if (lid.value.length <= 0) {
			alert("Locale ID field must not be empty!");
			valid = false;
		} else if (locale.value.length <= 0) {
			alert("Locale field must not be empty!");
			valid = false;
		} else if (isNaN(lid.value) && !isNaN(locale.value)) {
			alert("Locale ID field must be filled with numbers and Locale field must be filled with letters!");
			valid = false;
		} else if (!isNaN(lid.value) && !isNaN(locale.vlaue)) {
			alert("Locale field must be filled with letters!");
			valid = false;
		} else if (isNaN(lid.value) && isNaN(locale.value)) {
			alert("Locale ID field must be filled with numbers!");
			valid = false;
		} else if (lid.value.length > 0 && locale.value.length > 0
				&& (isNaN(lang.value) || lang.value.length <= 0)) {
			valid = true;
		} else if (!isNaN(lang.value)) {
			alert("Language field must be filled with letters!")
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
	<br>
	<br>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Insert
			into app_locale table</font><br>
	</h1>
	<center>
		<form action="./insertLocale.ds" method="post"
			onsubmit="return validate();">
			<table width="230">
				<tr>
					<td style="background-color: buttonface;">Locale ID:</td>
					<td><input type="text" name="lid" id="lid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Locale:</td>
					<td><input type="text" name="locale" id="locale"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Language:</td>
					<td><input type="text" name="lang" id="lang"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertAppLocales" value="INSERT"
				style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewLanguagesTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppLocalesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;"> <br>
		</form>
		<h4>
			<font color="red">Rows Affected: ${languageRowsAffected}</font>
		</h4>
		<form id="GoBack" method="post" name="GoBack"
			action="./Insert_Operations.ds">
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