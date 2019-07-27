<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang=eng>

<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Employee List</title>
</head>
<body>

	<jsp:include page="/WEB-INF/jsp/_header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/jsp/_menu.jsp"></jsp:include>

	<p style="color: red;">${errorString}</p>
	<h2>Are you sure to delete subordination?</h2>



	<table border="1" cellpadding="5" cellspacing="1">
		<tr>
			<th>Sub ID</th>
			<th>Sender</th>
			<th>Document</th>
			<th>Receiver</th>
		</tr>

		<tr>
			<td>${sub.id}</td>
			<td>${sub.sender.lastName},${sub.sender.position.position}</td>
			<td>${sub.docType.docType}</td>
			<td>${sub.receiver.lastName},${sub.receiver.position.position}</td>
		</tr>
	</table>
	<form method="POST"
		action="${pageContext.request.contextPath}/subordination/delete.html">
		<input type="hidden" name="subID" value="${sub.id}" /> <input
			type="hidden" name="employeeID" value="${employeeID}" /> <input
			type="submit" value="Delete">
	</form>

	<form method="GET"
		action="${pageContext.request.contextPath}/subordination/edit.html">
		<input type="hidden" name="employeeID" value="${employeeID}" /> <input
			type="submit" value="Cancel">
	</form>


	<jsp:include page="/WEB-INF/jsp/_footer.jsp"></jsp:include>

</body>
</html>