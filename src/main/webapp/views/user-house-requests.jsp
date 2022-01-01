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
        <div class="offset-1 col-md-3 mb-3">
            <div class="card d-flex flex-column">
                <h3 class="card-header">Current Stay House Details</h3>
                <c:if test="${currentStay}">
                    <a href="#">
                        <img class="card-img-top" src="/uploads/${userHouseRequestData.getHouse().getImage1() }"
                            alt="How do you know she is a witch?">
                    </a>
                    <div class="card-body d-flex flex-column">
                        <h3 class="card-title"><a href="#">Provider UserName:
                                ${userHouseRequestData.getGuestProvider().getUserName() }
                            </a></h3>
                        <div class="text-muted">House Type:
                            ${userHouseRequestData.getHouse().getHouseType() } <br /> House
                            City: ${userHouseRequestData.getHouse().getHouseCity() }</div>
                        <div class="d-flex align-items-center pt-4 mt-auto">
                            <span class="avatar" style="background-image: url(/static/avatars/000m.jpg)"></span>
                            <div class="ms-3">
                                <a href="#" class="text-body">${userHouseRequestData.getGuestProvider().getFirstName()
                                    }
                                    ${userHouseRequestData.getGuestProvider().getLastName()
                                    }</a>
                                <div class="text-muted">Provider</div>
                            </div>
                        </div>
                    </div>
                    <a class="card-footer btn btn-danger"
                        href="/end-stay/${userHouseRequestData.getHouseRequests().getId() }">End
                        Stay
                    </a>
                </c:if>
                <c:if test="${!currentStay }">
                	<div class="card-body">
    		        	No Stay Currently
                	</div>
                </c:if>
            </div>
        </div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>

</html>