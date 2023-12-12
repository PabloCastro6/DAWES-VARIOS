<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page isELIgnored="false"%>
<html>
<head>
<link rel="stylesheet" href="/castro-tiendaServlets/css/index.css">
<link rel="stylesheet" href="/castro-tiendaServlets/css/formularios.css">
<link rel="stylesheet" href="/castro-tiendaServlets/css/tablas.css">
</head>
<body>
	<header>
		<h2>Panel de control Tienda de componentes infórmaticos</h2>
	</header>
	<%@include file="/menu.html"%>
<div class="container">
	<div class="form">
		<form action="http://localhost:8080/castro-tiendaServlets/categorias/insertarcategorias" method="POST" id="formulario">
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
			
			<input type ="submit" value="Insertar">
		</form>
	</div>

 <c:if test="${resultado == 1}">
 
 		<p> Categoria insertado correctamente </p>
 </c:if>
</div>
</body>
</html>