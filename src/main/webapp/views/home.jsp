<html>

<head>
<meta charset="UTF-8">
<title>Home</title>
<jsp:include page="styles.jsp"></jsp:include>
</head>

<body class="antialiased">
<div class="wrapper">
<jsp:include page="header.jsp"></jsp:include>
<div id="carousel-captions" class="carousel slide" data-bs-ride="carousel">
	<div class="carousel-inner">
		<div class="carousel-item active" style="height:500px">
			<img class="d-block w-100" height=600px alt="" src="./static/photos/1194d63fe36a8670.jpg">
			<div class="carousel-item-background d-none d-md-block"></div>
			<div class="carousel-caption d-none d-md-block">
				<h1 style="color:Black">Feel like Home</h3>
				<p style="color:Black">During Your Travels</p>
			</div>
		</div>
        <div class="carousel-item" style="height:500px">
        	<img class="d-block w-100" height=600px alt="" src="./static/photos/1366fdc9b9b277e4.jpg">
        	<div class="carousel-item-background d-none d-md-block"></div>
            <div class="carousel-caption d-none d-md-block">
       			<h1 style="color:Black">Feel like Home</h3>
				<p style="color:Black">During Your Travels</p>
            </div>
        </div>
        <div class="carousel-item" style="height:500px">
            <img class="d-block w-100" height=600px alt="" src="./static/photos/de6d0fd1feebb6a2.jpg">
            <div class="carousel-item-background d-none d-md-block"></div>
          	<div class="carousel-caption d-none d-md-block">
        	    <h1 style="color:White">Feel like Home</h3>
				<p style="color:White">During Your Travels</p>
            </div>
        </div>
        <div class="carousel-item" style="height:500px">
            <img class="d-block w-100" height=600px alt="" src="./static/photos/56614e12b2a7bd68.jpg">
            <div class="carousel-item-background d-none d-md-block"></div>
            <div class="carousel-caption d-none d-md-block">
                <h1 style="color:Black">Feel like Home</h3>
				<p style="color:Black">During Your Travels</p>
            </div>
        </div>
        <div class="carousel-item" style="height:500px">
            <img class="d-block w-100" height=600px alt="" src="./static/photos/77586f6ffa9fbc5e.jpg">
            <div class="carousel-item-background d-none d-md-block"></div>
           	<div class="carousel-caption d-none d-md-block">
        	   	<h1 style="color:Black">Feel like Home</h3>
				<p style="color:Black">During Your Travels</p>
            </div>
        </div>
    </div>
    <a class="carousel-control-prev" href="#carousel-captions" role="button" data-bs-slide="prev">
    	<span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carousel-captions" role="button" data-bs-slide="next">
    	<span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </a>
</div>
<div style="background-color:white;padding:20px">
<h1 class="text-center">Join Us</h1>
<div class="row row-0 justify-content-center">
  <div class="col-md-3" style="padding:10px">
  	<a href="/admin-login" style="text-decoration:none">
	<div class="card">
	  <div class="card-body">
	    <h3 class="card-title text-center">Admin</h3>
	  	<div class="card-img-top img-responsive img-responsive-16by9" style="background-image: url(https://i.pinimg.com/originals/3f/34/b2/3f34b2b917029cc9a0caddaa0a4454fb.png)"></div>
	  </div>
	</div>
	</a>
  </div>

  <div class="col-md-3" style="padding:10px">
  	<a href="/guest-provider-login" style="text-decoration:none">
	<div class="card">
	  <div class="card-body">
	    <h3 class="card-title text-center">GuestProvider</h3>
	  	<div class="card-img-top img-responsive img-responsive-16by9" style="background-image: url(	https://providerhealthcare.com/wp-content/uploads//2020/06/Permanent-Placement.svg)"></div>
	  </div>
	</div>
	</a>
  </div>
  
  <div class="col-md-3" style="padding:10px">
	<a href="/login" style="text-decoration:none">
	<div class="card">
	  <div class="card-body">
	    <h3 class="card-title text-center">User</h3>
	  	<div class="card-img-top img-responsive img-responsive-16by9" style="background-image: url(/static/admin.jpg)"></div>
	  </div>
	</div>
	</a>
  </div>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>