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
<style>
@import url(//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css);

.rating { 
  border: none;
  float: left;
}

.rating > input { display: none; } 
.rating > label:before { 
  margin: 5px;
  font-size: 1.25em;
  font-family: FontAwesome;
  display: inline;
  content: "\f005";
}

.rating > label { 
  color: #ddd; 
 float: right; 
}


.rating > input:checked ~ label, /* show gold star when clicked */
.rating:not(:checked) > label:hover, /* hover current star */
.rating:not(:checked) > label:hover ~ label { color: #FFD700;  } /* hover previous stars in list */

.rating > input:checked + label:hover, /* hover current star when changing rating */
.rating > input:checked ~ label:hover,
.rating > label:hover ~ input:checked ~ label, /* lighten current selection */
.rating > input:checked ~ label:hover ~ label { color: #FFED85;  } 
</style>
</head>
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
        <p>
        <div class="rating">
         Lokalizacja:
          <form:radiobutton path="localization" id="star10" name="star"  value="10" class="radio-btn hide" />
            <label for="star10" ></label>
            <form:radiobutton path="localization" id="star9" name="star"  value="9" class="radio-btn hide" />
            <label for="star9" ></label>
            <form:radiobutton path="localization" id="star8" name="star"  value="8" class="radio-btn hide" />
            <label for="star8" ></label>
            <form:radiobutton path="localization" id="star7" name="star"  value="7" class="radio-btn hide" />
            <label for="star7" ></label>
            <form:radiobutton path="localization" id="star6" name="star"  value="6" class="radio-btn hide" />
            <label for="star6" ></label>
            <form:radiobutton path="localization" id="star5" name="star"  value="5" class="radio-btn hide" />
            <label for="star5" ></label>
            <form:radiobutton path="localization" id="star4" name="star"  value="4" class="radio-btn hide" />
            <label for="star4" ></label>
            <form:radiobutton path="localization" id="star3" name="star"  value="3" class="radio-btn hide" />
            <label for="star3" ></label>
            <form:radiobutton path="localization" id="star2" name="star"  value="2" class="radio-btn hide" />
            <label for="star2" ></label>
            <form:radiobutton path="localization" id="star1" name="star"  value="1" class="radio-btn hide" />
            <label for="star1" ></label>
            <div class="clear"></div>
        </div>
        </p>
        <br/>
        <p>
        <div class="rating">
         Comfort:
          <form:radiobutton path="comfort" id="star20" name="comfort"  value="10" class="radio-btn hide" />
            <label for="star20" ></label>
            <form:radiobutton path="comfort" id="star19" name="comfort"  value="9" class="radio-btn hide" />
            <label for="star19" ></label>
            <form:radiobutton path="comfort" id="star18" name="comfort"  value="8" class="radio-btn hide" />
            <label for="star18" ></label>
            <form:radiobutton path="comfort" id="star17" name="comfort"  value="7" class="radio-btn hide" />
            <label for="star17" ></label>
            <form:radiobutton path="comfort" id="star16" name="comfort"  value="6" class="radio-btn hide" />
            <label for="star16" ></label>
            <form:radiobutton path="comfort" id="star15" name="comfort"  value="5" class="radio-btn hide" />
            <label for="star15" ></label>
            <form:radiobutton path="comfort" id="star14" name="comfort"  value="4" class="radio-btn hide" />
            <label for="star14" ></label>
            <form:radiobutton path="comfort" id="star13" name="comfort"  value="3" class="radio-btn hide" />
            <label for="star13" ></label>
            <form:radiobutton path="comfort" id="star12" name="comfort"  value="2" class="radio-btn hide" />
            <label for="star12" ></label>
            <form:radiobutton path="comfort" id="star11" name="comfort"  value="1" class="radio-btn hide" />
            <label for="star11" ></label>
            <div class="clear"></div>
        </div>
        </p>
        <br/>
        <p>
          <div class="rating">
         Cleanliness:
           	<form:radiobutton path="cleanliness" id="star30" name="cleanliness"  value="10" class="radio-btn hide" />
            <label for="star30" ></label>
            <form:radiobutton path="cleanliness" id="star29" name="cleanliness"  value="9" class="radio-btn hide" />
            <label for="star29" ></label>
            <form:radiobutton path="cleanliness" id="star28" name="cleanliness"  value="8" class="radio-btn hide" />
            <label for="star28" ></label>
            <form:radiobutton path="cleanliness" id="star27" name="cleanliness"  value="7" class="radio-btn hide" />
            <label for="star27" ></label>
            <form:radiobutton path="cleanliness" id="star26" name="cleanliness"  value="6" class="radio-btn hide" />
            <label for="star26" ></label>
            <form:radiobutton path="cleanliness" id="star25" name="cleanliness"  value="5" class="radio-btn hide" />
            <label for="star25" ></label>
            <form:radiobutton path="cleanliness" id="star24" name="cleanliness"  value="4" class="radio-btn hide" />
            <label for="star24" ></label>
            <form:radiobutton path="cleanliness" id="star23" name="cleanliness"  value="3" class="radio-btn hide" />
            <label for="star23" ></label>
            <form:radiobutton path="cleanliness" id="star22" name="cleanliness"  value="2" class="radio-btn hide" />
            <label for="star22" ></label>
            <form:radiobutton path="cleanliness" id="star21" name="cleanliness"  value="1" class="radio-btn hide" />
            <label for="star21" ></label>
            <div class="clear"></div>
        </div>
        </p>
        <br/>
        <p>
         <div class="rating">
         Extras:
         <form:radiobutton path="extras" id="star40" name="extras"  value="10" class="radio-btn hide" />
            <label for="star40" ></label>
            <form:radiobutton path="extras" id="star39" name="extras"  value="9" class="radio-btn hide" />
            <label for="star39" ></label>
            <form:radiobutton path="extras" id="star38" name="extras"  value="8" class="radio-btn hide" />
            <label for="star38" ></label>
            <form:radiobutton path="extras" id="star37" name="extras"  value="7" class="radio-btn hide" />
            <label for="star37" ></label>
            <form:radiobutton path="extras" id="star36" name="extras"  value="6" class="radio-btn hide" />
            <label for="star36" ></label>
            <form:radiobutton path="extras" id="star35" name="extras"  value="5" class="radio-btn hide" />
            <label for="star35" ></label>
            <form:radiobutton path="extras" id="star34" name="extras"  value="4" class="radio-btn hide" />
            <label for="star34" ></label>
            <form:radiobutton path="extras" id="star33" name="extras"  value="3" class="radio-btn hide" />
            <label for="star33" ></label>
            <form:radiobutton path="extras" id="star32" name="extras"  value="2" class="radio-btn hide" />
            <label for="star32" ></label>
            <form:radiobutton path="extras" id="star31" name="extras"  value="1" class="radio-btn hide" />
            <label for="star31" ></label>
            <div class="clear"></div>
        </div>
        </p>
        <br/>
        <p>
          <div class="rating">
         Personel:
          	<form:radiobutton path="personel" id="star50" name="personel"  value="10" class="radio-btn hide" />
            <label for="star50" ></label>
            <form:radiobutton path="personel" id="star49" name="personel"  value="9" class="radio-btn hide" />
            <label for="star49" ></label>
            <form:radiobutton path="personel" id="star48" name="personel"  value="8" class="radio-btn hide" />
            <label for="star48" ></label>
            <form:radiobutton path="personel" id="star47" name="personel"  value="7" class="radio-btn hide" />
            <label for="star47" ></label>
            <form:radiobutton path="personel" id="star46" name="personel"  value="6" class="radio-btn hide" />
            <label for="star46" ></label>
            <form:radiobutton path="personel" id="star45" name="personel"  value="5" class="radio-btn hide" />
            <label for="star45" ></label>
            <form:radiobutton path="personel" id="star44" name="personel"  value="4" class="radio-btn hide" />
            <label for="star44" ></label>
            <form:radiobutton path="personel" id="star43" name="personel"  value="3" class="radio-btn hide" />
            <label for="star43" ></label>
            <form:radiobutton path="personel" id="star42" name="personel"  value="2" class="radio-btn hide" />
            <label for="star42" ></label>
            <form:radiobutton path="personel" id="star41" name="personel"  value="1" class="radio-btn hide" />
            <label for="star41" ></label>
            <div class="clear"></div>
        </div>
        </p>
        <br/>
        <p><input type="submit" value = "Send rate"/></p>
    </form:form>
		
	</c:otherwise>
</c:choose>

<!-- END MAIN -->
<%@ include file = "jspf/footer.jspf" %>
</div>
</body>
</html>