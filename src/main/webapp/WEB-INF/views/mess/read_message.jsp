<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h3>Selected message:</h3>

<p>Content: ${message.text}</p>
<p>Created: ${message.created}</p>
<p>Author: ${message.sender.userName}</p>
<a href="/RentaRoom/message">Przejdz do pozostalych wiadomosci</a></p>
</div>
<%@ include file = "../jspf/footer.jspf" %>
</body>
</html>