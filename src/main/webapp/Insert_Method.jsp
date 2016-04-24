<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Method</title>
</head>
<style>
body {
	background:
		url(http://cook-wise.com/wp-content/uploads/parser/italian-food-ingredients-2.jpg)
		no-repeat;
	background-size: 100%;
}
</style>
<body>
	<br>
	<br>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Insert
			into app_methods table</font><br>
	</h1>
	<center>
		<form action="./insertMethod.ds">
			<table width="300">
				<tr>
					<td style="background-color: buttonface;">Method ID:</td>
					<td><input type="text" id="mid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertAppMethods" value="INSERT"
				style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppMethodsTable">
			<br> <input type="submit" id="viewAppMethodsTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;"><br>
		</form>
	</center>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Insert
			into app_methods_trans table</font><br>
	</h1>
	<center>
		<form action="./insertMethodTrans.ds">
			<table width="300">
				<tr>
					<td style="background-color: buttonface;">Translated Method
						ID:</td>
					<td><input type="text" id="tmid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Method ID:</td>
					<td><input type="text" id="mid2"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Locale:</td>
					<td><input type="text" id="loc"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Method Name:</td>
					<td><input type="text" id="mname"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertAppMethodsTrans"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppMethodsTransTable.ds">
			<br> <input type="submit" id="viewAppMethodsTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
	</center>
	<br>
	<center>
		<input type="button" id="backButton" value="BACK"
			style="height: 25px; width: 80px; font-size: 15px;"
			onClick="history.go(-1);return true;">
	</center>
</body>
</html>