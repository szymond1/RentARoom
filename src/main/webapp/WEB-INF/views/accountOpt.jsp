<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<%@ include file = "jspf/head_config.jspf" %>

<title>RentaRoom</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<%@ include file = "jspf/header.jspf" %>
<%@ include file = "jspf/main_menu.jspf" %>

<div class="w3-main" style="margin-left:250px">

<h1 class="w3-text-teal">Edit your account</h1>

<c:choose>

	<c:when test="${sessionScope.user == null}">
		You need to be logged in, in order to edit user details.
	</c:when>

	<c:otherwise>
<form:form method="post" modelAttribute="user">
	<p>User Name<form:input path="userName" /><form:errors path="userName"></form:errors></p>
	<p>Email<form:input path="email" /><form:errors path="email"></form:errors></p>
	<p>Password<form:password path="password" /><form:errors path="password"></form:errors></p>
<p><input type="submit" value = "Edit your data"/></p>
</form:form>
<a href="/RentaRoom/delete">Delete your account</a></p>
</c:otherwise>

	</c:choose>

<!-- END MAIN -->
<%@ include file = "jspf/footer.jspf" %>
</div>
</body>
</html>