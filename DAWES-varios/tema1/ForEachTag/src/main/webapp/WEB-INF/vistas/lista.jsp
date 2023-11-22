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
<h1>Lista Provincias</h1>

<ul>
<c:forEach items="${listaProvincias}" var="p">

<li>${p.id} - ${p.descripcion} </li>
</c:forEach>
</ul>

<!-- <form action="" method="POST">
<input name="provincia" value="Leon">
<button type="submit">Enviar</button>

</form> -->

</body>

<!--   <script type="text/javascript"> 
let a = document.querySelector("ul");
a.innerHTML += "<li>Javi-8090</li>"
</script>
-->

</html>