<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
			
			
			<th>Document ID</th>
			<th>Document Type</th>
			<th>Date</th>
			<th>Description</th>
			<th>Author</th>
			<th>Executor</th>
			<th>Status</th>
			<th>Date of execution</th>
			<th>View</th>
					 
			 
       </tr>
      
       <c:forEach items="${historyList}" var="history">
          <tr>          
     	     <td> ${history.document.docID}</a></td>
     	     <td>${history.document.docType.docType}</td>
			 <td><fmt:formatDate value="${history.document.dateUpdated}" pattern="yyyy-MM-dd" /></td>
			 <td>${history.document.description}</td>
			 <td>${history.fromEmployee.lastName}, ${history.fromEmployee.position.position}</td>
			 <td>${history.toEmployee.lastName}, ${history.toEmployee.position.position}</td>
			 <td>${history.docStatus.docStatus}</td>
			 <td><fmt:formatDate value="${history.dateExecuted}" pattern="yyyy-MM-dd" /></td>
			 <td>
                <form method="POST" action="${pageContext.request.contextPath}/document/view.html">
             	    <input type="hidden" name="docHistoryID" value="${history.id}" />
                	<input type="hidden" name="backParam" value="${backParam}" />
                	<input type="submit" value="View">
                </form>  
             </td>          
          </tr>
       </c:forEach>
    </table>
    
 
 
    <jsp:include page="/WEB-INF/jsp/_footer.jsp"></jsp:include>
 
 </body>
</html>