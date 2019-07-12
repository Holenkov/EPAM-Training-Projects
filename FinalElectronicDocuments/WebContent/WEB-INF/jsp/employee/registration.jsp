<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>


<body>
	<jsp:include page="/WEB-INF/jsp/_header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/jsp/_menu.jsp"></jsp:include>
	<h1 style="color: red;">${msg}</h1>
	<h3>Registration Form</h3>

	<p style="color: red;">${errorString}</p>


	<form
		action="${pageContext.request.contextPath}/employee/registration.html"
		method="POST" name="registration" enctype="multipart/form-data"
		onsubmit="return formValidation();">

		<table border="0">
			<tr>
				<td>Select avatar.</td>
				<td><input name="avatar" type="file"></td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td><input type="text" name="email" value="${employee.email}" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password1" /></td>
			</tr>
			<tr>
				<td>Repeat Password</td>
				<td><input type="password" name="password2" /></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName"
					value="${employee.firstName}" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName"
					value="${employee.lastName}" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>


	<jsp:include page="/WEB-INF/jsp/_footer.jsp"></jsp:include>

</body>

<script>
	function formValidation() {
		file = document.forms["registration"]["avatar"].value.toUpperCase();
		email = document.forms["registration"]["email"].value;
		password1 = document.forms["registration"]["password1"].value;
		password2 = document.forms["registration"]["password2"].value;
		firstName = document.forms["registration"]["firstName"].value;
		lastName = document.forms["registration"]["lastName"].value;
		
		if (validateFile(file) == false) {
			return false;
		}
		if (validateEmail(email) == false) {
			return false;
		}
		if (validatePassword(password1, password2) == false) {
			return false;
		}	
		if (validateFirstName(firstName) == false) {
			return false;
		}
		if (validateLastName(lastName) == false) {
			return false;
		}
		return true;
	}
	
	function validateFile(file) {
		suffix1 = ".JPG";
		suffix2 = ".JPEG";
		if (file.indexOf(suffix1, file.length - suffix1.length) == -1
				&& file.indexOf(suffix2, file.length - suffix2.length) == -1) {
			alert('File type not allowed,\nAllowed file: *.jpg,*.jpeg');
			return false;
		}
		return true;
	}
	
	function validatePassword(password1, password2) {
		alert(password1);
		if (password1 != password2) {
			alert("Password 1 not equals Password 2");
			return false;
		}
		var reg = (/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$/);
		if (!reg.test(String(password1))) {
			alert("Password too simple. 8 and more symbols, digits, upper-lower case.");
			return false;
		}
		return true;
	}
	
	function validateEmail(email) {
		if (email == "") {
			alert("E-mail is empty");
			return false;
		}
		var reg = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		if (!reg.test(String(email).toLowerCase())) {
			alert("E-mail is incorrect");
			return false;
		}
		return true;
	}
	
	function validateFirstName(firstName) {
		if (firstName == "") {
			alert("First name is empty");
			return false;
		}
		return true;
	}

	function validateLastName(lastName) {
		if (firstName == "") {
			alert("Last name is empty");
			return false;
		}
		return true;
	}
	
</script>

</html>



