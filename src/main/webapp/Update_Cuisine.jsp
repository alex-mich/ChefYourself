<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Cuisine</title>
<style>
body {
	background:
		url(http://loveinshallah.files.wordpress.com/2014/04/flm2.jpg)
		no-repeat;
	background-size: 100%;
}
</style>
</head>
<body>
	<br>
	<br>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_cuisines table</font><br>
	</h1>
	<center>
		<form action="./updateCuisine.ds">
			<table width="250">
				<tr>
					<td style="background-color: buttonface;">Cuisine ID:</td>
					<td><input type="text" id="cid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateAppCuisines" value="UPDATE"
				style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppCuisinesTable.ds">
			<br> <input type="submit" id="viewAppCuisinesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;"><br>
		</form>
	</center>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_cuisines_trans table</font><br>
	</h1>
	<center>
		<form action="./updateCuisineTrans.ds">
			<table width="300">
				<tr>
					<td style="background-color: buttonface;">Translated Cuisine
						ID:</td>
					<td><input type="text" id="tcid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Cuisine ID:</td>
					<td><input type="text" id="cid2"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Locale:</td>
					<td><input type="text" id="loc"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Cuisine Name:</td>
					<td><input type="text" id="cname"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateAppCuisinesTrans"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppCuisinesTransTable.ds">
			<br> <input type="submit" id="viewAppCuisinesTransTable"
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