<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<link rel="stylesheet" href="/tienda/css/index.css">
<link rel="stylesheet" href="/tienda/css/formularios.css">
<link rel="stylesheet" href="/tienda/css/tablas.css">
<title>Listado de Productos</title>
</head>
<body>
	<header>
		<h2>Productos</h2>
	</header>
	<%@include file="../menu.html"%>

	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/tienda/productos/listarproducto"
				method="POST" id="formulario">
				<label for="IdProducto"> Id Producto</label> <input type="text" id="idProducto"
					name="idProducto" required>
				
				<label for="nombre"> Nombre</label> <input type="text" id="nombre"
					name="nombre"> <label for="descripcion">
					Descripcion</label> <input type="text" id="descripcion" name="descripcion">
				<br> <label for="precio">Precio</label> <input type="number"
					id="precio" name="precio" min="0"> <label for="cantidadStock">Cantidad
					en Stock</label> <input type="number" id="cantidadStock" name="cantidadStock" min="0">
					
					
				<label for="categorias">Categoria</label> <br> 
				<select
					name="idCategoria" id="categorias" form="formulario">

					<br>


					<c:forEach items="${comboCategorias}" var="categoria">
						<option value="${categoria.id}">${categoria.nombre}</option>
					</c:forEach>

				</select> 
				<br><br> 
				
				<label for="proveedores">Proveedor</label> <br>
				<select
					name="idProveedor" id="proveedores" form="formulario">
					
					<br>

					<c:forEach items="${comboProveedores}" var="proveedor">
						<option value="${proveedor.id}">${proveedor.nombre}</option>
					</c:forEach>

				</select> 
				<br><br> 
				<input type="submit" value="Enviar">
			</form>
		</div>
		
		<c:if test="${not empty lista}">
			<table>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Descripcion</th>
					<th>Precio</th>
					<th>stock</th>
					<th>Categoria</th>
					<th>Proveedor</th>
					


				</tr>
				<c:forEach items="${lista}" var="producto">
					<tr>
						<td>${producto.id}</td>
						<td>${producto.nombre}</td>
						<td>${producto.descripcion}</td>
						<td>${producto.precio}</td>
						<td>${producto.cantidadEnStock}</td>
						<td>${producto.categoria}</td>
						<td>${producto.proveedor}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>