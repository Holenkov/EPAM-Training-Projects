<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Devices List</title>
</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>

	<p style="color: red;">${errorString}</p>

	<table border="1" cellpadding="5" cellspacing="1">
		<tr>
			<th>Name</th>
			<th>Origin</th>
			<th>Date of Issue</th>
			<th>Price</th>
			<th>Other</th>
			<th>Resolution</th>
			<th>Capacity</th>
			<th>Speed</th>
			<th>Rpm</th>
			<th>Is Wireless?</th>
			<th>Ports</th>
			<th>Is critical for Use?</th>
		</tr>

		<c:forEach items="${devices}" var="device">
			<tr>
				<td>${device.name}</td>
				<td>${device.origin}</td>
				<td><fmt:formatDate value="${device.dateOfIssue}" pattern="yyyy-MM" /></td>
				<td>${device.price}</td>
				<td>${device.types}</td>
				<td>
					<c:catch var="exception">
						${device.resolutionX}<br>
						${device.resolutionY}
					</c:catch> 
					<c:if test="${not empty exception}">-</c:if> 
				</td>
				<td>
					<c:catch var="exception">
						${device.capacity}
					</c:catch> 
					<c:if test="${not empty exception}">-</c:if> 
				</td>
				<td>
					<c:catch var="exception">
						${device.speed}
					</c:catch> 
					<c:if test="${not empty exception}">-</c:if> 
				</td>
				<td>
					<c:catch var="exception">
						${device.rpm}
					</c:catch> 
					<c:if test="${not empty exception}">-</c:if> 
				</td>
				<td>
					<c:catch var="exception">
						${device.wireless}
					</c:catch> 
					<c:if test="${not empty exception}">-</c:if> 
				</td>
				<td>
					<c:catch var="exception">
							${device.ports}
					</c:catch> 
					<c:if test="${not empty exception}">-</c:if> 
				</td>
				<td>${device.critical}</td>
			</tr>
		</c:forEach>
	</table>


	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>