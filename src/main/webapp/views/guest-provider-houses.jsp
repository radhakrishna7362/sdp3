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
		    <h3 class="card-title">Your Guest Houses</h3>
		    <table class="table table-striped">
		        <thead>
		        	<th scope="col">House Id</th>
		        	<th scope="col">Provider Id</th>
		        	<th scope="col">House Type</th>
		            <th scope="col">House City</th>
		            <th scope="col">House State</th>
		            <th scope="col">House Area</th>
		            <th scope="col">Status</th>
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
		                    <c:if test="${house.isApproval()}">  
							     Approved
							</c:if>
							<c:if test="${!house.isApproval()}">  
							     Pending
							</c:if>
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