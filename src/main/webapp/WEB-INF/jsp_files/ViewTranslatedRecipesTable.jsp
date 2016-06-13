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

td {
	font-size: 15px;
	color: black;
	width: 150px;
	height: 25px;
	text-align: center;
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
				<td class="heading"><h3>${columnName1}</h3></td>
				<td class="heading"><h3>${columnName2}</h3></td>
				<td class="heading"><h3>${columnName3}</h3></td>
				<td class="heading"><h3>${columnName4}</h3></td>
				<td class="heading"><h3>${columnName5}</h3></td>
				<td class="heading"><h3>${columnName6}</h3></td>
			</tr>
			<c:forEach var="translatedRecipe" items="${translatedRecipeList}">
				<tr>
					<td>${translatedRecipe.trid}</td>
					<td>${translatedRecipe.recipe.rid}</td>
					<td>${translatedRecipe.transCuisine.tcid}</td>
					<td>${translatedRecipe.transMethod.tmid}</td>
					<td>${translatedRecipe.locale.loc}</td>
					<td>${translatedRecipe.rname}</td>
				</tr>
			</c:forEach>
		</table>
	</center>
	<br>
</body>
</html>