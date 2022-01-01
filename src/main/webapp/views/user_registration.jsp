<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<title>User Registration</title>
<jsp:include page="styles.jsp"/>
</head>

<body>
<div class="wrapper">
<jsp:include page="header.jsp"></jsp:include>
</div>
<div class="page page-center">
    <div class="container-tight py-4">
      <div class="text-center mb-4">
          <h1>FeelHome - User</h1>
      </div>
      <form class="card card-md" action="/register" method="POST" enctype='multipart/form-data'>
          <div class="card-body">
            <h2 class="card-title text-center mb-2">Create a new account</h2>
            <div class="text-center form-label invalid-feedback" style="font-size: medium;">
                <b>${msg}</b>
            </div>
            <div class="mb-3">
				<label for="userName" class="form-label">UserName</label>
				<input type="text" class="form-control" id="userName" pattern="^[a-zA-Z]+$" name="userName" required placeholder="UserName">
				<small>Must have only alphabets</small>
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">Email</label>
				<input type="email" class="form-control" id="email" pattern="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$" name="email" required placeholder="Email">
				<small>Must be a valid email id</small>
			</div>
			<div class="mb-3">
				<label for="phoneNo" class="form-label">Phone No</label>
				<input type="text" class="form-control" id="phoneNo" name="phoneNo" pattern="^[0-9]{10}$" required placeholder="Phone No">
				<small>Must have only 10 digits</small>
			</div>
			<div class="mb-3">
				<label for="firstName" class="form-label">First Name</label>
				<input type="text" class="form-control" id="firstName" name="firstName" pattern="^[a-zA-Z]+$" required placeholder="First Name">
				<small>Must have only alphabets</small>
			</div>
			<div class="mb-3">
				<label for="lastName" class="form-label">Last Name</label>
				<input type="text" class="form-control" id="lastName" name="lastName" pattern="^[a-zA-Z]+$" required placeholder="Last Name">
				<small>Must have only alphabets</small>
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Password</label>
				<input type="password" class="form-control" id="password" name="password" required placeholder="Password">
			</div>
			<div class="mb-3">
				<label for="governmentId" class="form-label">Government Id</label>
				<input type="text" class="form-control" id="governmentId" name="governmentId" pattern="^[a-zA-Z0-9]*$" required placeholder="Government Id">
				<small>Must have only digits and alphabets</small>
			</div>
			<div class="mb-3">
				<label for="file" class="form-label">GovernmentId Proof</label>
				<input type="file" class="form-control" id="file" accept="application/pdf" required name="file">
			</div>
            <div class="mb-3">
                <label class="form-check">
                <span class="form-label-description"><a href="/login">Sign In</a></span>
                </label>
            </div>
            <div class="form-footer">
              <button type="submit" class="btn btn-primary w-100">Sign Up</button>
            </div>
          </div>
      </form>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>