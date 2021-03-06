<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang=eng>

<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Electronic Workflow</title>
<script src="login-validation.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/_header.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/jsp/_menu.jsp"></jsp:include>
	<h3>Welcome page</h3>
	
	
    
 
	<c:if test="${empty loginedUser}">
	<p style="color: red;">${errorString}</p>

		<table>
			<tr>
				<td>
					<form action="${pageContext.request.contextPath}/login.html" name ="login" method="POST"  
						onSubmit="return formValidation();">
						<table>
							<tr>
								<td>${langBundle.userName}</td>
								<td><input type="text" name="email" class="form-control"
									value="${loginedUser.email}"  maxlength="255"></td>
							</tr>
							<tr>
								<td>${langBundle.password}</td>
								<td><input type="password" name="password" class="form-control"
									value="${loginedUser.password}"  maxlength="32"></td>
							</tr>
							<tr>
								<td><input type="submit" value="${langBundle.loginBtn}" class="btn btn-primary"></td>

								<td>${langBundle.rememberMe}<input type="checkbox" name="rememberMe" value="Y"></td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
			<tr>
				<td>
					<table>
						<tr>
							<td>${langBundle.notRegistered}</td>
							<td>
								<form action="${pageContext.request.contextPath}/employee/registration.html" method="GET">
									<input type="submit" class="btn btn-primary" value="${langBundle.registrationBtn}">
								</form>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<br>
		Password for all users qwerQWER123.

	</c:if>

	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>