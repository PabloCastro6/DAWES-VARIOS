
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
		<h2>Gestión de Tienda</h2>
	</header>
	<%@include file="/menu.html"%>
	<div class="container">
		<div class="form">
			<form
				action="http://localhost:8080/tienda/productos/insertarproductos"
				method="POST" id="formulario">
				<label for="nombre"> Nombre</label> <input type="text" id="nombre"
					name="nombre"> <label for="descripcion">
					Descripcion</label> <input type="text" id="descripcion" name="descripcion">
				<br> <label for="precio">Precio</label> <input type="checkbox"
					id="precio" name="precio"> <label for="cantidadStock">Cantidad
					en Stock</label> <input type="checkbox" id="cantidadStock"
					name="cantidadStock"> <select name="categoria"
					id="categoria" form="formulario">


					<c:forEach items="${comboCategorias}" var="categoria">
						<option value="${categoria.id}">${categoria.nombre}</option>
					</c:forEach>

				</select> <label for="precio">Proveedor:</label> <br> <select
					name="idProvedor" id="idProvedor" form="formulario">

					<c:forEach items="${comboProveedores}" var="proveedor">
						<option value="${proveedor.id}">${proveedor.nombre}</option>
					</c:forEach>

				</select> <br> <input type="submit" value="Insertar">
			</form>
		</div>

		<c:if test="${resultado == 1}">

			<p>Producto insertado correctamente</p>
		</c:if>
	</div>
</body>
</html>