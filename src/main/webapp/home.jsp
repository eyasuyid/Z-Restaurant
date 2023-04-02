<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<!-- MDB -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.css"
  rel="stylesheet"
/>
</head>
<body>
<jsp:include page="./utils/nav.jsp" />
<%
	if (request.getParameter("redirected") != null) {
		if (request.getParameter("redirected").equals("signedin")) {
			out.print("<div class='p-3 mb-2 bg-warning bg-gradient text-dark' id='signedin' onClick='signedFun()'>You already signed in</div>");
		}
	}

%>
<h1>Home</h1>

<script>
	const signed = document.getElementById("signedin");
	function signedFun() {
		signed.style = "display: none";
	}
	
</script>
</body>
</html>