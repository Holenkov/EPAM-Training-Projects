<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
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

	<form method="GET" action="${pageContext.request.contextPath}/subordination/add.html">
		<input type="hidden" name="employeeID" value="${employeeID}" />
		<input type="submit" value="Add">
	</form>
	<br>

	<table border="0">
		<tr>
			<td>
				<c:if test="${page > 1}">
				<form method="GET" action="${pageContext.request.contextPath}/subordination/view.html">
					<input type="hidden" name="page" value="${page-1}" /> 
					<input type="hidden" name="employeeID" value="${employeeID}" /> 
					<input type="submit" value="<<Previous">
				</form>
				</c:if>
			</td>
			<td> Page ${page}</td>
			<td>
			<c:if test="${page < fullSubs.size()/10}">
				<form method="GET" action="${pageContext.request.contextPath}/subordination/view.html">
					<input type="hidden" name="page" value="${page+1}" />
					<input type="hidden" name="employeeID" value="${employeeID}" /> 
					<input type="submit" value="Next>>">
				</form>
			</c:if>
			</td>
		</tr>
	</table>




	<table border="1" cellpadding="5" cellspacing="1" >
    	<tr>
    		<td> 
    			<form method="GET" action="${pageContext.request.contextPath}/subordination/view.html">
    				<input type="hidden" name="page" value="${page}" />
                	<input type="hidden" name="sort" value="id" />
                	<input type="hidden" name="employeeID" value="${employeeID}" />
                	<input type="submit" value="Sort">
                </form>  
            </td>
            <td> 
    			<form method="GET" action="${pageContext.request.contextPath}/subordination/view.html">
    				<input type="hidden" name="page" value="${page}" />
                	<input type="hidden" name="sort" value="sender" />
                	<input type="hidden" name="employeeID" value="${employeeID}" />
                	<input type="submit" value="Sort">
                </form>  
            </td>
            <td> 
    			<form method="GET" action="${pageContext.request.contextPath}/subordination/view.html">
    				<input type="hidden" name="page" value="${page}" />
                	<input type="hidden" name="sort" value="docType" />
                	<input type="hidden" name="employeeID" value="${employeeID}" />
                	<input type="submit" value="Sort">
                </form>  
            </td>
            <td> 
    			<form method="GET" action="${pageContext.request.contextPath}/subordination/view.html">
    				<input type="hidden" name="page" value="${page}" />
                	<input type="hidden" name="sort" value="receiver" />
                	<input type="hidden" name="employeeID" value="${employeeID}" />
                	<input type="submit" value="Sort">
                </form>  
            </td>
            <td> 
    			
            </td>
    	</tr>
       <tr>	
			<th>Sub ID</th>
			<th>Sender</th>
			<th>Document</th>
			<th>Receiver</th>
			<th>Delete</th>			 
       </tr>
       
       <c:forEach items="${subs}" var="sub">
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
    
 
    <jsp:include page="/WEB-INF/jsp/_footer.jsp"></jsp:include>
 
 </body>
</html>