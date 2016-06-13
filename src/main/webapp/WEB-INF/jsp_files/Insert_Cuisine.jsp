<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Cuisine</title>
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
		url(http://cdn.playbuzz.com/cdn/d7a1e1b6-e240-4379-b722-32e893381e52/55c49549-861a-438a-8a0f-a73e13e5dc42.jpg)
		no-repeat;
	background-size: 100%;
}
</style>
</head>
<body>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Insert
			into app_cuisines table</font><br>
	</h1>
	<center>
		<form action="./insertCuisine.ds" method="post">
			<table width="250">
				<tr>
					<td style="background-color: buttonface;">Cuisine ID:</td>
					<td><input type="text" name="cid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertAppCuisines" value="INSERT"
				style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewCuisinesTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppCuisinesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;"><br>
		</form>
		<h4>Rows Affected: ${cuisineRowsAffected}</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Insert
			into app_cuisines_trans table</font><br>
	</h1>
	<center>
		<form action="./insertTranslatedCuisine.ds" method="post">
			<table width="300">
				<tr>
					<td style="background-color: buttonface;">Translated Cuisine
						ID:</td>
					<td><input type="text" name="tcid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Cuisine ID:</td>
					<td><input type="text" name="cid2"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Locale:</td>
					<td><input type="text" name="loc"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Cuisine Name:</td>
					<td><input type="text" name="cname"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertAppCuisinesTrans"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewTranslatedCuisinesTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppCuisinesTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>Rows Affected: ${translatedCuisineRowsAffected}</h4>
	</center>
	<form id="GoBack" method="post" name="GoBack"
		action="./Insert_Operations.ds">
		<center>
			<input type="button" id="backButton" value="BACK"
				style="height: 25px; width: 80px; font-size: 15px;"
				onClick="javascript: goBack()">
		</center>
	</form>
	<br>
	<form id="GoHome" method="post" name="GoHome" action="Main.jsp">
		<center>
			<input type="button" id="homeButton" value="HOME"
				style="height: 25px; width: 80px; font-size: 15px;"
				onClick="javascript: goHome()">
		</center>
	</form>
	<br>
</body>
</html>