<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
	<%@include file="/menu.html"%>



	<div class="container">
		<h3>Modificación de categorias</h3>
		<div class="form">
			<form
				action="http://localhost:8080/tienda/categorias/formulariomodificarcategorias"
				method="POST">
				<label for="id"> ID Categoria</label>
						<br>
			<input type ="text" id="id" name="id">
						<br>
						<label for="nombre"> Nombre Categoria</label> <br> <input
					type="text" id="nombre" name="nombre"> <br> <label
					for="descripcion">Descripcion</label> <br> <input type="text"
					id="descripcion" name="descripcion"> <br> <label
					for="activo">Activo</label> <br> <input type="checkbox"
					id="activo" name="activo"> <br> <input type="submit"
					value="Buscar">

			</form>


		</div>

		<h3>Resultados de la búsqueda</h3>
		<c:forEach items="${lista}" var="categoria">


			<div class="form">
				<form
					action="http://localhost:8080/tienda/categorias/modificarcategorias"
					method="POST">

					<label for="id"> ID Categoria</label> <br> <input type="text"
						id="id" name="id" value="${categoria.id}" readonly> <br>
					<label for="nombre"> Nombre Categoria</label> <br> <input
						type="text" id="nombre" name="nombre" value="${categoria.nombre}">
					<label for="descripcion">Descripcion</label> <br> <input
						type="text" id="descripcion" name="descripcion"
						value="${categoria.descripcion}">
			<br>
	 	<label for="activo">Activo</label>
			
			<c:if test="${categoria.activo == 1}">
				<input type="checkbox" id="activo" name="activo" checked>
			</c:if>
			<c:if test="${categoria.activo == 0}">
				<input type="checkbox" id="activo" name="activo">
			</c:if>
			
			
			
			<input type ="submit" value="Modificar">
			
	 	

	 	</form>
	 
	 </div>


</c:forEach>

</div> 



</body>
</html>