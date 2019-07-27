<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- <div style="padding: 5px;text-align: left " align="left"> -->
<div class="container-fluid">

		<a href="${pageContext.request.contextPath}/main.html">Home</a>
		<c:if test="${not empty loginedUser}">
		 |
      	 <a href="${pageContext.request.contextPath}/document/viewList.html?author=${loginedUser.employeeID}">My Documents</a>
      	 |
      	 <a href="${pageContext.request.contextPath}/document/viewList.html?executor=${loginedUser.employeeID}">Execute</a>
      	 |
      	 <a href="${pageContext.request.contextPath}/document/choose.html">Create Document</a>

			<c:if test="${loginedUser.role.role == 'ADMIN' or loginedUser.role.role == 'MANAGER'}">    	 	|
      	 	<a href="${pageContext.request.contextPath}/employee/viewAll.html">Employees</a>
			</c:if>

		</c:if>


</div>
