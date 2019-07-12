function formValidation() {
	alert("edit First name is empty");
	firstName = document.forms["edit"]["firstName"].value;
	lastName = document.forms["edit"]["lastName"].value;
	

	if (validateFirstName(firstName) == false) {
		return false;
	}
	if (validateLastName(lastName) == false) {
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
