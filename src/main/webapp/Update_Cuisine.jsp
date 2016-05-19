<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Cuisine</title>
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
		url(http://loveinshallah.files.wordpress.com/2014/04/flm2.jpg)
		no-repeat;
	background-size: 100%;
}
</style>
</head>
<body>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_cuisines table</font><br>
	</h1>
	<center>
		<form action="./updateCuisine.ds" method="post">
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
		<form action="./viewCuisinesTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppCuisinesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;"><br>
		</form>
		<h4>
			<font color="black">Rows Affected:
				${updatedCuisineRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_cuisines_trans table</font><br>
	</h1>
	<center>
		<form action="./updateTranslatedCuisine.ds" method="post">
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
		<form action="./viewAppCuisinesTransTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppCuisinesTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="black">Rows Affected:
				${updatedTranslatedCuisineRowsAffected}</font>
		</h4>
	</center>
	<form id="GoBack" method="post" name="GoBack"
		action="Update_Operations.jsp">
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