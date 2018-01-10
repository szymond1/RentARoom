<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<%@ include file = "jspf/head_config.jspf" %>

<title>RentaRoom app</title>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"/>
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css"/>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
<link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<%@ include file = "jspf/header.jspf" %>
<%@ include file = "jspf/main_menu.jspf" %>

<div class="w3-main" style="margin-left:250px">

<h1 class="w3-text-teal">Edit offer id ${flat.id}</h1>

<c:choose>
	<c:when test="${sessionScope.user == null}">
	Log first if you want to add new offer!
	</c:when>
	<c:otherwise>
		<form:form method="post" modelAttribute="flat">
		<p>Voivodeship<form:select items="${voivodeship}" path="voivodeship"/></p>
		<p>Postal Code<form:input path="postCode"/></p>
		<p>City<form:input path="city"/></p>
		<p>Street<form:input path="street"/></p>
		<p>Type of Flat<form:select items="${typeOfFlat}" path="typeOfFlat"/></p>
		<p>Surface<form:input path="surface"/></p>
		<p>Price<form:input path="price"/></p>
		<p>Numer of Guests<form:input path="numberOfGuests"/></p>
		<p>Description<form:textarea path="description"/></p>
		<p><input type="submit" /></p>
		<form:errors></form:errors>
		</form:form>
	</c:otherwise>
</c:choose>

<!-- END MAIN -->
<%@ include file = "jspf/footer.jspf" %>
</div>
</body>
</html>