<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choose Cuisine</title>
<style>
body {
	background:
		url(http://thumbs.dreamstime.com/z/food-ingredients-6565035.jpg)
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
		<font size="10" style="background-color: buttonface;">Choose in which cuisine you want to add recipe:</font>
	</h1>
	<form id="Main" method="post" name="Main"
		action="Insert_Global_Recipe.jsp">
		<br> <br>
		<center>
			<br> <input type="submit" id="globalCuisine" value="GLOBAL"
				style="height: 50px; width: 200px; font-size: 30px;">
		</center>
	</form>
	<form id="Main2" method="post" name="Main2"
		action="Insert_Greek_Recipe.jsp">
		<center>
			<br> <input type="submit" id="greekCuisine" value="GREEK"
				style="height: 50px; width: 200px; font-size: 30px;">
		</center>
	</form>
	<form id="Main3" method="post" name="Main3"
		action="Insert_Spanish_Recipe.jsp">
		<center>
			<br> <input type="submit" id="spanishCuisine" value="SPANISH"
				style="height: 50px; width: 200px; font-size: 30px;">
		</center>
	</form>
	<center>
		<br> <input type="button" id="backButton" value="BACK"
			style="height: 50px; width: 200px; font-size: 30px;"
			onClick="history.go(-1);return true;">
	</center>
</body>
</html>