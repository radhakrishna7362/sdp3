<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Admin Home</title>
<jsp:include page="styles.jsp"/>
</head>

<body>
<jsp:include page="admin-logout.jsp"/>
<span>${msg}</span>

<div class="m-2">
    <div class="card">
    	<div class="card-body">
		    <h3 class="card-title">GuestProviders</h3>
    		<table class="table table-striped">
		        <thead>
		        	<th scope="col">GuestProvider Id</th>
		        	<th scope="col">GuestProvider Name</th>
		        	<th scope="col">GuestProvider PhoneNo</th>
		            <th scope="col">GuestProvider UserName</th>
		            <th scope="col">GuestProvider Email</th>
		            <th scope="col">GuestProvider Government Id</th>
		            <th scope="col">GuestProvider Address</th>
		            <th scope="col">GuestProvider Government Id Proof</th>
		        </thead>
		        <tbody>
		        	<c:forEach var="g" items="${gp}">
		            <tr>
		                <td>${g.getId() }</td>
		                <td>${g.getFirstName() } ${g.getLastName() }</td>
		                <td>${g.getPhoneNo() }</td>
		                <td>${g.getUserName() }</td>
		                <td>${g.getEmail() }</td>
		                <td>${g.getGovernmentId() }</td>
		                <td>${g.getAddress() }</td>
		                <td><a class="btn-sm btn-primary" href="/uploads/${g.getGovernmentIdProof() }" target="_blank">Read more</a></td>
		            </tr>
		            </c:forEach>
		        </tbody>
		    </table>
    	</div>
    </div>
</div>

<div class="m-2">
	<div class="card">
	    <div class="card-body">	    
		    <h3 class="card-title">Users</h3>
		    <table class="table table-striped">
		        <thead>
		        	<th scope="col">UserId</th>
		        	<th scope="col">Name</th>
		        	<th scope="col">Phone No</th>
		            <th scope="col">UserName</th>
		            <th scope="col">Email</th>
		            <th scope="col">Government Id</th>
		            <th scope="col">Government Id Proof</th>
		        </thead>
		        <tbody>
		        	<c:forEach var="user" items="${users}">
		            <tr>
		                <td>${user.getId() }</td>
		                <td>${user.getFirstName() } ${user.getLastName() }</td>
						<td>${user.getPhoneNo() }</td>
		                <td>${user.getUserName() }</td>
		                <td>${user.getEmail() }</td>
		                <td>${user.getGovernmentId() }</td>
		                <td><a class="btn-sm btn-primary" href="/uploads/${user.getGovernmentIdProof() }" target="_blank">Read more</a></td>
		            </tr>
		            </c:forEach>
		        </tbody>
		    </table>
	    </div>
	</div>
</div>

<div class="m-2">
	<div class="card">
	    <div class="card-body">	    
		    <h3 class="card-title">Houses</h3>
		    <table class="table table-striped">
		        <thead>
		        	<th scope="col">HouseId</th>
		        	<th scope="col">City</th>
		        	<th scope="col">State</th>
		            <th scope="col">Area</th>
		            <th scope="col">ProviderId</th>
		            <th scope="col">Type</th>
		            <th scope="col">HouseNo</th>
		        </thead>
		        <tbody>
		        	<c:forEach var="house" items="${houses}">
		            <tr>
		                <td>${house.getId() }</td>
		                <td>${house.getHouseCity() }</td>
						<td>${house.getHouseState() }</td>
		                <td>${house.getHouseArea() }</td>
		                <td>${house.getProviderId() }</td>
		                <td>${house.getHouseType() }</td>
		                <td>${house.getHouseNo() }</td>
		            </tr>
		            </c:forEach>
		        </tbody>
		    </table>
	    </div>
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>