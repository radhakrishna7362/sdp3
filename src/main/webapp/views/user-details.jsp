<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>User Details</title>
<jsp:include page="styles.jsp"></jsp:include>
</head>

<body>
<jsp:include page="admin-logout.jsp"/>
<div class="m-2">
	<h1 align='center'>User Approval</h1>
	<div class="col-sm-6">
    	<div class="card">
    		<div class="card-body">
    			<table class="table table-striped">
			        <tbody>
			            <tr>
			            	<th>UserId</th>
			                <td>${user.getId() }</td>
			            </tr>
			            <tr>
			            	<th>Name</th>
			                <td>${user.getFirstName() } ${user.getLastName() }</td>
			            </tr>
			            <tr>
			            	<th>UserName</th>
			                <td>${user.getUserName() }</td>
			            </tr>
			            <tr>
			            	<th>PhoneNo</th>
			                <td>${user.getPhoneNo() }</td>
			            </tr>
			            <tr>
			            	<th>Email</th>
			            	<td>${user.getEmail() }</td>
			            </tr>
			            <tr>
			            	<th>GovernmentId</th>
			                <td>${user.getGovernmentId() }</td>
			            </tr>
			        </tbody>
			    </table>
    		</div>
    	</div>
    </div>
</div>
<div align='center'>
<a class="btn btn-primary" href='/user-approval/${user.getId()}'>Approve</a>
<a class="btn btn-dark" href='/pending-user-approvals'>Back</a>
</div>
</body>

</html>