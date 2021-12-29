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
		    <h3 class="card-title">Pending House Approvals</h3>
		    <table class="table table-striped">
		        <thead>
		        	<th scope="col">House Id</th>
		        	<th scope="col">Provider Id</th>
		        	<th scope="col">House Type</th>
		            <th scope="col">House City</th>
		            <th scope="col">House State</th>
		            <th scope="col">House Area</th>
		            <th scope="col">View</th>
		        </thead>
		        <tbody>
		        	<c:forEach var="house" items="${houses}">
		            <tr>
		                <td>${house.getId() }</td>
		                <td>${house.getProviderId() }</td>
						<td>${house.getHouseType() }</td>
		                <td>${house.getHouseCity() }</td>
		                <td>${house.getHouseState() }</td>
		                <td>${house.getHouseArea() }</td>
		                <td>
		                    <a href="/house-details/${house.getId()}"> <i class="fas fa-eye"></i> </a>
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