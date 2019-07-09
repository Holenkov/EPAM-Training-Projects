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
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
			
			
			<th>Employee ID</th>
			<th>e-mail</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Position</th>
			<th>Role</th>
			<th>Employee Status</th>
			<th>Edit</th>
					 
			 
       </tr>
      
       <c:forEach items="${employeeList}" var="employee">
          <tr>          
     	     <td>${employee.employeeID}</td>
			 <td>${employee.email}</td>
			 <td>${employee.firstName}</td>
			 <td>${employee.lastName}</td>
			 <td>${employee.position.position}</td>
			 <td>${employee.role.role.name}</td>
		     <td>${employee.employeeStatus.emplStatus}</td>
		     <td>
                <form method="GET" action="${pageContext.request.contextPath}/employee/edit.html">
                	<input type="hidden" name="employeeID" value="${employee.employeeID}" />
                	<input type="submit" value="Edit">
                </form>  
             </td>              
          </tr>
       </c:forEach>
    </table>
 
 
    <jsp:include page="/WEB-INF/jsp/_footer.jsp"></jsp:include>
 
 </body>
</html>