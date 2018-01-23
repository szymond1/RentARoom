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

<h1 class="w3-text-teal">Add rating</h1>

<c:choose>
	<c:when test="${sessionScope.user == null}">
	Log first if you want to add rating!
	</c:when>
	<c:otherwise>
		<form:form method="post" modelAttribute="rating">
		<p>Localization<form:input path="localization"/></p><p class = "ferror"><form:errors path="localization"></form:errors></p>
		<p>Comfort<form:input path="comfort"/></p><p class = "ferror"><form:errors path="comfort"></form:errors></p>
		<p>Cleanliness<form:input path="cleanliness"/></p><p class = "ferror"><form:errors path="cleanliness"></form:errors></p>
		<p>Personel<form:input path="personel"/></p><p class = "ferror"><form:errors path="personel"></form:errors></p>
		<p>Extras<form:input path="extras"/></p><p class = "ferror"><form:errors path="extras"></form:errors></p>

		<p><input type="submit" value = "Send rate" /></p>
		</form:form>
	
		
	</c:otherwise>
</c:choose>

<!-- END MAIN -->
<%@ include file = "jspf/footer.jspf" %>
</div>
</body>
</html>