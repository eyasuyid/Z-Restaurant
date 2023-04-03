<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css">
<div>
<nav class="navbar navbar-expand-lg bg-body-tertiary bg-primary"  style="background-color: #e3f2fd;">
  <div class="container-fluid">
    <a class="navbar-brand" href="/Restaurant/home.jsp">Z-Restaurant</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/Restaurant/home.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/Restaurant/menu.jsp">Menu</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/Restaurant/delivery.jsp">Delivery</a>
        </li>
		<li class="nav-item">
          <a class="nav-link" href="/Restaurant/reservation.jsp">Reservation</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Account
          </a>
          <ul class="dropdown-menu">
          	<%
          		if (session.getAttribute("customer") == null) {
          			out.print("<li><a class='dropdown-item' href='/Restaurant/user/signin.jsp'>Sign in</a></li>");
          			out.print("<li><a class='dropdown-item' href='/Restaurant/user/signup.jsp'>Sign up</a></li>");
          		} else {
          			out.print("<li><a class='dropdown-item' href='/Restaurant/user/signout.jsp'>Sign out</a></li>");
          		}
          	%>
          </ul>
        </li>
      </ul>
    </div>
    <form class="d-flex" role="search">
      <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
  </div>
</nav>
</div>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"></script>