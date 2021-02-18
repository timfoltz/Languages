<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${lang.name}</title>
</head>
<body>
	<h1><c:out value="${lang.name}"/></h1>
<p>Creator: <c:out value="${lang.creator}"/></p>

<p>Version: <c:out value="${lang.version}"/></p>
<a href="/languages/${lang.id}/edit">Edit Language</a>
<form action="/languages/${lang.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>
<br>
<br>
<br>
<a href="/languages">go back</a>
</body>
</html>