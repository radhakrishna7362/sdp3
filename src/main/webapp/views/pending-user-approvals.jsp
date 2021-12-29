<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<title>Pending User Approvals</title>
<jsp:include page="styles.jsp"/>
</head>

<body>
<jsp:include page="admin-logout.jsp"/>
<div class="m-2">
	<div class="card">
	    <div class="card-body">	    
		    <h3 class="card-title">Pending User Approvals</h3>
		    <table class="table table-striped">
		        <thead>
		        	<th scope="col">UserId</th>
		        	<th scope="col">Name</th>
		        	<th scope="col">Phone No</th>
		            <th scope="col">UserName</th>
		            <th scope="col">Email</th>
		            <th scope="col">Government Id</th>
		            <th scope="col">View</th>
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
		                <td>
		                    <a href="/user-details/${user.getId()}"> <i class="fas fa-eye"></i> </a>
		                </td>
		            </tr>
		            </c:forEach>
		        </tbody>
		    </table>
	    </div>
	</div>
</div>
</body>
</html>