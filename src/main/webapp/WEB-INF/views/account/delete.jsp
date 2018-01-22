<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<%@ include file = "../jspf/head_config.jspf" %>
</head>
<body>
<%@ include file = "../jspf/header.jspf" %>
<%@ include file = "../jspf/main_menu.jspf" %>

<div class="w3-main" style="margin-left:250px">

<c:choose>

	<c:when test="${sessionScope.user == null}">
		You need to be logged in, in order to edit user details.
	</c:when>

	<c:otherwise>
<h2>Are you sure you want to delete your account?</h2>
<form action="/RentaRoom/delete/1"><button type="submit">Yes, delete my account</button></form>
<form action="/RentaRoom/delete/0"><button type="submit">No, that was a mistake</button></form>
</c:otherwise>

	</c:choose>

<!-- END MAIN -->
<%@ include file = "../jspf/footer.jspf" %>
</div>
</body>
</html>