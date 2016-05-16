<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Locale</title>
<script>
	function goBack() {
		document.forms["GoBack"].submit();
	}
	function goHome() {
		document.forms["GoHome"].submit();
	}
</script>
<style>
body {
	background:
		url(http://photo.elsoar.com/wp-content/images/Spices-and-herbs.-Food-and-cuisine-ingredients.jpg)
		no-repeat;
	background-size: 100%;
}
</style>
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
		<form action="./insertLocale.ds" method="post">
			<table width="230">
				<tr>
					<td style="background-color: buttonface;">Locale ID:</td>
					<td><input type="text" name="lid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Locale:</td>
					<td><input type="text" name="locale"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Language:</td>
					<td><input type="text" name="lang"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertAppLocales" value="INSERT"
				style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppLocalesTable.ds">
			<br> <input type="submit" id="viewAppLocalesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;"> <br>
		</form>
		<h4>
			<font color="red">Rows Affected: ${languageRowsAffected}</font>
		</h4>
		<form id="GoBack" method="post" name="GoBack"
			action="Insert_Operations.jsp">
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