<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	<h3>Create document</h3>

	<p style="color: red;">${errorString}</p>
	
	
		<form method="POST" name = "newDocument" action="${pageContext.request.contextPath}/document/create.html" 
		onsubmit="return formValidation()">
		

		<table border="0">
			<tr>
				<td>
				<input type="hidden" name="documentTypeID" value="${documentType.docTypeID}"/>${docTypeID.docType}
				</td>
			</tr>
		
			<tr>
				<td>
				<input type="hidden" name="senderID" value="${loginedUser.employeeID}"/>
				Author ${loginedUser.lastName}, ${loginedUser.position.position} 
				</td>
			</tr>
			<tr>
				<td>
				Enter short description. 
				<textarea id="docDescription" name="docDescription" rows="1" cols="64"></textarea>
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
				<c:forEach items="${subordinations}" var="subordination" varStatus="index">
				<input type="checkbox" name="receiver${index.index}" value="${subordination.receiver.employeeID}"> ${subordination.receiver.lastName}  ${subordination.receiver.position.position}<br>
				</c:forEach>
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="hidden" name="subNumber" value="${fn:length(subordinations)}"/>
				<input type="submit" name="submit" value="Create" />
				</td>
			</tr>

		</table>
	</form>
	
	<form method="GET" action="${pageContext.request.contextPath}/document/create.html">
		<input type="submit" value="Back">
	</form>





	<jsp:include page="/WEB-INF/jsp/_footer.jsp"></jsp:include>

</body>

<script>

	function formValidation() {
		description = document.forms["newDocument"]["docDescription"].value;
		text = document.forms["newDocument"]["docText"].value;
		date = document.forms["newDocument"]["executeDate"].value;

		if (validateDescription(description) == false) {
			return false;
		}

		if (validateText(text) == false) {
			return false;
		}

		if (validateDate(date) == false) {
			return false;
		}

		return true;
	}

	function validateDescription(text) {
		if (text == "") {
			alert("Description is empty");
			return false;
		}
		return true;
	}

	function validateText(text) {
		if (text == "") {
			alert("Text is empty");
			return false;
		}
		return true;
	}

	function validateDate(date) {
		var currentDate = new Date().toString();
		if (Date.parse(date) < Date.parse(currentDate)) {
			alert("Execute date should be later, than present date");
			return false;
		}
		return true;
	}
</script>

</html>

