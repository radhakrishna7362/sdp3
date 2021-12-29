<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Guest House</title>
<jsp:include page="styles.jsp"/>
</head>
<body>
<jsp:include page="guest-provider-logout.jsp"/>
<div class="page page-center">
    <div class="container-tight py-4">
      <div class="text-center mb-4">
          <h1>Add Guest House</h1>
      </div>

	<form class="card card-md" action="/add-guest-house" method="POST" enctype='multipart/form-data'>
		<div class="card-body">
			<div class="row row-0">
				<div class="col-sm-5">
					<div class="mb-3">
						<label for="providerId" class="form-label">Provider Id</label>
						<input type="text" class="form-control" id="providerId" name="providerId" value="${userId }" readonly>
					</div>
					<div class="mb-3">
						<label for="houseType" class="form-label">House Type</label>
						<input type="text" class="form-control" id="houseType" name="houseType" placeholder="House Type">
					</div>
					<div class="mb-3">
						<label for="houseCity" class="form-label">House City</label>
						<input type="text" class="form-control" id="houseCity" name="houseCity" placeholder="House City">
					</div>
					<div class="mb-3">
						<label for="houseState" class="form-label">House State</label>
						<input type="text" class="form-control" id="houseState" name="houseState" placeholder="House State">
					</div>
					<div class="mb-3">
						<label for="houseArea" class="form-label">House Area</label>
						<input type="text" class="form-control" id="houseArea" name="houseArea" placeholder="House Area">
					</div>
					<div class="mb-3">
						<label for="houseNo" class="form-label">House No</label>
						<input type="text" class="form-control" id="houseNo" name="houseNo" placeholder="House No">
					</div>
				</div>
				<div class="offset-1 col-sm-6">
					<div class="mb-3">
						<label for="file" class="form-label">House Proof</label>
						<input type="file" class="form-control" id="file" name="file">
					</div>
					<div class="mb-3">
						<label for="img1" class="form-label">Image 1</label>
						<input type="file" class="form-control" id="img1" name="img1">
					</div>
					<div class="mb-3">
						<label for="img2" class="form-label">Image 2</label>
						<input type="file" class="form-control" id="img2" name="img2">
					</div>
					<div class="mb-3">
						<label for="img3" class="form-label">Image 3</label>
						<input type="file" class="form-control" id="img3" name="img3">
					</div>
					<div class="mb-3">
						<label for="img4" class="form-label">Image 4</label>
						<input type="file" class="form-control" id="img4" name="img4">
					</div>
					<div class="mb-3">
						<label for="img5" class="form-label">Image 5</label>
						<input type="file" class="form-control" id="img5" name="img5">
					</div>
				</div>
			</div>
			<div class="form-footer">
				<button type="submit" class="btn btn-primary w-100">Add</button>
			</div>
			<div class="mt-2">
                <label class="form-check">
                <span class="form-label-description"><a href="/guest-provider-home">Back</a></span>
                </label>
            </div>
		</div>
	</form>
	</div>
</div>
</body>
</html>