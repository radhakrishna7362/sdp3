<html>

<head>
<meta charset="UTF-8">
<title>Home</title>
<jsp:include page="styles.jsp"></jsp:include>
</head>

<body class="antialiased">
<div class="wrapper">
<jsp:include page="header.jsp"></jsp:include>
</div>
<div class="row row-deck m-0 mt-2">
  <div class="offset-sm-2 col-4">
	<div class="card">
	  <div class="card-body">
	    <h3 class="card-title text-center"><a href="/admin-login">Admin</a></h3>
	  	<div class="card-img-top img-responsive img-responsive-16by9" style="background-image: url(/static/admin.jpg)"></div>
	  </div>
	</div>
  </div>

  <div class="col-4">
	<div class="card">
	  <div class="card-body">
	    <h3 class="card-title text-center"><a href="/guest-provider-login">GuestProvider</a></h3>
	  	<div class="card-img-top img-responsive img-responsive-16by9" style="background-image: url(/static/admin.jpg)"></div>
	  </div>
	</div>
  </div>
</div>

<div class="row row-deck m-0 mt-2">
	<div class="offset-4 col-4">
	<div class="card">
	  <div class="card-body">
	    <h3 class="card-title text-center"><a href="/login">User</a></h3>
	  	<div class="card-img-top img-responsive img-responsive-16by9" style="background-image: url(/static/admin.jpg)"></div>
	  </div>
	</div>
  </div>
</div>

</body>

</html>