<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Locale</title>
<style>
body {
	background:
		url(http://www.shiawisdom.com/wp-content/uploads/2015/08/islamic-ingredients.jpg)
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

		var curlid = document.getElementById("curlid");
		var newlid = document.getElementById("newlid");
		var curlocale = document.getElementById("curlocale");
		var newlocale = document.getElementById("newlocale");
		var curlang = document.getElementById("curlang");
		var newlang = document.getElementById("newlang");
		var valid = true;

		if (curlid.value.length <= 0 && curlocale.value.length <= 0
				&& curlang.value.length <= 0 && newlid.value.length <= 0
				&& newlocale.value.length <= 0 && newlang.value.length <= 0) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if ((curlid.value.length > 0 || curlocale.value.length > 0 || curlang.value.length > 0)
				&& (newlid.value.length <= 0 && newlocale.value.length <= 0 && newlang.value.length <= 0)) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if ((newlang.value.length <= 0 && curlocale.value.length <= 0 && curlang.value.length <= 0)
				&& (newlid.value.length > 0 || newlocale.value.length > 0 || newlang.value.length > 0)) {
			alert("You should choose to fill at least one field between the 'current' fields and one between the 'new' fields!");
			valid = false;
		} else if (curlid.value.length > 0 && isNaN(curlid.value)) {
			alert("Current Locale ID must be filled with valid number, please check the table!");
			valid = false;
		} else if (curlocale.value.length > 0 && !isNaN(curlocale.value)) {
			alert("Current Locale field must be filled with valid letters, please check the table!");
			valid = false;
		} else if (curlang.value.length > 0 && !isNaN(curlang.value)) {
			alert("Current Language field must be filled with valid letters, please check the table");
			valid = false;
		} else if (newlid.value.length > 0 && isNaN(newlid.value)) {
			alert("New New Locale ID field must be filled with number!");
			valid = false;
		} else if (newlocale.value.length > 0 && !isNaN(newlocale.value)) {
			alert("New Language field must be filled with letters!");
			valid = false;
		} else if (newlang.value.length > 0 && !isNaN(newlang.value)) {
			alert("New Locale field must be filled with letters!");
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
		<font size="5" style="background-color: buttonface;">Update on
			app_locale table</font><br>
	</h1>
	<center>
		<form action="./updateLocale.ds" method="post"
			onsubmit="return validate();">
			<table width="650">
				<tr>
					<td style="background-color: buttonface;">Current Locale ID:</td>
					<td><input type="text" name="curlid" id="curlid"></td>
					<td style="background-color: buttonface;">New Locale ID:</td>
					<td><input type="text" name="newlid" id="newlid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Locale:</td>
					<td><input type="text" name="curlocale" id="curlocale"></td>
					<td style="background-color: buttonface;">New Locale:</td>
					<td><input type="text" name="newlocale" id="newlocale"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Language:</td>
					<td><input type="text" name="curlang" id="curlang"></td>
					<td style="background-color: buttonface;">New Language:</td>
					<td><input type="text" name="newlang" id="newlang"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateAppLocales" value="UPDATE"
				style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewLanguagesTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppLocalesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;"> <br>
		</form>
		<h4>
			<font color=white>Rows Affected:
				${updatedLanguageRowsAffected}</font>
		</h4>
		<form id="GoBack" method="post" name="GoBack"
			action="./Update_Operations.ds">
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