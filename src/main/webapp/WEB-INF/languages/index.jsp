<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Languages</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${languages }" var="lang">
				<tr>
					<td><c:out value="${lang.id }"/></td>
					<td><a href="/languages/${lang.id}"><c:out value="${lang.name }"/></a></td>
					<td><c:out value="${lang.creator }"/></td>
					<td><c:out value="${lang.version }"/></td>
					<td><a href="/languages/<c:out value="${lang.id }"/>/edit">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>	
	</table>
	<a href="/languages/new">New Language</a>

</body>
</html>