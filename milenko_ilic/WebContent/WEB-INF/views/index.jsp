<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CANDIDATES</title>
</head>
<body>
	<div align="center">
		<h1>Candidates List</h1>
		<h3>
			<a href="new">New Candidate</a>
		</h3>
		
		<table border="1">
			<tr>
				<th>NO.</th>
				<th>Full Name</th>
				<th>Date of birth</th>
				<th>Contact number</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${listCandidate}" var="candidate"
				varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${candidate.full_name}</td>
					<td>${candidate.date_of_birth}</td>
					<td>${candidate.contact_number}</td>
					<td>${candidate.email}</td>
					<td><a href="edit?id=${candidate.id }">Edit</a> &nbsp;&nbsp; <a
						href="delete?id=${candidate.id }">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>