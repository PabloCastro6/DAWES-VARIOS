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
		<h3>Borrado de categorias</h3>
		<div class="form">
			<form
				action="http://localhost:8080/castro-tiendaServlets/categorias/formularioborrarcategorias"
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
					action="http://localhost:8080/castro-tiendaServlets/categorias/borrarcategorias"
					method="POST">

					<label for="id"> ID Categoria</label> <br> <input type="text"
						id="id" name="id" value="${categoria.id}" readonly> <br>
					<label for="nombre"> Nombre Categoria</label> <br> <input
						type="text" id="nombre" name="nombre" value="${categoria.nombre}" readonly>
					<label for="descripcion">Descripcion</label> <br> <input
						type="text" id="descripcion" name="descripcion"
						value="${categoria.descripcion}" readonly>
			<br>
	 	<label for="activo">Activo</label>
			
			<c:if test="${categoria.activo == 1}">
				<input type="checkbox" id="activo" name="activo" checked disabled>
			</c:if>
			<c:if test="${categoria.activo == 0}">
				<input type="checkbox" id="activo" name="activo" disabled>
			</c:if>
			
			
			
			<input type ="submit" value="Borrar">
			
	 	

	 	</form>
	 
	 </div>


</c:forEach>

</div> 



</body>
</html>