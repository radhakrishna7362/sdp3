<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Guest Provider Details</title>
<jsp:include page="styles.jsp"></jsp:include>
</head>

<body>
<jsp:include page="admin-logout.jsp"/>

<div class="m-2">
	<h1 align='center'>Guest Provider Approval</h1>
    <div class="col-sm-6">
    	<div class="card">
    		<div class="card-body">
    			<table class="table table-striped">
			        <tbody>
			            <tr>
			            	<th>GuestProvider Id</th>
			                <td>${gp.getId() }</td>
			            </tr>
			            <tr>
			            	<th>GuestProvider Name</th>
			                <td>${gp.getFirstName() } ${gp.getLastName() }</td>
			            </tr>
			            <tr>
			            	<th>GuestProvider PhoneNo</th>
			                <td>${gp.getPhoneNo() }</td>
			            </tr>
			            <tr>
			            	<th>GuestProvider Email</th>
			            	<td>${gp.getEmail() }</td>
			            </tr>
			            <tr>
			            	<th>GuestProvider GovernmentId</th>
			                <td>${gp.getGovernmentId() }</td>
			            </tr>
			            <tr>
			            	<th>GuestProvider Address</th>
			                <td>${gp.getAddress() }</td>
			            </tr>
			        </tbody>
			    </table>
    		</div>
    	</div>
    </div>
    <div>
		<embed src=${gp.getGovernmentIdProof() } width="800px" height="800px" />
	</div>
</div>
<div align='center'>
<a class="btn btn-primary" href='/guest-provider-approval/${gp.getId()}'>Approve</a>
<a class="btn btn-dark" href='/pending-guest-provider-approvals'>Back</a>
</body>

</html>