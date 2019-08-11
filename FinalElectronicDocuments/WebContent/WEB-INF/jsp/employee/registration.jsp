<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang=eng>

<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<body>
	<jsp:include page="/WEB-INF/jsp/_header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/jsp/_menu.jsp"></jsp:include>
	<h1 style="color: red;">${msg}</h1>
	<h3>Registration Form</h3>

	<p style="color: red;">${errorString}</p>
	



<form action="${pageContext.request.contextPath}/employee/registration.html"
		method="POST" name="registration" enctype="multipart/form-data" onsubmit="return formValidation();">
  <div class="form-group row">
    <label for="text" class="col-sm-1 col-form-label">E-mail</label>
    <div class="col-sm-3">
      <input type="text" class="form-control" name="email" placeholder="Enter email" value="${tempEmployee.email}" maxlength="255">
    </div>
  </div>
   <div class="form-group row">
    <label for="password1" class="col-sm-1 col-form-label">Password </label>
    <div class="col-sm-3">
      <input type="password" class="form-control" name="password1" placeholder="Enter password" value="${tempEmployee.password}"  maxlength="32">
    </div>
  </div>
   <div class="form-group row">
    <label for="password2" class="col-sm-1 col-form-label">Repeat Password</label>
    <div class="col-sm-3">
      <input type="password" class="form-control" name="password2" placeholder="Repeat password" value="${tempEmployee.password}" maxlength="32">
    </div>
  </div>
  
   <div class="form-group row">
    <label for="firstName" class="col-sm-1 col-form-label">First name</label>
    <div class="col-sm-3">
      <input type="text" class="form-control" name="firstName" placeholder="Enter first name" value="${tempEmployee.firstName}" maxlength="32">
    </div>
  </div>
  
   <div class="form-group row">
    <label for="lastName" class="col-sm-1 col-form-label">Last name</label>
    <div class="col-sm-3">
      <input type="text" class="form-control" name="lastName" placeholder="Enter last name" value="${tempEmployee.lastName}" maxlength="32">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="avatar" class="col-sm-1 col-form-label">Select avatar.</label>
    <div class="col-sm-3">
      <input type="file" accept=".jpg" class="form-control-file" id="avatar">
    </div>
  </div>
  
 <button type="submit" class="btn btn-primary">Submit</button>
  
 
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
		 var reg = /^[a-zA-Z ]*$/;
		if (!reg.test(String(firstName))) {
			alert("First name should include letters only");
			return false;
		}  
		
		return true;
	}

	function validateLastName(lastName) {
		if (lastName == "") {
			alert("Last name is empty");
			return false;
		}
		 var reg = /^[a-zA-Z ]*$/;
		if (!reg.test(String(lastName))) {
			alert("Last name should include letters only");
			return false;
		} 
		
		return true;
	}
	
</script>

</html>



