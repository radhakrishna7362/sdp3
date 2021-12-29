<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<title>Guest Provider Registration</title>
<jsp:include page="styles.jsp"/>
</head>
<body>
<div class="wrapper">
<jsp:include page="header.jsp"></jsp:include>
</div>
<div class="page page-center">
    <div class="container-tight py-4">
      <div class="text-center mb-4">
          <h1>FeelHome - GuestProvider</h1>
      </div>
      <form class="card card-md" action="/guest-provider-register" method="POST" enctype='multipart/form-data'>
          <div class="card-body">
            <h2 class="card-title text-center mb-2">Create a new account</h2>
            <div class="text-center form-label invalid-feedback" style="font-size: medium;">
                <b>${msg}</b>
            </div>
            <div class="mb-3">
				<label for="userName" class="form-label">UserName</label>
				<input type="text" class="form-control" id="userName" name="userName" placeholder="UserName">
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">Email</label>
				<input type="email" class="form-control" id="email" name="email" placeholder="Email">
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Password</label>
				<input type="password" class="form-control" id="password" name="password" placeholder="Password">
			</div>
			<div class="mb-3">
				<label for="governmentId" class="form-label">Government Id</label>
				<input type="text" class="form-control" id="governmentId" name="governmentId" placeholder="Government Id">
			</div>
			<div class="mb-3">
				<label for="file" class="form-label">Government Id Proof</label>
				<input type="file" class="form-control" name="file" id="file">
			</div>
			<div class="mb-3">
				<label for="address" class="form-label">Address</label>
				<input type="text" class="form-control" id="address" name="address" placeholder="Address">
			</div>
            <div class="form-footer">
              <button type="submit" class="btn btn-primary w-100">Sign Up</button>
            </div>
            <div class="mt-2">
                <label class="form-check">
                <span class="form-label-description"><a href="/guest-provider-login">Sign In</a></span>
                </label>
            </div>
          </div>
      </form>
    </div>
</div>
</body>
</html>