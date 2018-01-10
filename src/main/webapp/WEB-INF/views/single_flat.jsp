<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<div>
	<p>Localization: ${flat.postCode} ${flat.city} , ulica: ${flat.street} wojewodztwo ${flat.voivodeship}</p>
	<p>Type of Flat: ${flat.typeOfFlat}</p>
	<p>Surface: ${flat.surface}</p>
	<p>Price: ${flat.price} zl</p>
	<p>Max number of guests: ${flat.numberOfGuests}</p>
	<p>Description: ${flat.description}</p>
	<p>Author: ${flat.user.userName}</p>
	<p>Contact: ${flat.user.email}</p>

	<c:if test="${user.userName eq flat.user.userName}">
	
	<form action="/RentaRoom/flat/edit/${flat.id}"><button type="submit">Edit offer</button></form>
	<form action="/RentaRoom/flat/delete/${flat.id}"><button type="submit">Delete offer</button></form>
	<!--  <p><a href = "/RentaRoom/flat/edit/${flat.id}">Edit offer</a>
	
	 <a href = "/RentaRoom/flat/delete/${flat.id}">Delete offer</a></p>-->
	</c:if>
<hr>
</div>



<!-- END MAIN -->
<%@ include file = "jspf/footer.jspf" %>
</div>
</body>
</html>