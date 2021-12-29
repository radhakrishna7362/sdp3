<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<title>Pending GuestProvider Approvals</title>
<jsp:include page="styles.jsp"/>
</head>

<body>
<jsp:include page="admin-logout.jsp"/>
<div class="m-2">
    <div class="card">
    	<div class="card-body">
		    <h3 class="card-title">Pending GuestProvider Approvals</h3>
    		<table class="table table-striped">
		        <thead>
		        	<th scope="col">GuestProvider Id</th>
		        	<th scope="col">GuestProvider Name</th>
		        	<th scope="col">GuestProvider PhoneNo</th>
		            <th scope="col">GuestProvider UserName</th>
		            <th scope="col">GuestProvider Email</th>
		            <th scope="col">GuestProvider Government Id</th>
		            <th scope="col">GuestProvider Address</th>
		            <th scope="col">View</th>
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
		                <td>
		                    <a href="/guest-provider-details/${g.getId()}"> <i class="fas fa-eye"></i> </a>
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