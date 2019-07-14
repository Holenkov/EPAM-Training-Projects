<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Employee List</title>
 </head>
 <body>
 
    <jsp:include page="/WEB-INF/jsp/_header.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/jsp/_menu.jsp"></jsp:include>
    
    <p style="color: red;">${errorString}</p>

	<form method="GET" action="${pageContext.request.contextPath}/subordination/add.html">
		<input type="hidden" name="employeeID" value="${employeeID}" />
		<input type="submit" value="Add">
	</form>
	<br>
	<table border="1" cellpadding="5" cellspacing="1" >
    	<tr>
    	Employee as Sender
    	</tr>
       <tr>	
			<th>Sub ID</th>
			<th>Sender</th>
			<th>Document</th>
			<th>Receiver</th>
			<th>Delete</th>			 
       </tr>
       
       <c:forEach items="${subBySender}" var="sub">
          <tr> 
             <td>${sub.id}</td>
     	     <td>${sub.sender.lastName}, ${sub.sender.position.position}</td>
			 <td>${sub.docType.docType}</td>
			 <td>${sub.receiver.lastName}, ${sub.receiver.position.position}</td>
		     <td>
                <form method="GET" action="${pageContext.request.contextPath}/subordination/deleteConfirm.html">
                	<input type="hidden" name="subID" value="${sub.id}" />
                	<input type="hidden" name="employeeID" value="${employeeID}" />
                	<input type="submit" value="Delete">
                </form>  
             </td> 		             
          </tr>
       </c:forEach>
    </table>
    <br>
    
     <table border="1" cellpadding="5" cellspacing="1" >
    	<tr>
    	Employee as Receiver
    	</tr>
       <tr>	
			<th>Sub ID</th>
			<th>Sender</th>
			<th>Document</th>
			<th>Receiver</th>
			<th>Delete</th>			 
       </tr>
       
       <c:forEach items="${subByReceiver}" var="sub">
          <tr> 
             <td>${sub.id}</td>
     	     <td>${sub.sender.lastName}, ${sub.sender.position.position}</td>
			 <td>${sub.docType.docType}</td>
			 <td>${sub.receiver.lastName}, ${sub.receiver.position.position}</td>
		     <td>
                <form method="GET" name = "sub" action="${pageContext.request.contextPath}/subordination/deleteConfirm.html">
                	<input type="hidden" name="subID" value="${sub.id}" />
                	<input type="hidden" name="employeeID" value="${employeeID}" />
                	<input type="submit" value="Delete">
                </form>  
             </td> 		             
          </tr>
       </c:forEach>
    </table>
    
 
    <jsp:include page="/WEB-INF/jsp/_footer.jsp"></jsp:include>
 
 </body>
</html>