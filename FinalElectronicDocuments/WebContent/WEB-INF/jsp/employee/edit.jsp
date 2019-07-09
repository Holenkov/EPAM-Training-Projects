<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Employee</title>
</head>
<body>

	 <jsp:include page="/WEB-INF/jsp/_header.jsp"></jsp:include>
	 <jsp:include page="/WEB-INF/jsp/_menu.jsp"></jsp:include>

	<h3>Edit Employee</h3>

	<p style="color: red;">${errorString}</p>

	<c:if test="${not empty employee}">
		<form method="POST" action="${pageContext.request.contextPath}/editEmployee">

			<table border="1" cellpadding="5" cellspacing="1">
				<tr>
					<th>Employee ID</th>
					<th>e-mail</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Position</th>
					<th>Role</th>
					<th>Employee Status</th>
				</tr>

				<tr>
					<td><input type="hidden" name="employeeID" value="${employee.employeeID}" />${employee.employeeID}</td>
					<td>${employee.email}</td>
					<td><input type="text" name="firstName" value="${employee.firstName}" /></td>
					<td><input type="text" name="lastName" value="${employee.lastName}" /></td>

					<td>
							<select id="pos" name = "pos">
								<option value="${employee.position.positionID}" selected="${employee.position.positionID}" >${employee.position.position}</option>
								<c:forEach items="${emplPositions}" var="position1">
								<option value="${position1.positionID}">${position1.position}</option>
								</c:forEach>
							</select>

					</td>
					<td>
							<select id="rol" name = "rol">
								<option value="${employee.role.role.id}" selected="${employee.role.role.name}">${employee.role.role.name}</option>
								<c:forEach items="${userRoles}" var="role1">
							<%-- 	<option value="${role1.roleID}">${role1.name}</option> --%>
							<option value="${role1.id}">${role1.name}</option>
								</c:forEach>
								
							</select>
					</td>		
					<td>
							<select id="stat" name = "stat">
								<option value="${employee.employeeStatus.emplStatusID}" selected="${employee.employeeStatus.emplStatusID}">${employee.employeeStatus.emplStatus}</option>
								<c:forEach items="${emplStatuses}" var="status1">
								<option value="${status1.emplStatusID}">${status1.emplStatus}</option>
								</c:forEach>
								
							</select>
					</td>		
				</tr>
			</table><br>
			
		



			<input type="submit" value="Submit" /> <br>
		</form>
		 <form method="GET" action="${pageContext.request.contextPath}/employees">
          	<input type="submit" value="Cancel">
         </form>  
	</c:if>

	<jsp:include page="/WEB-INF/jsp/_footer.jsp"></jsp:include>

</body>
</html>