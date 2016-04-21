<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Method</title>
<style>
body {
	background:
		url(http://dailystyle.cz/wp-content/uploads/2015/11/ingredients.jpg)
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
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete from app_methods table</font><br>
	</h1>
	<center>
		<table width="230">
			<tr>
				<td style="background-color: buttonface;">Method ID:</td>
				<td><input type="text" id="mid1"></td>
			</tr>
		</table>
		<br> <input type="submit" id="deleteAppMethods" value="DELETE"
			style="height: 25px; width: 80px; font-size: 15px;"> <input
			type="submit" id="viewAppMethodsTable" value="VIEW TABLE"
			style="height: 25px; width: 100px; font-size: 15px;"><br>
		<br>
		<h1 align="center">
			<font size="5" style="background-color: buttonface;">Delete from app_methods_trans table</font><br>
		</h1>
		<table width="300">
			<tr>
				<td style="background-color: buttonface;">Translated Method ID:</td>
				<td><input type="text" id="tmid"></td>
			</tr>
		</table>
		<br> <input type="submit" id="deleteAppMethodsTrans"
			value="DELETE" style="height: 25px; width: 80px; font-size: 15px;">
		<input type="submit" id="viewAppMethodsTransTable" value="VIEW TABLE"
			style="height: 25px; width: 100px; font-size: 15px;"> <br>
		<br> <input type="button" id="backButton" value="BACK"
			style="height: 25px; width: 80px; font-size: 15px;"
			onClick="history.go(-1);return true;">
	</center>
</body>
</html>