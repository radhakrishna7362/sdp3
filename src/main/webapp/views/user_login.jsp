<!DOCTYPE html>
<html>

<head>
<title>User Login</title>
<jsp:include page="styles.jsp"/>
</head>
<body>
<div class="wrapper">
<jsp:include page="header.jsp"></jsp:include>
</div>
<div class="page-center">
    <div class="container-tight py-4">
      <div class="text-center mb-4">
          <h1>FeelHome - User</h1>
      </div>
      <form class="card card-md" action="/login" method="POST">
          <div class="card-body">
            <h2 class="card-title text-center mb-2">Login to your account</h2>
            <div class="text-center form-label invalid-feedback" style="font-size: medium;">
                <b>${msg}</b>
            </div>
            <div class="mb-3">
				<label for="userName" class="form-label">UserName</label>
				<input type="text" class="form-control" id="userName" name="userName" placeholder="UserName">
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Password</label>
				<input type="password" class="form-control" id="password" name="password" placeholder="Password">
			</div>
            <div class="form-footer">
              <button type="submit" class="btn btn-primary w-100">Sign in</button>
            </div>
            <div class="mt-2 mb-2">
                <label class="form-check">
                	<span class="form-label-description"><a href="/register">Sign Up</a></span>
                </label>
          	</div>
          </div>
      </form>
    </div>
</div>
	
</body>
</html>