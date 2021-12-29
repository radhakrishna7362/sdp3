<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Traveller Home</title>
<jsp:include page="styles.jsp"/>
</head>

<body>
	<jsp:include page="user-logout.jsp"/>
	<div class="row row-0">
		<div class="offset-1 col-md-5 col-sm-10 py-4">
			<div class="card">
				<div class="card-body">
					<h1>Top GuestHouses</h1>
					<div class="row">
						<div class="col-md-6">
							<div class="card">
								<div class="card-img-top img-responsive img-responsive-16by9" style="background-image: url(static/avatars/000m.jpg)"></div>
								<div class="card-body">
									<h3 class="card-title">Card with title and image</h3>
								    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="card">
								<div class="card-img-top img-responsive img-responsive-16by9" style="background-image: url(static/avatars/000m.jpg)"></div>
								<div class="card-body">
									<h3 class="card-title">Card with title and image</h3>
								    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
								</div>
							</div>
						</div>
					</div>
					<div class="row mt-2">
						<div class="col-md-6">
							<div class="card">
								<div class="card-img-top img-responsive img-responsive-16by9" style="background-image: url(static/avatars/000m.jpg)"></div>
								<div class="card-body">
									<h3 class="card-title">Card with title and image</h3>
								    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="card">
								<div class="card-img-top img-responsive img-responsive-16by9" style="background-image: url(static/avatars/000m.jpg)"></div>
								<div class="card-body">
									<h3 class="card-title">Card with title and image</h3>
								    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="offset-1 col-md-4 col-sm-10 py-4">
			<form class="card card-md" action="/search-houses" method="POST">
				<div class="card-body">
					<div class="mb-3">
						<label for="city" class="form-label">City</label>
						<input type="text" class="form-control" id="city" name="city" placeholder="City"/>
					</div>
					<div class="mb-3">
						<label for="date" class="form-label">Date</label>
						<input type="date" class="form-control" id="date" name="date"/>
					</div>
					<div class="form-footer">
						<button type="submit" class="btn btn-primary w-100">Search</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="offset-1">
		<h1>Top Guest Places</h1>
		<div class="card col-md-11">
			<div class="card-body">
				<div class="row row-0">
					<div class="card col-md-3">
						<img src="static/avatars/000m.jpg" class="w-100 h-100 object-cover" alt="Card side image">
						<div class="card-body">
							Card with body and image
						</div>
					</div>
					<div class="card col-md-3">
						<img src="static/avatars/000m.jpg" class="w-100 h-100 object-cover" alt="Card side image">
						<div class="card-body">
							Card with body and image
						</div>
					</div>
					<div class="card col-md-3">
						<img src="static/avatars/000m.jpg" class="w-100 h-100 object-cover" alt="Card side image">
						<div class="card-body">
							Card with body and image
						</div>
					</div>
					<div class="card col-md-3">
						<img src="static/avatars/000m.jpg" class="w-100 h-100 object-cover" alt="Card side image">
						<div class="card-body">
							Card with body and image
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="user-footer.jsp"></jsp:include>
</body>

</html>