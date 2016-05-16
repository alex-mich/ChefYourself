<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Ingredient</title>
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
		url(http://media.al-sharq.com/PortalImages/News/Small/174263_0.jpg)
		no-repeat;
	background-size: 100%;
}
</style>
</head>
<body>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Insert
			into app_ingredients table</font><br>
	</h1>
	<center>
		<form action="./insertIngredient.ds" method="post">
			<table width="280">
				<tr>
					<td style="background-color: buttonface;">Ingredient ID:</td>
					<td><input type="text" name="inid1"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Ingredient Type:</td>
					<td><input type="text" name="itype"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertAppIngredients"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppIngredientsTable.ds">
			<br> <input type="submit" id="viewAppIngredientsTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;"><br>
		</form>
		<h4>
			<font color="white">Rows Affected: ${ingredientRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Insert
			into app_ingredients_trans table</font><br>
	</h1>
	<center>
		<form action="./insertTranslatedIngredient.ds" method="post">
			<table width="320">
				<tr>
					<td style="background-color: buttonface;">Translated
						Ingredient ID:</td>
					<td><input type="text" name="tinid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Ingredient ID:</td>
					<td><input type="text" name="inid2"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Locale:</td>
					<td><input type="text" name="loc"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Ingredient Name:</td>
					<td><input type="text" name="iname"></td>
				</tr>
			</table>
			<br> <input type="submit" id="insertAppIngredientsTrans"
				value="INSERT" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppIngredientsTransTable.ds">
			<br> <input type="submit" id="viewAppIngredientsTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${translatedIngredientRowsAffected}</font>
		</h4>
	</center>
	<form id="GoBack" method="post" name="GoBack"
		action="Insert_Operations.jsp">
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