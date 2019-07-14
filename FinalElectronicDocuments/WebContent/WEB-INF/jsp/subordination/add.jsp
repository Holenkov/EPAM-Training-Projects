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

	<jsp:include page="/WEB-INF/jsp/_header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/jsp/_menu.jsp"></jsp:include>

	<p style="color: red;">${errorString}</p>

<!-- request.setAttribute("employees", employees);
			request.setAttribute("docTypes", docTypes); -->

	<form method="POST" name="subordination" 
		action="${pageContext.request.contextPath}/subordination/add.html">
		<table border="1" cellpadding="5" cellspacing="1">
			<tr>
				<th>Sender</th>
				<th>Document</th>
				<th>Receiver</th>
			</tr>

			<tr>
				<td>
				<select id="sender" name="sender" required>
						<c:forEach items="${employees}" var="sender" >
							<option value="${sender.employeeID}">${sender.lastName}, ${sender.position.position}</option>
						</c:forEach>
				</select>
				</td>
				
				<td>
				<select id="docType" name="docType" required>
						<c:forEach items="${docTypes}" var="docType">
							<option value="${docType.docTypeID}">${docType.docType}</option>
						</c:forEach>
				</select>
				</td>
				
				<td>
				<select id="receiver" name="receiver" required>
						<c:forEach items="${employees}" var="receiver">
							<option value="${receiver.employeeID}">${receiver.lastName}, ${receiver.position.position}</option>
						</c:forEach>
				</select>
				</td>
			</tr>
		</table>
		<input type="hidden" name="employeeID" value="${employeeID}" /> 
		<input type="submit" value="Add" />
	</form>

	<form method="GET" 	action="${pageContext.request.contextPath}/subordination/edit.html" >
		<input type="hidden" name="employeeID" value="${employeeID}" /> 
		<input type="submit" value="Cancel" />
	</form>

	<jsp:include page="/WEB-INF/jsp/_footer.jsp"></jsp:include>

</body>

</html>