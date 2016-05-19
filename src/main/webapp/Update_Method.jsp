<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Method</title>
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
		url(http://www.eonline.com/eol_images/Entire_Site/2014231/rs_560x415-140331104353-1024.cooking-tips-seasonings.jpg)
		no-repeat;
	background-size: 100%;
}
</style>
</head>
<body>
	<br>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_methods table</font><br>
	</h1>
	<center>
		<form action="./updateMethod.ds" method="post">
			<table width="600">
				<tr>
					<td style="background-color: buttonface;">Current Method ID:</td>
					<td><input type="text" name="curmid1"></td>
					<td style="background-color: buttonface;">New Method ID:</td>
					<td><input type="text" name="newmid1"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateAppMethods" value="UPDATE"
				style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewMethodsTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppSpanishMethodsTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;"><br>
		</form>
		<h4>
			<font color=black>Rows Affected: ${updatedMethodRowsAffected}</font>
		</h4>
	</center>
	<h1 align="center">
		<font size="5" style="background-color: buttonface;">Update on
			app_methods_trans table</font><br>
	</h1>
	<center>
		<form action="./updateTranslatedMethod.ds" method="post">
			<table width="750">
				<tr>
					<td style="background-color: buttonface;">Current Translated
						Method ID:</td>
					<td><input type="text" name="curtmid"></td>
					<td style="background-color: buttonface;">New Translated
						Method ID:</td>
					<td><input type="text" name="newtmid"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Method ID:</td>
					<td><input type="text" name="curmid2"></td>
					<td style="background-color: buttonface;">New Method ID:</td>
					<td><input type="text" name="newmid2"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Locale:</td>
					<td><input type="text" name="curloc"></td>
					<td style="background-color: buttonface;">New Locale:</td>
					<td><input type="text" name="newloc"></td>
				</tr>
				<tr>
					<td style="background-color: buttonface;">Current Method Name:</td>
					<td><input type="text" name="curmname"></td>
					<td style="background-color: buttonface;">New Method Name:</td>
					<td><input type="text" name="newmname"></td>
				</tr>
			</table>
			<br> <input type="submit" id="updateAppMethodsTrans"
				value="UPDATE" style="height: 25px; width: 80px; font-size: 15px;">
		</form>
		<form action="./viewAppMethodsTransTable.ds" target="_blank">
			<br> <input type="submit" id="viewAppMethodsTransTable"
				value="VIEW TABLE"
				style="height: 25px; width: 100px; font-size: 15px;">
		</form>
		<h4>
			<font color="black">Rows Affected:
				${updatedTranslatedMethodRowsAffected}</font>
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