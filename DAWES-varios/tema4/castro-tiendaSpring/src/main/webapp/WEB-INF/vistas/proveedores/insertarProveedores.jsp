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
<h2>Panel de control Tienda de componentes infórmaticos</h2>
</header>
<%@include file="/menu.html" %>

<h3> Inserci�n Proveedores </h3>
	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/tienda/proveedores/insertarproveedores"
				method="POST">

				    <br>
					<label for="nombre"> Nombre Proveedor: </label> 
					<br>
					<input type="text" id="nombre" name="nombre"> 
					<br>
					<label for="contacto"> Contacto: </label> 
					<br>
					<input type="text" id="contacto" name="contacto">  
					<br>
					<label for="telefono"> Tel�fono: </label> 
					<br>					
					<input type="text" id="telefono" name="telefono">
					<br>
					<label for="correo"> Correo: </label> 
					<br>
					<input type="text" id="correo" name="correo"> 
					<br>
					<label for="direccion"> Direcci�n: </label> 
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

		
			<c:if test="${resultado == 1 }">
			
				<p> Proveedor insertado correctamente </p>
			
			</c:if>
	</div>
</body>
</html>