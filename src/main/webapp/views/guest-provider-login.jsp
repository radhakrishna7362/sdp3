<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<title>Guest Provider Login</title>
<jsp:include page="styles.jsp"/>
</head>

<body>
<div class="wrapper">
<jsp:include page="header.jsp"></jsp:include>
</div>
<div class="page-center">
    <div class="container-tight py-4">
      <div class="text-center mb-4">
          <h1>FeelHome - GuestProvider</h1>
      </div>
      <form class="card card-md" action="/guest-provider-login" method="POST">
          <div class="card-body">
            <h2 class="card-title text-center mb-2">Login to your account</h2>
            <div class="text-center form-label invalid-feedback" style="font-size: medium;">
                <b>${msg}</b>
            </div>
            <div class="mb-3">
				<label for="userName" class="form-label">UserName</label>
				<input type="text" class="form-control" id="userName" required name="userName" placeholder="UserName">
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Password</label>
				<input type="password" class="form-control" id="password" required name="password" placeholder="Password">
			</div>
            <div class="form-footer">
              <button type="submit" class="btn btn-primary w-100">Sign in</button>
            </div>
            <div class="mt-2">
                <label class="form-check">
                	<span class="form-label-description"><a href="/guest-provider-register">Sign Up</a></span>
                </label>
          	</div>
          </div>
      </form>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>