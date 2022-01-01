<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Guest Houses</title>
<jsp:include page="styles.jsp"></jsp:include>
</head>
<body>
<jsp:include page="user-logout.jsp"></jsp:include>
<div class="row row-0">
	<div class="offset-1 col-10 py-4">
		<h1>Guest Houses</h1>
		<c:forEach var="house" items="${userHouseData.getHouses()}" varStatus="status">
			<div class="card d-flex flex-column mb-3">
			  <div class="row row-0 flex-fill">
			    <div class="col-md-4">
			      <a href="#">
			        <img src="/uploads/${house.getImage2() }" style="padding:2px;border:1px solid white;border-radius:5px" width=500px height=250px class="object-cover" alt="Card side image">
			      </a>
			    </div>
			    <div class="col-md-8">
			      <div class="card-body">
			      	<div>
			      		Room Type: ${house.getHouseType() }<br/><br/>
			      		<c:if test="${!userHouseData.getIsRequested().get(status.index) && !userHouseData.getIsPending().get(status.index) && !userHouseData.getIsCompleted().get(status.index) }">
							<c:if test="${userHouseData.isCurrentStay() }">
								End the Current Stay
							</c:if>
							<c:if test="${!userHouseData.isCurrentStay() }">
								<a href="/add-house-request/${house.getId() }" class="btn btn-primary">Request</a>
							</c:if>
						</c:if>
						<c:if test="${userHouseData.getIsRequested().get(status.index) && !userHouseData.getIsPending().get(status.index) && !userHouseData.getIsCompleted().get(status.index)}">
							Have a Nice Stay
						</c:if>
						<c:if test="${!userHouseData.getIsRequested().get(status.index) && userHouseData.getIsPending().get(status.index) && !userHouseData.getIsCompleted().get(status.index)}">
							Pending
						</c:if>
						<c:if test="${!userHouseData.getIsRequested().get(status.index) && !userHouseData.getIsPending().get(status.index) && userHouseData.getIsCompleted().get(status.index)}">
							<c:if test="${userHouseData.isCurrentStay() }">
								End the Current Stay
							</c:if>
							<c:if test="${!userHouseData.isCurrentStay() }">
								<a href="/add-house-request/${house.getId() }" class="btn btn-primary">Want to Stay Again?</a>
							</c:if>
						</c:if>
			      	</div>
			      </div>
			    </div>
			  </div>
			</div>
		</c:forEach>
	</div>
</div>
</body>
</html>