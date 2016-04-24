<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Cuisine</title>
<style>
body {
	background: url(http://hayatevde.com/wp-content/uploads/2014/11/3.jpg)
		no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_cuisines table</font><br>
	</h1>
	<center>
		<form action="./deleteCuisine.ds">
			<table width="250">
				<tr>
					<td style="background-color: buttonface;">Cuisine ID:</td>
					<td><input type="text" name="cid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="deleteAppCuisines" value="DELETE"
				style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppCuisinesTable.ds">
			<br> <input type="submit" id="viewAppCuisinesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;"> <br>
		</form>
	</center>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_cuisines_trans table</font><br>
	</h1>
	<center>
		<form action="./deleteCuisineTrans.ds">
			<table width="300">
				<tr>
					<td style="background-color: buttonface;">Translated Cuisine
						ID:</td>
					<td><input type="text" name="tcid"></td>
				</tr>
			</table>
			<br> <input type="submit" id="deleteAppCuisinesTrans"
				value="DELETE" style="height: 25px; width: 80px; font-size: 15px;">
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