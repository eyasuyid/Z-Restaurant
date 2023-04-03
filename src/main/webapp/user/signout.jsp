<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signing out</title>
</head>
<body>
<jsp:include page="../utils/nav.jsp" />
<%
	if(session.getAttribute("customer") != null) {
		session.invalidate();
		response.sendRedirect("/Restaurant/home.jsp");
	} else {
		response.sendRedirect("/Restaurant/home.jsp");	
	}
%>
</body>
</html>