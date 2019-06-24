<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="padding: 5px;">

	<a href="${pageContext.request.contextPath}/main">Home</a>
	<c:if test="${not empty loginedUser}">
		 |
      	 <a href="${pageContext.request.contextPath}/myDocuments">My Documents</a>
      	 |
      	 <a href="${pageContext.request.contextPath}/executeDocuments">Execute</a>
      	 |
      	 <a href="${pageContext.request.contextPath}/createDocument">Create Document</a>
      	 
		 <c:if test="${loginedUser.role.role == 'ADMIN'}">
    	 	|
      	 	<a href="${pageContext.request.contextPath}/employees">Employees</a>           	 
		 </c:if>
		
	</c:if>

</div>
