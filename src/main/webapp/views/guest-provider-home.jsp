<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<title>Guest Provider Home</title>
<jsp:include page="styles.jsp"/>
</head>

<body>
<jsp:include page="guest-provider-logout.jsp"/>
<span>${msg}</span>
<div class="m-2">
	<a href="add-guest-house" class="btn btn-success"><strong>+</strong> Guest House</a>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>