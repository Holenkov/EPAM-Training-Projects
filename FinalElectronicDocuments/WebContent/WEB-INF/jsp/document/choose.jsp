<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

	<!-- docID
	authorID
	docType
	description
	textBody
	dateUpdated
	dateToExecute -->


	<form method="GET"
		action="${pageContext.request.contextPath}/document/create.html">


		<select id="documentTypeID" name="documentTypeID" required>
			<c:forEach items="${docTypes}" var="docType">
				<option value="${docType.docTypeID}">${docType.docType}</option>
			</c:forEach>
		</select> <input type="submit" name="submit" value="Create" />
	</form>

	<form method="GET"
		action="${pageContext.request.contextPath}/main.html">
		<input type="submit" value="Cancel">
	</form>





	<jsp:include page="/WEB-INF/jsp/_footer.jsp"></jsp:include>

</body>


</html>

