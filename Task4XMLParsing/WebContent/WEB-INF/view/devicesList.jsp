<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>
</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>

	<p style="color: red;">${errorString}</p>

	<table border="1" cellpadding="5" cellspacing="1">
		<tr>


			<th>Name</th>
			<th>Origin</th>
			<th>Date of Issue</th>
			<th>Price</th>
			<th>Types</th>
			<th>Is critical for Use?</th>
			<th>Other parameters</th>


		</tr>

		<c:forEach items="${devices}" var="device">
			<tr>
				<td>${device.name}</td>
				<td>${device.origin}</td>
				<td>${device.dateOfIssue}</td>
				<td>${device.price}</td>
				<td>${device.critical}</td>
			</tr>
		</c:forEach>
	</table>


	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>