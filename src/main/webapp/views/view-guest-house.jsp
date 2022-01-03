<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Guest House</title>
<jsp:include page="styles.jsp"></jsp:include>
</head>
<body>
<jsp:include page="user-logout.jsp"></jsp:include>
<!-- 
<div class="row row-0 justify-content-end">
	<div class="col-sm-3" style="padding:25px">
		<div class="card"> 
			<div class="card-header">Rating</div> 
			<div class="card-body">${house.getRating() }</div>
		</div>
	</div>
</div>
 -->
<div class="row row-0 mt-4 justify-content-center">
	<div class="col-md-8">
		<div class="text-center"><h1>Feedback By Stayed Users</h1></div>
		<c:if test="${!comments.isEmpty() }">
			<div class="row row-0 justify-content-center">
				<c:forEach var="comment" items="${comments }">
					<div class="col-md-4" style="padding:25px">
						<div class="card">
							<div class="card-header">
								<div class="d-flex align-items-center">
	                            	<span class="avatar" style="background-image: url(/static/avatars/000m.jpg)"></span>
	                        		<div class="ms-3">
		                                <a href="#" class="text-body">Commented By UserId: ${comment.getUserId()}</a>
		                                <div class="text-muted">User</div>
		                            </div>
								</div>
							</div>
							<div class="card-body">
								<div class="text-muted">${comment.getCommentMsg() }</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</c:if>
		<c:if test="${comments.isEmpty() }">
			<div class="text-center"><h3>No Comments Yet</h3></div>
		</c:if>
	</div>
	<c:if test="${hasStayed }">
		<div class="col-md-4" style="padding:25px">
			<form class="card" action="/add-comment/${house.getId() }" method="GET">
	            <h2 class="card-header mb-2">Add Comment</h2>
				<div class="card-body">
					<div class="mb-3">
						<label for="commentMsg" class="form-label">Comment Message</label>
						<input type="text" class="form-control" id="commentMsg" name="commentMsg" placeholder="Write your comments" required>
					</div>
					<!-- <div class="mb-3">
						<label for="file" class="form-label">Image(Optional)</label>
						<input type="file" class="form-control" id="file" name="file">
					</div> -->
				</div>
		        <button class="card-footer btn btn-primary w-100" type="submit">Add</button>
			</form>
		</div>
	</c:if>
</div>
<div class="mt-4">
	<div class="text-center"><h1>Video Proof</h1></div>
	<div class="row row-0 justify-content-center">
		<div class="col-sm-4">
			<video width="500" height="240" controls>
			  <source src="/uploads/test.mp4" type="video/mp4">
			</video>
		</div>
	</div>
</div>
<jsp:include page="user-footer.jsp"></jsp:include>
</body>
</html>