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
<h2>Panel de control Tienda</h2>
</header>
<%@include file="../menu.html" %>

<h3> Listado Proveedores </h3>
	<div class="container">
		<div class="form">
		
			<form action="http://localhost:8080/tienda/proveedores/listadoproveedores"
				method="POST">

					<br>
				    <label for="id"> ID Proveedor: </label> 
				    <br>
				    <input type="text" id="id" name="id"> 
				    <br>
					<label for="nombre"> Nombre Proveedor: </label> 
					<br>
					<input type="text" id="nombre" name="nombre"> 
					<br>
					<label for="contacto"> Contacto: </label> 
					<br>
					<input type="text" id="contacto" name="contacto">  
					<br>
					<label for="telefono"> Telefono: </label> 
					<br>					
					<input type="text" id="telefono" name="telefono">
					<br>
					<label for="correo"> Correo: </label> 
					<br>
					<input type="text" id="correo" name="correo"> 
					<br>
					<label for="direccion"> Direccion: </label> 
					<br>
					<input type="text" id="direccion" name="direccion">  
					<br>
					<label for="activo"> Activo: </label> 
					<br>
					<input type="checkbox" id="activo" name="activo"> 
					<br>
					<input type="submit" value="Enviar">

			</form>

		</div>


		<c:if test="${not empty lista}">
			<table>
				<tr>
					<th>ID</th>
					<th>NOMBRE</th>
					<th>CONTACTO</th>
					<th>TELEFONO</th>
					<th>CORREO ELECTRONICO</th>
					<th>DIRECCION</th>
					<th>ACTIVO</th>
				</tr>

				<c:forEach items="${lista}" var="proveedores">

					<tr>
						<td>${proveedores.id}</td>
						<td>${proveedores.nombre}</td>
						<td>${proveedores.contacto}</td>
						<td>${proveedores.telefono}</td>
						<td>${proveedores.correo}</td>
						<td>${proveedores.direccion}</td>
						<td>${proveedores.activo}</td>
					</tr>

				</c:forEach>
			</table>

		</c:if>
	</div>



</body>
</html>
