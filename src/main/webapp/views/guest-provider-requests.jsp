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
			   	Provider Id:${houseRequestData.getGuestProvider().getId() }<br>
			   	House Id:${houseRequestData.getHouse().getId() }
		   		<c:forEach var="u" items="${houseRequestData.getUsers()}" varStatus="status">
			   		Request Id:${houseRequestData.getHouseRequests().get(status.index).getId() }
			   		UserId:${u.getId() }
			   		UserName:${u.getUserName() }
			   		<c:if test="${!houseRequestData.getHouseRequests().get(status.index).getApproval()}">  
						<a href="/accept-house-request/${houseRequestData.getHouseRequests().get(status.index).getId() }">Accept</a>
					</c:if>
					<c:if test="${houseRequestData.getHouseRequests().get(status.index).getApproval()}">  
						Assigned
					</c:if>				
			   		<br>
			   	</c:forEach>
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
		   		<c:forEach var="u" items="${rejectedHouseRequestData.getUsers()}" varStatus="status">
			   		Request Id:${rejectedHouseRequestData.getHouseRequests().get(status.index).getId() }
			   		UserId:${u.getId() }
			   		UserName:${u.getUserName() }
			   		<c:if test="${!rejectedHouseRequestData.getHouseRequests().get(status.index).getApproval()}">  
						<a href="/accept-house-request/${houseRequestData.getRequestIds().get(status.index) }">Accept</a>
					</c:if>
					<c:if test="${rejectedHouseRequestData.getHouseRequests().get(status.index).getApproval()}">  
						Assigned
					</c:if>				
			   		<br>
			   	</c:forEach>
		   	</c:if>
		   	<c:if test="${rejectedHouseRequestData.getUsers().isEmpty() }">
		   		No Rejected Requests
		   	</c:if>
	    </div>
	</div>
</div>
</body>
</html>