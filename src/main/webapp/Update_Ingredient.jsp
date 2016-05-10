<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Ingredient</title>
<style>
body {
	background:
		url(http://sladephoto.com/wp-content/uploads/2013/02/Food-Meatloaf-Ingredients-Slade-Photo1.jpg)
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
			app_ingredients table</font><br>
	</h1>
	<center>
		<form action="./updateIngredient.ds">
			<table width="650">
				<tr>
					<td style="background-color: buttonface;">Curent Ingredient
						ID:</td>
					<td><input type="text" name="curinid1"></td>
					<td style="background-color: buttonface;">New Ingredient ID:</td>
					<td><input type="text" name="newinid1"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Curent Ingredient
						Type:</td>
					<td><input type="text" name="curitype"></td>
					<td style="background-color: buttonface;">New Ingredient Type:</td>
					<td><input type="text" name="newitype"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateAppIngredients"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppIngredientsTable.ds">
			<br> <input type="submit" id="viewAppIngredientsTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;"><br>
		</form>
	</center>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_ingredients_trans table</font><br>
	</h1>
	<center>
		<form action="./updateIngredientTrans.ds">
			<table width="750">
				<tr>
					<td style="background-color: buttonface;">Curent Translated
						Ingredient ID:</td>
					<td><input type="text" name="curtinid"></td>
					<td style="background-color: buttonface;">New Translated
						Ingredient ID:</td>
					<td><input type="text" name="newtinid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Curent Ingredient
						ID:</td>
					<td><input type="text" name="curinid2"></td>
					<td style="background-color: buttonface;">New Ingredient ID:</td>
					<td><input type="text" name="newinid2"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Curent Locale:</td>
					<td><input type="text" name="curloc"></td>
					<td style="background-color: buttonface;">New Locale:</td>
					<td><input type="text" name="newloc"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Curent Ingredient
						Name:</td>
					<td><input type="text" name="curiname"></td>
					<td style="background-color: buttonface;">New Ingredient Name:</td>
					<td><input type="text" name="newiname"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateAppIngredientsTrans"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppIngredientsTransTable.ds">
			<br> <input type="submit" id="viewAppIngredientsTransTable"
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