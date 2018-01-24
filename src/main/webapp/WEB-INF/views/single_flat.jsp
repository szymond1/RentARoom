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
	<br/>
	<br/>
	<br/>
<div>
	<p class ="flatName">${flat.name}</p>
	${msg}
	<c:choose> 
	<c:when test = "${rating1 != 0}" >
 	<div class="ratebox"><span class="ratecount">Liczba ocen: ${rating1}</span>
      <div class="ratenum">${rating}</div>
     </div>
	</c:when>
	<c:otherwise>
	<div class="ratebox"><span class="ratecount">Be first, rate us</span>
     </div>
	</c:otherwise>
	</c:choose>
	<p>Localization: <b>${flat.postCode} ${flat.city}</b> , ulica: <b>${flat.street}</b> , wojewodztwo <b>${flat.voivodeship}</b></p>
	<p>Type of Flat: <b>${flat.typeOfFlat}</b></p>
	<p>Surface: <b>${flat.surface}</b></p>
	<p>Price: <b>${flat.price}</b> zl</p>
	<p>Max number of guests: <b>${flat.numberOfGuests}</b></p>
	<p>Description: <b>${flat.description}</b></p>
	<p>Author: <b>${flat.user.userName}</b></p><form action = "/RentaRoom/userFlats/${flat.user.id}"><button type="submit">Check all offers</button></form>
     
	<c:if test="${user.userName != flat.user.userName}">
	    <p>
        <a href="/RentaRoom/message/${flat.user.id}" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-envelope"></span> Send message 
        </a>
      </p> 
      <a href="/RentaRoom/flat/addRating/${flat.id}" style="background:yellow; color:black;" class="btn btn-info btn-lg"> Rate us! </a>
	</c:if>
	
	<p>Contact: ${flat.user.email}</p>	

	<div style="width:800; background-color:white; height:300px; overflow:auto;">
	<div style="width: auto; height: auto;">
	<c:forEach items="${photos}" var="photo">
	<img src="//localhost:8080/RentaRoom/resources/picture/${photo.url}" width="300" height="250"/>
	</c:forEach>
	</div>
	</div>
</div>
	<c:if test="${user.userName eq flat.user.userName}">
	<form action="/RentaRoom/add/photos/${flat.id}"><button type="submit">Add new photos</button></form>
	<form action="/RentaRoom/flat/edit/${flat.id}"><button type="submit">Edit offer</button></form>
	<form action="/RentaRoom/flat/delete/${flat.id}"><button type="submit">Delete offer</button></form>

	</c:if>
	<div>
	<p class = "comments"> Comments</p>
	<c:forEach items="${comments}" var="comment">
	<span><a href ="/RentaRoom/userFlats/${comment.user.id}">${comment.user.userName}</a></span>
	<span>${comment.created}:<p class="speech-bubble">${comment.text}...</p> </span>
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