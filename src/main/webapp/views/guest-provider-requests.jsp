<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Guest Provider Houses</title>
<jsp:include page="styles.jsp"></jsp:include>
</head>
<body>
<jsp:include page="guest-provider-logout.jsp"/>
<div class="m-2">
	<div class="card">
	    <div class="card-body">	    
		    <h3 class="card-title">Guest House Requests</h3>
		   	<c:if test="${!houseRequestData.getUsers().isEmpty()}">
			   	<table class="table table-striped">
			        <thead>
			        	<th scope="col">House Request Id</th>
			        	<th scope="col">House Id</th>
			        	<th scope="col">Provider UserName</th>
			        	<th scope="col">House Type</th>
			            <th scope="col">House City</th>
			            <th scope="col">House State</th>
			            <th scope="col">House Area</th>
			            <th scope="col">User Id</th>
			            <th scope="col">User Name</th>
			            <th scope="col">Status</th>
			        </thead>
			        <tbody>
				   		<c:forEach var="u" items="${houseRequestData.getUsers()}" varStatus="status">
					   		<tr>
					   			<td>${houseRequestData.getHouseRequests().get(status.index).getId() }</td>
						   		<td>${houseRequestData.getHouse().getId() }</td>
						   		<td>${houseRequestData.getGuestProvider().getUserName() }</td>
						   		<td>${houseRequestData.getHouse().getHouseType() }</td>
						   		<td>${houseRequestData.getHouse().getHouseCity() }</td> 								   		
						   		<td>${houseRequestData.getHouse().getHouseState() }</td>
						   		<td>${houseRequestData.getHouse().getHouseArea() }</td>
						   		<td>${u.getId() }</td>
						   		<td>${u.getUserName() }</td>
								<td>
									<c:if test="${!houseRequestData.getHouseRequests().get(status.index).getApproval()}">  
										<a class="btn-sm btn-primary" href="/accept-house-request/${houseRequestData.getHouseRequests().get(status.index).getId() }">Accept</a>
										
										<a class="btn-sm btn-danger" href="/reject-house-request/${houseRequestData.getHouseRequests().get(status.index).getId() }">Reject</a>
									</c:if>
									<c:if test="${houseRequestData.getHouseRequests().get(status.index).getApproval()}">  
										<span class="badge bg-green">Assigned</span>
									</c:if>
								</td>
				        	</tr>
					   	</c:forEach>
			        </tbody>
			    </table>
		   	</c:if>
		   	<c:if test="${houseRequestData.getUsers().isEmpty()}">
		   		No House Requests
		   	</c:if>
	    </div>
	</div>
</div>

<div class="m-2">
	<div class="card">
	    <div class="card-body">	    
		    <h3 class="card-title">Rejected Requests</h3>
		   	<c:if test="${!rejectedHouseRequestData.getUsers().isEmpty()}">
		   		<table class="table table-striped">
			        <thead>
			        	<th scope="col">House Request Id</th>
			        	<th scope="col">House Id</th>
			        	<th scope="col">Provider UserName</th>
			        	<th scope="col">House Type</th>
			            <th scope="col">House City</th>
			            <th scope="col">House State</th>
			            <th scope="col">House Area</th>
			            <th scope="col">User Id</th>
			            <th scope="col">User Name</th>
			        </thead>
			        <tbody>
				   		<c:forEach var="u" items="${rejectedHouseRequestData.getUsers()}" varStatus="status">
					   		<tr>
					   			<td>${rejectedHouseRequestData.getRejectedHouseRequests().get(status.index).getId() }</td>
						   		<td>${rejectedHouseRequestData.getHouse().getId() }</td>
						   		<td>${rejectedHouseRequestData.getGuestProvider().getUserName() }</td>
						   		<td>${rejectedHouseRequestData.getHouse().getHouseType() }</td>
						   		<td>${rejectedHouseRequestData.getHouse().getHouseCity() }</td> 								   		
						   		<td>${rejectedHouseRequestData.getHouse().getHouseState() }</td>
						   		<td>${rejectedHouseRequestData.getHouse().getHouseArea() }</td>
						   		<td>${u.getId() }</td>
						   		<td>${u.getUserName() }</td>
				        	</tr>
					   	</c:forEach>
			        </tbody>
			    </table>
		   	</c:if>
		   	<c:if test="${rejectedHouseRequestData.getUsers().isEmpty() }">
		   		No Rejected Requests
		   	</c:if>
	    </div>
	</div>
</div>
<div class="m-2">
	<div class="card">
	    <div class="card-body">	    
		    <h3 class="card-title">Completed House Requests</h3>
		   	<c:if test="${!completedHouseRequestData.getUsers().isEmpty()}">
		   		<table class="table table-striped">
			        <thead>
			        	<th scope="col">House Request Id</th>
			        	<th scope="col">House Id</th>
			        	<th scope="col">Provider UserName</th>
			        	<th scope="col">House Type</th>
			            <th scope="col">House City</th>
			            <th scope="col">House State</th>
			            <th scope="col">House Area</th>
			            <th scope="col">User Id</th>
			            <th scope="col">User Name</th>
			        </thead>
			        <tbody>
				   		<c:forEach var="u" items="${completedHouseRequestData.getUsers()}" varStatus="status">
					   		<tr>
					   			<td>${completedHouseRequestData.getCompletedHouseRequests().get(status.index).getId() }</td>
						   		<td>${completedHouseRequestData.getHouse().getId() }</td>
						   		<td>${completedHouseRequestData.getGuestProvider().getUserName() }</td>
						   		<td>${completedHouseRequestData.getHouse().getHouseType() }</td>
						   		<td>${completedHouseRequestData.getHouse().getHouseCity() }</td> 								   		
						   		<td>${completedHouseRequestData.getHouse().getHouseState() }</td>
						   		<td>${completedHouseRequestData.getHouse().getHouseArea() }</td>
						   		<td>${u.getId() }</td>
						   		<td>${u.getUserName() }</td>
				        	</tr>
					   	</c:forEach>
			        </tbody>
			    </table>
		   	</c:if>
		   	<c:if test="${completedHouseRequestData.getUsers().isEmpty() }">
		   		No Rejected Requests
		   	</c:if>
	    </div>
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>		    
</html>