<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Ingredient</title>
<style>
body {
	background:
		url(http://media.al-sharq.com/PortalImages/News/Small/174263_0.jpg)
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
		<font size="5" style="background-color: buttonface;">Insert into app_ingredients table</font><br>
	</h1>
	<center>
		<table width="280">
			<tr>
				<td style="background-color: buttonface;">Ingredient ID:</td>
				<td><input type="text" id="inid1"></td>
			</tr>
			<tr>
				<td style="background-color: buttonface;">Ingredient Type:</td>
				<td><input type="text" id="itype"></td>
			</tr>
		</table>
		<br> <input type="submit" id="insertAppIngredients"
			value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		<input type="submit" id="viewAppIngredientsTable" value="VIEW TABLE"
			style="height: 25px; width: 100px; font-size: 15px;"><br>
		<br>
		<h1 align="center">
			<font size="5" style="background-color: buttonface;">Insert into app_ingredients_trans table</font><br>
		</h1>
		<table width="320">
			<tr>
				<td style="background-color: buttonface;">Translated Ingredient ID:</td>
				<td><input type="text" id="tinid"></td>
			</tr>
			<tr>
				<td style="background-color: buttonface;">Ingredient ID:</td>
				<td><input type="text" id="inid2"></td>
			</tr>
			<tr>
				<td style="background-color: buttonface;">Locale:</td>
				<td><input type="text" id="loc"></td>
			</tr>
			<tr>
				<td style="background-color: buttonface;">Ingredient Name:</td>
				<td><input type="text" id="iname"></td>
			</tr>
		</table>
		<br> <input type="submit" id="insertAppIngredientsTrans"
			value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		<input type="submit" id="viewAppIngredientsTransTable"
			value="VIEW TABLE"
			style="height: 25px; width: 100px; font-size: 15px;"> <br>
		<br> <input type="button" id="backButton" value="BACK"
			style="height: 25px; width: 80px; font-size: 15px;"
			onClick="history.go(-1);return true;">
	</center>
</body>
</html>