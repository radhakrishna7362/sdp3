<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
<jsp:include page="styles.jsp"/>
</head>
<body>
<jsp:include page="user-logout.jsp"/>
<div class="d-flex flex-column mt-3 mb-3">
    <div class="d-flex justify-content-sm-center">
        <div class="card text-dark col-md-3">
            <h4 class="card-header d-flex justify-content-sm-center">
                Profile
            </h4>
            <div class="card-body d-flex flex-column justify-content-sm-center">
                    <form method="POST" novalidate>
                    	<div class="mb-3">
							<label for="id" class="form-label">Id</label>
							<input type="text" class="form-control" id="id" name="id" value="${user.getId() }" readonly placeholder="Id">
						</div>
                        <div class="mb-3">
							<label for="userName" class="form-label">UserName</label>
							<input type="text" class="form-control" id="userName" name="userName" value="${user.getUserName() }" readonly placeholder="UserName">
						</div>
						<div class="mb-3">
							<label for="phoneNo" class="form-label">Phone No</label>
							<input type="text" class="form-control" id="phoneNo" name="phoneNo" value="${user.getPhoneNo() }" readonly placeholder="Phone No">
						</div>
						<div class="mb-3">
							<label for="firstName" class="form-label">First Name</label>
							<input type="text" class="form-control" id="firstName" name="firstName" value="${user.getFirstName() }" readonly placeholder="First Name">
						</div>
						<div class="mb-3">
							<label for="lastName" class="form-label">Last Name</label>
							<input type="text" class="form-control" id="lastName" name="lastName" value="${user.getLastName() }" readonly placeholder="Last Name">
						</div>
						<div class="mb-3">
							<label for="email" class="form-label">Email</label>
							<input type="email" class="form-control" id="email" name="email" value="${user.getEmail() }" readonly placeholder="Email">
						</div>
						<div class="mb-3">
							<label for="governmentId" class="form-label">Government Id</label>
							<input type="text" class="form-control" id="governmentId" name="governmentId" value="${user.getGovernmentId() }" readonly placeholder="Government Id">
						</div>
						<div class="mb-3">
							<label for="role" class="form-label">Role</label>
							<input type="text" class="form-control" id="role" name="role" value="${user.getRole() }" readonly placeholder="Role">
						</div>
						<div class="mb-3">
							<label for="password" class="form-label">Password</label>
							<input type="password" class="form-control" id="password" name="password" value="${user.getPassword() }" readonly placeholder="Password">
						</div>
                    </form>
            </div>
            <div class="card-footer text-center">
                <a href="/edit-user-profile/${user.getId() }"><i class="fa fa-edit"></i></a>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>