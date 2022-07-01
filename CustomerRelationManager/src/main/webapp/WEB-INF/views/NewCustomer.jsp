<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<title>New Customer Form</title>
</head>
<body>
	<div class="container">
		<center>
		<a href="/CustomerRelationManager/customers"
				class="btn btn-primary btn-sm mb-3"> Customer List </a>
		<h4>Create New Customer</h4>
			<form action="/CustomerRelationManager/save" method="POST">
				
				<div class="form-inline">
					<input type="text" class="form-control mb-4 clo-4" 
						name="id" style="width: 200px;"  
						placeholder="Id" value="${Customer.id}" />
				</div>
				
				<div class="form-inline">
					<input type="text" class="form-control mb-4 clo-4" 
						name="firstName" style="width: 200px;"  
						placeholder="First Name" value="${Customer.firstName}" />
				</div>
				
				<div class="form-inline">
					<input type="text" class="form-control mb-4 clo-4" 
						name="lastName" style="width: 200px;" 
						placeholder="Last Name" value="${Customer.lastName}" />
				</div>
				
				<div class="form-inline">
					<input type="text" class="form-control mb-4 clo-4" 
						name="email" style="width: 200px;" 
						placeholder="Email" value="${Customer.email}" />
				</div>
			
				<button type="submit">Save</button>
		</form>
		</center>
	</div>
</body>
</html>