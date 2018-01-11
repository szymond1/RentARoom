<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	Log first if you want to add new offer!
	</c:when>
	<c:otherwise>
	
<%@ include file = "jspf/userId_page.jspf" %>
<!-- END MAIN -->
</c:otherwise>
</c:choose>
</div>
<%@ include file = "jspf/footer.jspf" %>
</body>
</html>