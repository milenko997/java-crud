<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
<title>New/Edit Candidate</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Candidate</h1>
		<form:form action="save" method="post" modelAttribute="candidate">
			<table>
				<form:hidden path="id" />
				<tr>
					<td>Name:</td>
					<td><form:input path="full_name" /></td>
				</tr>
				<tr>
					<td>Date of birth:</td>
					<td><form:input path="date_of_birth" /></td>
				</tr>
				<tr>
					<td>Contact number:</td>
					<td><form:input path="contact_number" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Save"/></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>