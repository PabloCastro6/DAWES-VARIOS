<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


   <%@ page isELIgnored="false"%>
<html>
<head>
<link rel="stylesheet" href="/tienda/css/index.css">
<link rel="stylesheet" href="/tienda/css/formularios.css">
<link rel="stylesheet" href="/tienda/css/tablas.css">
</head>
<body>
<header>
<h2>CATEGORIAS</h2>
</header>
<%@include file="../menu.html" %>


<div class="container">
<h3>Listado de categorias</h3>
	<div class= "form">
		<form action="http://localhost:8080/tienda/categorias/listarcategorias" method ="POST">
			<label for="id"> ID Categoria</label>
						<br>
			<input type ="text" id="id" name="id">
						<br>
			<label for="nombre"> Nombre Categoria</label>
						<br>
			<input type ="text" id="nombre" name="nombre">
						<br>
			<label for="descripcion">Descripcion</label>
						<br>
			<input type ="text" id="descripcion" name="descripcion">
			<br>
			<label for="activo">Activo</label>
						<br>
			<input type="checkbox" id="activo" name="activo">
						<br>
			<input type ="submit" value="Buscar">
		
		</form>
	
	
	</div>

<c:if test="${not empty lista}">
	<table>
		<tr>
			<th>ID</th>
			<th>NOMBRE </th>
			<th>DESCRIPCION </th>
		</tr>
		
		<c:forEach items="${lista}" var="categoria">
		
			<tr>
				<td> ${categoria.id} </td>
				<td> ${categoria.nombre} </td>
				<td> ${categoria.descripcion} </td>
			</tr>
		
		</c:forEach>
	
	</table>
</c:if>

</div>



</body>
</html>
