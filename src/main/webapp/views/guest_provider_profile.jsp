<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<title>Guest Provider Profile</title>
<jsp:include page="styles.jsp"/>
</head>
<body>
<div class="wrapper">
<jsp:include page="guest-provider-logout.jsp"/>
</div>
<div class="d-flex flex-column mt-3 mb-3">
    <div class="d-flex justify-content-sm-center">
        <div class="card text-dark col-lg-3 col-md-4">
            <h4 class="card-header d-flex justify-content-sm-center">
                Profile
            </h4>
            <div class="card-body d-flex flex-column justify-content-sm-center">
                    <form method="POST" novalidate">
                    	<div class="mb-3">
							<label for="id" class="form-label">Id</label>
							<input type="text" class="form-control" id="id" name="id" value="${gp.getId() }" readonly placeholder="Id">
						</div>
                    	<div class="mb-3">
							<label for="userName" class="form-label">UserName</label>
							<input type="text" class="form-control" id="userName" value="${gp.getUserName() }" readonly name="userName" placeholder="UserName">
						</div>
						<div class="mb-3">
							<label for="email" class="form-label">Email</label>
							<input type="email" class="form-control" id="email" name="email" value="${gp.getEmail() }" readonly placeholder="Email">
						</div>
						<div class="mb-3">
							<label for="phoneNo" class="form-label">Phone No</label>
							<input type="text" class="form-control" id="phoneNo" name="phoneNo" value="${gp.getPhoneNo() }" readonly placeholder="Phone No">
						</div>
						<div class="mb-3">
							<label for="firstName" class="form-label">First Name</label>
							<input type="text" class="form-control" id="firstName" name="firstName" value="${gp.getFirstName() }" readonly placeholder="First Name">
						</div>
						<div class="mb-3">
							<label for="lastName" class="form-label">Last Name</label>
							<input type="text" class="form-control" id="lastName" name="lastName" value="${gp.getLastName() }" readonly placeholder="Last Name">
						</div>
						<div class="mb-3">
							<label for="address" class="form-label">Address</label>
							<input type="text" class="form-control" id="address" name="address" value="${gp.getAddress() }" readonly placeholder="Address">
						</div>
                    </form>
            </div>
            <div class="card-footer text-center">
                <a href="/edit-guest-provider-profile/${gp.getId() }"><i class="fa fa-edit"></i></a>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>