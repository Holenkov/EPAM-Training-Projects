<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="background: #E0E0E0; height: 55px; padding: 5px;">
	<div style="float: left">
		<h1>E-Doc</h1>
	</div>

	<div style="float: right; padding: 10px; text-align: right;">

		<c:if test="${not empty loginedUser}">
			User ${loginedUser.email}
		   | <a href="${pageContext.request.contextPath}/accountInfo"> Account Info</a> 
		   | <a href="${pageContext.request.contextPath}/logout">Exit</a>   		  
		</c:if>
		<br/>
		<!--     Search <input name="search"> -->

	</div>

</div>