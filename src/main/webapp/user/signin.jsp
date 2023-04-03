<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.restaurant.users.Customer"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Font Awesome -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
  rel="stylesheet"
/>
<!-- Google Fonts -->
<link
  href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
  rel="stylesheet"
/>
<!-- MDB -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.css"
  rel="stylesheet"
/>

<link rel="stylesheet" type="text/css" href="./styles/signin.css">



<title>Sign in</title>
</head>
<body>
<jsp:include page="../utils/nav.jsp" />

<style>
	.form {
		margin: auto;
		width: 400px;
		margin-top: 5%;
	}
	
	@media screen and (max-width: 400px) {
		.form {
			width: 100%;
		}
	}
</style>

<div class="form">
<!-- Pills navs -->
<%
	Customer cus = (Customer) session.getAttribute("customer");
	if (cus != null) {
		response.sendRedirect("/Restaurant/home.jsp?redirected=signedin");
	}
%>

<%
	String error = (String) request.getAttribute("error");
	if (error != null) {
		%>
		<div class="p-3 mb-2 bg-danger bg-gradient text-white"><%= error %></div>
<%	}
%>
<ul class="nav nav-pills nav-justified mb-3" id="ex1" role="tablist">

  <li class="nav-item" role="presentation">
    <a
      class="nav-link active"
      id="tab-login"
      data-mdb-toggle="pill"
      href="#pills-login"
      role="tab"
      aria-controls="pills-login"
      aria-selected="true"
      >Login</a
    >
  </li>
  <li class="nav-item" role="presentation">
    <a
      class="nav-link"
      id="tab-register"
      data-mdb-toggle="pill"
      href="#pills-register"
      role="tab"
      aria-controls="pills-register"
      aria-selected="false"
      >Register</a
    >
  </li>
</ul>
<!-- Pills navs -->

<!-- Pills content -->
<div class="tab-content">
  <div class="tab-pane fade show active" id="pills-login" role="tabpanel" aria-labelledby="tab-login">
    <form method="POST" action="/Restaurant/auth">
    <input type="hidden" name="role" value="customer">
    <%
    	if (request.getParameter("continue") != null) {
    	    %>
    	    <input type='hidden' name='continue' value=<%= request.getParameter("continue")%> />
    	    <%
    	}
    %>
      <!-- Email input -->
      <div class="form-outline mb-4">
        <input type="email" id="loginName" class="form-control" name="email" required />
        <label class="form-label" for="loginName">Email</label>
      </div>

      <!-- Password input -->
      <div class="form-outline mb-4">
        <input type="password" id="loginPassword" class="form-control" name="password" required />
        <label class="form-label" for="loginPassword">Password</label>
      </div>

      <!-- 2 column grid layout -->
      <div class="row mb-4">
        <div class="col-md-6 d-flex justify-content-center">
          <!-- Checkbox -->
          <div class="form-check mb-3 mb-md-0">
            <input class="form-check-input" type="checkbox" value="" id="loginCheck" checked required />
            <label class="form-check-label" for="loginCheck"> Remember me </label>
          </div>
        </div>

        <div class="col-md-6 d-flex justify-content-center">
          <!-- Simple link -->
          <a href="#!">Forgot password?</a>
        </div>
      </div>

      <!-- Submit button -->
      <button type="submit" class="btn btn-primary btn-block mb-4">Sign in</button>
    </form>
  </div>
  <div class="tab-pane fade" id="pills-register" role="tabpanel" aria-labelledby="tab-register">
    <form method="POST" action="/Restaurant/register">
	    <input type="hidden" name="role" value="customer">
      <!-- Name input -->
      <div class="form-outline mb-4">
        <input type="text" id="registerName" class="form-control" name="fname" required />
        <label class="form-label" for="registerName">First Name</label>
      </div>

      <!-- Username input -->
      <div class="form-outline mb-4">
        <input type="text" id="registerUsername" class="form-control" name="lname" required />
        <label class="form-label" for="registerUsername">Last Name</label>
      </div>

      <!-- Email input -->
      <div class="form-outline mb-4">
        <input type="tel" id="registerEmail" class="form-control" name="phone" required />
        <label class="form-label" for="registerEmail">Phone</label>
      </div>

      <!-- Email input -->
      <div class="form-outline mb-4">
        <input type="email" id="registerEmail" class="form-control" name="email" required />
        <label class="form-label" for="registerEmail">Email</label>
      </div>

      <!-- Password input -->
      <div class="form-outline mb-4">
        <input type="password" id="password" class="form-control" name="password" required />
        <label class="form-label" for="registerPassword">Password</label>
      </div>

      <!-- Repeat Password input -->
      <div class="form-outline mb-4">
        <input type="password" id="confirm_password" class="form-control" />
        <label class="form-label" for="registerRepeatPassword">Repeat password</label>
      </div>

      <!-- Checkbox -->
      <div class="form-check d-flex justify-content-center mb-4">
        <input
          class="form-check-input me-2"
          type="checkbox"
          value=""
          id="registerCheck"
          checked
          aria-describedby="registerCheckHelpText"
          required 
        />
        <label class="form-check-label" for="registerCheck">
          I have read and agree to the terms
        </label>
      </div>

      <!-- Submit button -->
      <button type="submit" class="btn btn-primary btn-block mb-3" onClick={notification}>Sign up</button>
    </form>
  </div>
</div>
<!-- Pills content -->
</div>
<!-- MDB -->
	<script
	  type="text/javascript"
	  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.js"
	></script>
	
	<!-- checking password match  -->
	<script type="text/javascript">
		var password = document.getElementById("password")
		, confirm_password = document.getElementById("confirm_password");
		
		function validatePassword(){
		if(password.value != confirm_password.value) {
		  confirm_password.setCustomValidity("Passwords Don't Match");
		} else {
		  confirm_password.setCustomValidity('');
		}
		}
		
		password.onchange = validatePassword;
		confirm_password.onkeyup = validatePassword;
	</script>


</body>
</html>