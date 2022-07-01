<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	context="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>Customer Directory</title>

</head>

<body>

	<div class="container">

		<h3>Debate Registration List</h3>
		<hr>

		<!-- Add a search form -->
		
		<a href="/CustomerRelationManager/customers"
				class="btn btn-primary btn-sm mb-3"> Customer List </a>

		<a href="/CustomerRelationManager/AddCustomer"
				class="btn btn-primary btn-sm mb-3"> Add Customer </a>
		
		<form action="/CustomerRelationManager/search" class="form-inline">

			<!-- Add a button -->
			 	<h4>Please Enter First Name or Last Name or Email to Search</h4>
				<input
				type="search" name="name" placeholder=""
				class="form-control-sm ml-5 mr-2 mb-3" /> 

			<button type="submit" 
			class="btn btn-success btn-sm mb-3">Search</button>
			
		</form>

		<table class="table table-bordered table-striped">

			<thead>
				<tr class="table-dark">
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
				</tr>
			</thead>

			<tbody>

				<c:forEach items="${Customers}" var="tempCustomer">
					<tr>
						<td><c:out value="${tempCustomer.firstName}" /></td>
						<td><c:out value="${tempCustomer.lastName}" /></td>
						<td><c:out value="${tempCustomer.email}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/CustomerRelationManager/Update?id=${tempCustomer.id}"
							class="btn btn-info btn-sm"> Update </a> 
							<!-- Add "delete" button/link -->
							<a href="/CustomerRelationManager/delete?id=${tempCustomer.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">
								Delete </a>
						</td>
					</tr>

				</c:forEach>

			</tbody>

		</table>

	</div>

</body>

</html>