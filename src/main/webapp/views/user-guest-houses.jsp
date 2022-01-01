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
		<div class="row row-0">
		<c:forEach var="house" items="${userHouseData.getHouses()}" varStatus="status">
				<div class="col-md-4" style="padding:25px">
					<div class="card d-flex flex-column">
						<a href="/view-guest-house/${house.getId() }">
							<img class="card-img-top" src="/uploads/${house.getImage2() }" height=400px alt="Card side image">
						</a>
						<div class="card-body d-flex flex-column">
							 <div class="text-muted">
							 	House Id: ${house.getId() } <br/>
							 	House Type: ${house.getHouseType() } <br/>
							 	House City: ${house.getHouseCity() } <br/>
							 	House Rating: ${house.getRating() }
							 </div>
							 <div class="d-flex align-items-center pt-4 mt-auto">
                            	<span class="avatar" style="background-image: url(/static/avatars/000m.jpg)"></span>
                        		<div class="ms-3">
	                                <a href="#" class="text-body">${userHouseData.getGuestProvider().get(status.index).getFirstName()
	                                    }
	                                    ${userHouseData.getGuestProvider().get(status.index).getLastName()
	                                    }</a>
	                                <div class="text-muted">Provider</div>
	                            </div>
							</div>
						</div>
						<c:if test="${!userHouseData.getIsRequested().get(status.index) && !userHouseData.getIsPending().get(status.index) && !userHouseData.getIsCompleted().get(status.index) }">
							<c:if test="${userHouseData.isCurrentStay() }">
								<span class="card-footer btn btn-info">End the Current Stay</span>
							</c:if>
							<c:if test="${!userHouseData.isCurrentStay() }">
								<a class="card-footer btn btn-success" href="/add-house-request/${house.getId() }" class="btn btn-primary">Request</a>
							</c:if>
						</c:if>
						<c:if test="${userHouseData.getIsRequested().get(status.index) && !userHouseData.getIsPending().get(status.index) && !userHouseData.getIsCompleted().get(status.index)}">
							<span class="card-footer btn btn-info">Have a Nice Stay</span>
						</c:if>
						<c:if test="${!userHouseData.getIsRequested().get(status.index) && userHouseData.getIsPending().get(status.index)}">
							<span class="card-footer btn btn-danger">Pending</span> 
						</c:if>
						<c:if test="${!userHouseData.getIsRequested().get(status.index) && !userHouseData.getIsPending().get(status.index) && userHouseData.getIsCompleted().get(status.index)}">
							<c:if test="${userHouseData.isCurrentStay() }">
								<span class="card-footer btn btn-info">End the Current Stay</span>
							</c:if>
							<c:if test="${!userHouseData.isCurrentStay() }">
								<a class="card-footer btn btn-info" href="/add-house-request/${house.getId() }" class="btn btn-primary">Want to Stay Again?</a>
							</c:if>
						</c:if>
					</div>
				</div>
		</c:forEach>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
		