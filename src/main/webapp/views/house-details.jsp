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
	<h1 align='center'>House Approval</h1>
	<div class="col-sm-6">
    	<div class="card">
    		<div class="card-body">
    			<table class="table table-striped">
			        <tbody>
			            <tr>
			            	<th>House Id</th>
			                <td>${house.getId() }</td>
			            </tr>
			            <tr>
			            	<th>Provider Id</th>
			                <td>${house.getProviderId() }</td>
			            </tr>
			            <tr>
			            	<th>House Type</th>
			                <td>${house.getHouseType() }</td>
			            </tr>
			            <tr>
			            	<th>House City</th>
			                <td>${house.getHouseCity() }</td>
			            </tr>
			            <tr>
			            	<th>House State</th>
			            	<td>${house.getHouseState() }</td>
			            </tr>
			            <tr>
			            	<th>House No</th>
			                <td>${house.getHouseNo() }</td>
			            </tr>
			        </tbody>
			    </table>
    		</div>
    	</div>
    </div>
</div>
<div align='center'>
<a class="btn btn-primary" href='/house-approval/${house.getId()}'>Approve</a>
<a class="btn btn-dark" href='/pending-house-approvals'>Back</a>
</div>
</body>

</html>