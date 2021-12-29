<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Update Profile</title>
<jsp:include page="styles.jsp"/>
</head>
<body>
<jsp:include page="user-logout.jsp"/>
<div class="d-flex flex-column mt-3 mb-3">
    <div class="d-flex justify-content-sm-center">
        <div class="card text-dark col-lg-3 col-md-4">
            <h4 class="card-header d-flex justify-content-sm-center">
                Edit Profile
            </h4>
            <div class="card-body d-flex flex-column justify-content-sm-center">
                    <form method="POST" action="/user-profile-update">
                    	<div class="mb-3">
							<label for="id" class="form-label">Id</label>
							<input type="text" class="form-control" id="id" name="id" value="${user.getId() }" readonly placeholder="Id">
						</div>
                        <div class="mb-3">
							<label for="userName" class="form-label">UserName</label>
							<input type="text" class="form-control" id="userName" name="userName" value="${user.getUserName() }" placeholder="UserName">
						</div>
						<div class="mb-3">
							<label for="email" class="form-label">Email</label>
							<input type="email" class="form-control" id="email" name="email" value="${user.getEmail() }" placeholder="Email">
						</div>
						<div class="mb-3">
							<label for="governmentId" class="form-label">Government Id</label>
							<input type="text" class="form-control" id="governmentId" name="governmentId" value="${user.getGovernmentId() }" placeholder="Government Id">
						</div>
						<div class="mb-3">
							<label for="role" class="form-label">Role</label>
							<input type="text" class="form-control" id="role" name="role" value="${user.getRole() }" readonly placeholder="Role">
						</div>
						<div class="mb-3">
							<label for="password" class="form-label">Password</label>
							<input type="password" class="form-control" id="password" name="password" value="${user.getPassword() }" readonly placeholder="Password">
						</div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-outline-success">Edit</button>
                        </div>
                    </form>
            </div>
            <div class="card-footer text-center">
                <a href="/user-profile/${user.getId() }"><i class="fa fa-arrow-left"></i></a>
            </div>
        </div>
    </div>
</div>
</body>
</html>