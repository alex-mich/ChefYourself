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
			<table width="600">
				<tr>
					<td style="background-color: buttonface;">Current Cuisine ID:</td>
					<td><input type="text" name="curcid1"></td>
					<td style="background-color: buttonface;">New Cuisine ID:</td>
					<td><input type="text" name="newcid1"></td>
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
			<table width="750">
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Cuisine ID:</td>
					<td><input type="text" name="curtcid"></td>
					<td style="background-color: buttonface;">New Translated
						Cuisine ID:</td>
					<td><input type="text" name="newtcid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Cuisine ID:</td>
					<td><input type="text" name="curcid2"></td>
					<td style="background-color: buttonface;">New Cuisine ID:</td>
					<td><input type="text" name="newcid2"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Locale:</td>
					<td><input type="text" name="curloc"></td>
					<td style="background-color: buttonface;">New Locale:</td>
					<td><input type="text" name="newloc"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Cuisine
						Name:</td>
					<td><input type="text" name="curcname"></td>
					<td style="background-color: buttonface;">New Cuisine Name:</td>
					<td><input type="text" name="newcname"></td>
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