<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="background: #E0E0E0; height: 55px; padding: 5px;">
	<div style="float: left">
		<h1>Electronic Workflow</h1>
	</div>

	<div style="float: right; padding: 10px; text-align: right;">

		<c:if test="${not empty loginedUser}">
			${loginedUser.role.role.name} ${loginedUser.email}
		   | <a href="${pageContext.request.contextPath}/employee/view.html?employeeID=${loginedUser.employeeID}"> Account Info</a> 
		   | <a href="${pageContext.request.contextPath}/logout.html">Exit</a>   		  
		</c:if>
		<br/>
		<!--     Search <input name="search"> -->

	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</div>