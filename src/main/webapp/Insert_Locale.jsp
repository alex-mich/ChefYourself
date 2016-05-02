<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Locale</title>
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
		<h4>Rows Affected: ${languageRowsAffected}</h4>
		<br> <input type="button" id="backButton" value="BACK"
			style="height: 25px; width: 80px; font-size: 15px;"
			onClick="history.go(-1);return true;">
	</center>
</body>
</html>