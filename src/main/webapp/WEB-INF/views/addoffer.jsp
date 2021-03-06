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

<body>
<%@ include file = "jspf/header.jspf" %>
<%@ include file = "jspf/main_menu.jspf" %>

<div class="w3-main" style="margin-left:250px">

<h1 class="w3-text-teal">Add new offer</h1>

<c:choose>
	<c:when test="${sessionScope.user == null}">
	Log first if you want to add new offer!
	</c:when>
	<c:otherwise>
		<form:form method="post" modelAttribute="flat" enctype="multipart/form-data">
		<p>Name<form:input path="name"/></p><p class = "ferror"><form:errors path="name"></form:errors></p>
		<p>Voivodeship<form:select items="${voivodeship}" path="voivodeship"/></p>
		<p>Postal Code<form:input path="postCode"/></p><p class = "ferror"><form:errors path="postCode"></form:errors></p>
		<p>City<form:input path="city"/></p><p class = "ferror"><form:errors path="city"></form:errors></p>
		<p>Street<form:input path="street"/></p><p class = "ferror"><form:errors path="street"></form:errors></p>
		<p>Type of Flat<form:select items="${typeOfFlat}" path="typeOfFlat"/></p><p class = "ferror"><form:errors path="typeOfFlat"></form:errors></p>
		<p>Surface<form:input path="surface"/></p>
		<p>Price<form:input path="price"/></p>
		<p>Numer of Guests<form:input path="numberOfGuests"/></p>
		<p>Description<form:textarea path="description"/></p><p class = "ferror"><form:errors path="description"></form:errors></p>
		<p>Upload File: <input type="file" name="photo"></p>
		<p><input type="submit" /></p>
		</form:form>
	
		
	</c:otherwise>
</c:choose>

<!-- END MAIN -->
<%@ include file = "jspf/footer.jspf" %>
</div>
</body>
</html>