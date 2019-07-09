<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Electronic Workflow</title>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
	<h3>Welcome page</h3>
	
	
    
 
	<c:if test="${empty loginedUser}">
	<p style="color: red;">${errorString}</p>

		<table>
			<tr>
				<td>
					<form action="${pageContext.request.contextPath}/login.html" method="POST">
						<table>
							<tr>
								<td>User name</td>
								<td><input type="text" name="email"
									value="${loginedUser.email}"></td>
							</tr>
							<tr>
								<td>Password</td>
								<td><input type="password" name="password"
									value="${loginedUser.password}"></td>
							</tr>
							<tr>
								<td><input type="submit" value="Login"></td>

								<td>Remember me <input type="checkbox" name="rememberMe"
									value="Y"></td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
			<tr>
				<td>
					<table>
						<tr>
							<td>Not registered?</td>
							<td>
								<form action="${pageContext.request.contextPath}/registration.html" method="get">
									<input type="submit" value="Registration">
								</form>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

	</c:if>

	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>