<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang=eng>

<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <jsp:include page="/WEB-INF/jsp/_header.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/jsp/_menu.jsp"></jsp:include>
  
    <p style="color: red;">${errorString}</p>
 
   <h2>Employee successfully edited.</h3>

</body>
</html>