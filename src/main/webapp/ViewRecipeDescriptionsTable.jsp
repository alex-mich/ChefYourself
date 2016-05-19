<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${tableName}</title>
<style>
body {
	font-size: 20px;
	color: teal;
	font-family: Calibri;
}

.heading {
	font-size: 18px;
	color: white;
	font: bold;
	background-color: orange;
	border: thick;
}
</style>
</head>
<body>
	<center>
		<h3>
			<b>${tableName}</b>
		</h3>
		<table border="1">
			<tr>
				<td class="heading"
					style="font-size: 15px; color: black; width: 150px; height: 25px; text-align: center;"><h3>${columnName1}</h3></td>
				<td class="heading"
					style="font-size: 15px; color: black; width: 120px; height: 25px; text-align: center;"><h3>${columnName2}</h3></td>
				<td class="heading"
					style="font-size: 15px; color: black; width: 150px; height: 25px; text-align: center;"><h3>${columnName3}</h3></td>
			</tr>
			<c:forEach var="RecipeDescription" items="${recipeDescriptionsList}">
				<tr>
					<td
						style="font-size: 15px; color: black; width: 150px; height: 25px; text-align: center;">${RecipeDescription.rdid}</td>
					<td
						style="font-size: 15px; color: black; width: 120px; height: 25px; text-align: center;">${RecipeDescription.trRecipe.trid}</td>
					<td style="font-size: 15px; color: black; width: 700px; height: 25px; text-align: center;">${RecipeDescription.desc}</td>
				</tr>
			</c:forEach>
		</table>
	</center>
	<br>
</body>
</html>