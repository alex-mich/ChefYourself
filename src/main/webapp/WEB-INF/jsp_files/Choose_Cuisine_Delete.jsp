<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Choose Cuisine</title>
<script>
	function goBack() {
		document.forms["GoBack"].submit();
	}
</script>
<style>
body {
	background:
		url(http://www.viva.org.uk/sites/default/files/images/Food_ingredients_top_down.jpg)
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
		<font size="10" style="background-color: buttonface;">Choose
			from which cuisine you want to delete recipe:</font>
	</h1>
	<form id="Main" method="post" name="Main"
		action="./Delete_Global_Recipe.ds">
		<br> <br>
		<center>
			<br> <input type="submit" id="globalCuisine" value="GLOBAL"
				style="height: 50px; width: 200px; font-size: 30px;">
		</center>
	</form>
	<form id="Main2" method="post" name="Main2"
		action="./Delete_Greek_Recipe.ds">
		<center>
			<br> <input type="submit" id="greekCuisine" value="GREEK"
				style="height: 50px; width: 200px; font-size: 30px;">
		</center>
	</form>
	<form id="Main3" method="post" name="Main3"
		action="./Delete_Spanish_Recipe.ds">
		<center>
			<br> <input type="submit" id="spanishCuisine" value="SPANISH"
				style="height: 50px; width: 200px; font-size: 30px;">
		</center>
	</form>
	<form id="GoBack" method="post" name="GoBack"
		action="./Delete_Operations.ds">
		<center>
			<br> <input type="button" id="backButton" value="BACK"
				style="height: 50px; width: 200px; font-size: 30px;"
				onClick="javascript: goBack()">
		</center>
	</form>
</body>
</html>