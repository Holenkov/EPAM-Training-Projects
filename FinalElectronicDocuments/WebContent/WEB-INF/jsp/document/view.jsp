<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<!DOCTYPE html>
<html lang=eng>

<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
    <title>Employee List</title>
 </head>
 <body>
 
    <jsp:include page="/WEB-INF/jsp/_header.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/jsp/_menu.jsp"></jsp:include>
  
    <p style="color: red;">${errorString}</p>
 
  <!-- 	private int docID;
	private Employee author;
	private DocumentType docType;
	private String description;
	private String textBody;
	private Timestamp dateUpdated;
	private Timestamp dateToExecute; -->
	
	<table border="0">
			<tr>
				<td>
					Document #${document.docID} 
				</td>
			<tr>
			<tr></tr>
			<tr>
				<td>
					Author:    ${document.author.position.position},      ${document.author.firstName} ${document.author.lastName}
				</td>
			</tr>
			<tr></tr>
			<tr>
				<td>
					${document.description} 
				</td>
			</tr>
			<tr></tr>
			<tr>
				<td>
					${document.textBody} 
				</td>
			</tr>
			<tr></tr>
			<tr>
				<td>
					Date updated:         <td><fmt:formatDate value="${document.dateUpdated}" pattern="yyyy-MM-dd" /></td>
				</td>
			</tr>
			<tr></tr>
			<tr>
				<td>
					Date to execute:      <td><fmt:formatDate value="${document.dateToExecute}" pattern="yyyy-MM-dd" /></td> 
				</td>
			</tr>
		</table>
		
		<form method="GET"
			action="${pageContext.request.contextPath}/document/viewList.html">
			<input type="hidden" name="${backParam}" value="${loginedUser.employeeID}" />
			<input type="submit" value="Back">
		</form>
    
 
 
    <jsp:include page="/WEB-INF/jsp/_footer.jsp"></jsp:include>
 
 </body>
</html>