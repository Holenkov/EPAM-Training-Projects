function formValidation() {
	email = document.forms["login"]["email"].value;
	password = document.forms["login"]["password"].value;
	if (validateEmail(email) == false) {
		return false;
	}
	if (validatePassword(password) == false) {
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

function validatePassword(password) {
	if (password == "") {
		alert("Password is empty");
		return false;
	}
	return true;
}

