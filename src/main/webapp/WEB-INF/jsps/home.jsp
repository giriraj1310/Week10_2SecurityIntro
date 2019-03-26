<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- This will allow me the form binding -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Security</title>

<style>
</style>
</head>
<body>
	<h1>Welcome <c:out value="${pageContext.request.remoteUser }"></c:out></h1>
	
	<c:url var="logOut" value="/logout"/>
	
	<form action="${logOut }" method="post" class="form-inline">
	
		<input type="submit" value="LogOut" />
		<input type="hidden" value="${_csrf.token }" name="${_csrf.parameterName }" />
	</form>
	

</body>
</html>