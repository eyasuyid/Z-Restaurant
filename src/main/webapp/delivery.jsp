<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delivery</title>
</head>
<body>
<jsp:include page="./utils/nav.jsp" />
<%
	if (session.getAttribute("customer") == null) {
		response.sendRedirect("/Restaurant/user/signin.jsp?continue=/Restaurant/delivery.jsp");
	}
%>
<h1>Delivery</h1>
</body>
</html>