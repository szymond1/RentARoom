<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
   <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<%@ include file = "jspf/head_config.jspf" %>

</head>
<body>
<%@ include file = "jspf/header.jspf" %>
<%@ include file = "jspf/main_menu.jspf" %>
<div class="w3-main" style="margin-left:250px">

<c:choose>
	<c:when test="${sessionScope.user == null}">
	Log first if you want to check offers!
	</c:when>
	<c:otherwise>
<div>
	<p>Localization: ${flat.postCode} ${flat.city} , ulica: ${flat.street} , wojewodztwo ${flat.voivodeship}</p>
	<p>Type of Flat: ${flat.typeOfFlat}</p>
	<p>Surface: ${flat.surface}</p>
	<p>Price: ${flat.price} zl</p>
	<p>Max number of guests: ${flat.numberOfGuests}</p>
	<p>Description: ${flat.description}</p>
	<p>Author: ${flat.user.userName}</p><form action = "/RentaRoom/userFlats/${flat.user.id}"><button type="submit">Check all offers</button></form>
	<p>Contact: ${flat.user.email}</p>	
	
	<c:if test="${user.userName eq flat.user.userName}">
	<form action="/RentaRoom/add/photos/${flat.id}"><button type="submit">Add new photos</button></form>
	<form action="/RentaRoom/flat/edit/${flat.id}"><button type="submit">Edit offer</button></form>
	<form action="/RentaRoom/flat/delete/${flat.id}"><button type="submit">Delete offer</button></form>
	<!--  <p><a href = "/RentaRoom/flat/edit/${flat.id}">Edit offer</a>
	 <a href = "/RentaRoom/flat/delete/${flat.id}">Delete offer</a></p>-->
	</c:if>
	<div style = "color:blue">
	<p class = "comments"> Comments</p>
	<c:forEach items="${comments}" var="comment">
	<p>${comment.created}</p>
	<p><a href ="/RentaRoom/userFlats/${comment.user.id}">${comment.user.userName}</a>: ${comment.text}</p>
	</c:forEach>
	</div>
	<form:form action="addComment/${flat.id}"  method="post" modelAttribute="comment">
				Add comment<form:textarea path="text"/><form:errors path="text"></form:errors>
				<input type="submit" value = "Add comment" />
			</form:form>
	</c:otherwise>
</c:choose>
<hr>
</div>



<!-- END MAIN -->
<%@ include file = "jspf/footer.jspf" %>
</div>
</body>
</html>