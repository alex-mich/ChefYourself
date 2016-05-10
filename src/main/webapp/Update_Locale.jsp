<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Locale</title>
<style>
body {
	background:
		url(http://www.shiawisdom.com/wp-content/uploads/2015/08/islamic-ingredients.jpg)
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
		<font size="5" style="background-color: buttonface;">Update on
			app_locale table</font><br>
	</h1>
	<center>
		<form action="./updateLocale.ds">
			<table width="650">
				<tr>
					<td style="background-color: buttonface;">Curent Locale ID:</td>
					<td><input type="text" name="curlid"></td>
					<td style="background-color: buttonface;">New Locale ID:</td>
					<td><input type="text" name="newlid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Curent Locale:</td>
					<td><input type="text" name="curlocale"></td>
					<td style="background-color: buttonface;">New Locale:</td>
					<td><input type="text" name="newlocale"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Curent Language:</td>
					<td><input type="text" name="curlang"></td>
					<td style="background-color: buttonface;">New Language:</td>
					<td><input type="text" name="newlang"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateAppLocales" value="UPDATE"
				style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppLocalesTable.ds">
			<br> <input type="submit" id="viewAppLocalesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;"> <br>
		</form>
		<br> <input type="button" id="backButton" value="BACK"
			style="height: 25px; width: 80px; font-size: 15px;"
			onClick="history.go(-1);return true;">
	</center>
</body>
</html>