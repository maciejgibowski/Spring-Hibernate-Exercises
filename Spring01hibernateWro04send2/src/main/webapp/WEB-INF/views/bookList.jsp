<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<div><a href="../book/form">Add book</a></div>
<div><a href="../proposition/form">Add proposition</a></div>
	<h1>Lista książek</h1>
	<c:forEach items="${books}" var="book">
${book.title}  <a href="<c:url value='/book/${book.id}/edit'/>">EDIT</a> <a href="<c:url value='/book/${book.id}/del'/>">DEL</a><br><br>
	</c:forEach>
</body>
</html>