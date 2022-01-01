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
		<c:forEach var="house" items="${houses}">
			<div class="card d-flex flex-column mb-3">
			  <div class="row row-0 flex-fill">
			    <div class="col-md-4">
			      <a href="#">
			        <a href=${house.getImage2() }  class="w-50 h-100 object-cover" alt="Card side image">
			      </a>
			    </div>
			    <div class="col-md-8">
			      <div class="card-body">
			      	<div>
			      		Room Type: ${house.getHouseType() }
			      		<a href="/add-house-request/${house.getId() }" class="btn btn-primary">Request</a>
			      	</div>
			      </div>
			    </div>
			  </div>
			</div>
		</c:forEach>
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>