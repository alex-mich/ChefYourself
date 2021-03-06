<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Cuisine</title>
<style>
body {
	background: url(http://hayatevde.com/wp-content/uploads/2014/11/3.jpg)
		no-repeat;
	background-size: cover;
}
</style>
<script>
	function goBack() {
		document.forms["GoBack"].submit();
	}

	function goHome() {
		document.forms["GoHome"].submit();
	}

	function validate() {

		var cid = document.getElementById("cid");
		var valid = true;

		if (cid.value.length <= 0) {
			alert("Cusine ID field cannot be empty!");
			valid = false;
		} else if (isNaN(cid.value)) {
			alert("Cuisine ID field must be filled with numbers!");
			valid = false;
		}
		return valid;
	};

	function validate2() {

		var tcid = document.getElementById("tcid");
		var valid = true;

		if (tcid.value.length <= 0) {
			alert("Translated Cusine ID field cannot be empty!");
			valid = false;
		} else if (isNaN(tcid.value)) {
			alert("Translated Cuisine ID field must be filled with numbers!");
			valid = false;
		}
		return valid;
	};
</script>
</head>
<body>
	<br>
	<br>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_cuisines table</font><br>
	</h1>
	<center>
		<form action="./deleteCuisine.ds" method="post"
			onsubmit="return validate();">
			<table width="250">
				<tr>
					<td style="background-color: buttonface;">Cuisine ID:</td>
					<td><input type="text" name="cid" id="cid"></td>
				</tr>
			</table>
			<br> <input type="submit" id="deleteAppCuisines" value="DELETE"
				style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewCuisinesTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppCuisinesTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;"> <br>
		</form>
		<h4>
			<font color="white">Rows Affected:
				${deletedCuisineRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Delete
			from app_cuisines_trans table</font><br>
	</h1>
	<center>
		<form action="./deleteTranslatedCuisine.ds" method="post"
			onsubmit="return validate2();">
			<table width="300">
				<tr>
					<td style="background-color: buttonface;">Translated Cuisine
						ID:</td>
					<td><input type="text" name="tcid" id="tcid"></td>
				</tr>
			</table>
			<br> <input type="submit" id="deleteAppCuisinesTrans"
				value="DELETE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewTranslatedCuisinesTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppCuisinesTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="white">Rows Affected:
				${deletedTranslatedCuisineRowsAffected}</font>
		</h4>
	</center>
	<form id="GoBack" method="post" name="GoBack"
		action="./Delete_Operations.ds">
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
</body>
</html>