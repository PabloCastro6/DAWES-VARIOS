<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored = "false" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Personas</title>
</head>

<body>

<h1>Lista Personas</h1>
<ul>
<c:forEach items="${personas}" var="p">

<li>${p.nombre} - ${p.saldoCuenta} </li>
</c:forEach>
</ul>
</body>


</html>