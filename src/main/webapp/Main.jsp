<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ChefYourself Web Service</title>
<script>
	function openInsertOperations() {
		document.forms["Main"].submit();
	}

	function openUpdateOperations() {
		document.forms["Main2"].submit();
	}

	function openDeleteOperations() {
		document.forms["Main3"].submit();
	}
</script>
<style>
body {
	background:
		url(http://www.foodnavigator.com/var/plain_site/storage/images/publications/food-beverage-nutrition/foodnavigator.com/science/big-data-exhaustive-review-pulls-together-evidence-on-food-groups-and-diet-related-disease/9537720-1-eng-GB/Big-data-Exhaustive-review-pulls-together-evidence-on-food-groups-and-diet-related-disease.jpg)
		no-repeat;
	background-size: 100%;
}
</style>
</head>
<body>
	<br>
	<br>
	<h1 align="center">
		<br> <font size="30" style="background-color: buttonface;">ChefYourself Database Handling</font>
	</h1>
	<br>
	<h1 align="center">
		<font size="10" style="background-color: buttonface;">Choose Operation:</font>
	</h1>
	<form id="Main" method="post" name="Main"
		action="Insert_Operations.jsp">
		<br>
		<center>
			<br> <input type="submit" id="insert" value="INSERT"
				style="height: 50px; width: 200px; font-size: 30px;"
				onclick="javascript: openInsertOperations()">
		</center>
	</form>
	<form id="Main2" method="post" name="Main2"
		action="Update_Operations.jsp">
		<center>
			<br> <input type="submit" id="update" value="UPDATE"
				style="height: 50px; width: 200px; font-size: 30px;"
				onclick="javascript: openUpdateOperations()">
		</center>
	</form>
	<form id="Main3" method="post" name="Main3"
		action="Delete_Operations.jsp">
		<center>
			<br> <input type="submit" id="delete" value="DELETE"
				style="height: 50px; width: 200px; font-size: 30px;">
		</center>
	</form>
</body>
</html>