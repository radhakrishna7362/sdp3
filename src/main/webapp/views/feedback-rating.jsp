<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feedback Rating</title>
<jsp:include page="styles.jsp"></jsp:include>
</head>
<body>
<jsp:include page="user-logout.jsp"></jsp:include>
<div class="mt-2 row row-0 justify-content-center">
	<div class="col-md-4">
		<form class="card card-md" action="/submit-feedback/${houseId }" method="GET">
            <h2 class="card-header mb-2">Provide Rating</h2>
			<div class="card-body">
				<div class="mb-3">
					<label for="rating" class="form-label">Rating</label>
					<select name="rating" class="form-select">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
				</div>
	            <div class="form-footer">
	              <button type="submit" class="btn btn-primary w-100">Submit</button>
	            </div>
			</div>
		</form>
	</div>
</div>
<jsp:include page="user-footer.jsp"></jsp:include>
</body>
</html>