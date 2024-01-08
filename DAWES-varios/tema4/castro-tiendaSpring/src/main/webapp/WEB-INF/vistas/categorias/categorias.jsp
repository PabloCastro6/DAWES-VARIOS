<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de categorias</title>

</head>
<body>

<ul>
<c:forEach items="${listaCategorias}" var="categoria">

<li> ID: ${categoria.id} Nombre: ${categoria.nombre}</li> 

</c:forEach>
</ul>
</body>
</html>