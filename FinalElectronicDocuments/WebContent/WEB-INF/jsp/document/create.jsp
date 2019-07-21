<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<body>
	<jsp:include page="/WEB-INF/jsp/_header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/jsp/_menu.jsp"></jsp:include>
	<h1 style="color: red;">${msg}</h1>
	<h3>Create document</h3>

	<p style="color: red;">${errorString}</p>
	
	<!-- docID
	authorID
	docType
	description
	textBody
	dateUpdated
	dateToExecute -->
	
	
		<form method="POST" action="${pageContext.request.contextPath}/document/create.html">
		

		<table border="0">
			<tr>
				<td>
				<input type="hidden" name="documentTypeID" value="${documentType.docTypeID}"/>${docTypeID.docType}
				</td>
			</tr>
		
			<tr>
				<td>
				<input type="hidden" name="employeeID" value="${loginedUser.employeeID}"/>
				Author ${loginedUser.lastName}, ${loginedUser.position.position} 
				</td>
			</tr>
			<tr>
				<td>
				Enter short description. <input type="text" name="description"/>
				<textarea id="docDescription" name="docDescription" rows="1" cols="100"></textarea>
				</td>
			</tr>	
			<tr>
				<td>
				 Enter Text. <textarea id="docText" name="docText" rows="20" cols="100"></textarea>
				</td>
			</tr>	
				
			<tr>
				<td>Execute before 
				<input type="date" name="executeDate" max="2099-01-01" min="2000-01-01"></td>
			</tr>		
			<tr>
				<td>Send to  <br>
		<%-- 		<input type="checkbox" name="${employees[0].employeeID}" value="${employees[0].employeeID}">${employees[0].employeeID}  ${employees[0].lastName}  ${employees[0].position.position}<br>		 --%>		
				<c:forEach items="${receivers}" var="receiver" varStatus="index">
				<input type="checkbox" name="receiver${index.index}" value="${rec.employeeID}">${rec.employeeID}  ${rec.lastName}  ${rec.position.position}<br>
				</c:forEach>
				</td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" name="submit" value="Create" /></td>
			</tr>

		</table>
	</form>
	
	<form method="GET" action="${pageContext.request.contextPath}/main.html">
		<input type="hidden" name="documentTypeID" value="${documentType.docTypeID}"/>
		<input type="submit" value="Back">
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
		
	/* 	if (validateFile(file) == false) {
			return false;
		} */
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

