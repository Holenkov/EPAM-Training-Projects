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

	
	<img src="data:image/jpeg;base64,${avatar}" height="100" width="100" class="rounded-circle img-fluid" />
	<table border="1" cellpadding="5" cellspacing="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Position</th>
			<th>Employee Status</th>
		</tr>
		<tr>
			<td>${employee.firstName}</td>
			<td>${employee.lastName}</td>
			<td>${employee.position.position}</td>
			<td>${employee.employeeStatus.emplStatus}</td>
		</tr>
	</table>
	<br>	
	<c:if test="${loginedUser.employeeID == employee.employeeID}">
		<form method="GET" action="${pageContext.request.contextPath}/employee/edit.html">
			<input type="hidden" name="employeeID" value="${employee.employeeID}" /> 
			<input type="submit" value="Edit">
		</form>
	</c:if>



	<jsp:include page="/WEB-INF/jsp/_footer.jsp"></jsp:include>

</body>
</html>