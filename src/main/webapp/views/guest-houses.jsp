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
			<div class="card d-flex flex-column">
			  <div class="row row-0 flex-fill">
			    <div class="col-md-3">
			      <a href="#">
			        <img src="${house.getImage2() }" class="w-75 h-100 object-cover" alt="Card side image">
			      </a>
			    </div>
			    <div class="col">
			      <div class="card-body">
			      	
			      </div>
			    </div>
			  </div>
			</div>
		</c:forEach>
	</div>
</div>
</body>
</html>