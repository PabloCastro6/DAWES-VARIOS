
<%@ page lenguage="java" contentType="text/html"; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/colegio/css/index.css">
<link rel="stylesheet" type="text/css" href="/colegio/css/formularios.css">
<link rel="stylesheet" type="text/css" href="/colegio/css/tablas.css">
<meta charset="ISO-8859-1">
<title>Listado Alumnos</title>
</head>
</html>

<h1>Listado Alumnos</h1>
<%@include file="/menu.html" %>

<div class="container">
	<div class="form">
		<form action="http://Localhost:8080/colegio/listadoalumnos" method="post">
			<label for="id">Id Alumno</label>
			<input type="text" id="id" name="id">
			<label for="nombre">Nombre Alumno</label>
			<input type="text" id="nombre" name="nombre">
			<label for="apellido">Apellido Alumno</label>
			<input type="text" id="apellido" name="apellido"><br>
			<input type="submit" value="Enviar">
		</form>
	</div>



</div>









<c:if test="${not empty lista}">
<table>
	<tr>
		<th>ID</th>
		<th>NOMBRE</th>
		<th>APELLIDO</th>
		<th>MUNICIPIO</th>
	</tr>
	
	<c:forEach itmes=${lista }" var="alumno">
		<tr>
			<td> ${ alumno.id}</td>
			<td> ${ alumno.nombre}</td>
			<td> ${ alumno.apellido}</td>
			<td> ${ alumno.municipio}</td>
		</tr>
	</c:forEach>
	
</table>
</c:if>