<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User House Requests</title>
<jsp:include page="styles.jsp"></jsp:include>
</head>
<body>
<jsp:include page="user-logout.jsp"></jsp:include>
<div class="m-2">
	<div class="col-md-4">
		<div class="card">
			<div class="card-header">
				Your Current Status
			</div>
			<div class="card-body">
				<c:if test="${currentStay}">
					${userHouseRequestData.getHouse().getId() }
				</c:if>
				<c:if test="${!currentStay }">
					No Stay Currently
				</c:if>
			</div>
		</div>
	</div>
</div>
</body>
</html>