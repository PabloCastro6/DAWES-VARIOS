<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page isELIgnored="false"%>
<html>
<head>
<link rel="stylesheet" href="/tienda/css/index.css">
<link rel="stylesheet" href="/tienda/css/formularios.css">
<link rel="stylesheet" href="/tienda/css/tablas.css">
</head>
<body>
	<header>
		<h2>Gestion de tienda</h2>
	</header>
	<%@include file="../menu.html"%>
	<div class="container">
		<h3>Actualizar Productos</h3>
		<div class="form">
			<form
				action="http://localhost:8080/tienda/productos/formulariomodificarproducto"
				method="POST" id="formulario">
				<label for="IdProducto"> Id Producto</label> <input type="text"
					id="idProducto" name="id"> <label for="nombre">
					Nombre</label> <input type="text" id="nombre" name="nombre"> <label
					for="descripcion"> Descripcion</label> <input type="text"
					id="descripcion" name="descripcion"> <br> <label
					for="precio">Precio</label> <input type="number" id="precio"
					name="precio" min="0"> <label for="cantidadStock">Cantidad
					en Stock</label> <input type="number" id="cantidadStock"
					name="cantidadStock" min="0"> <label for="categorias">Categoria</label>
				<br> <select name="idcategorias" id="categorias"
					form="formulario">

					<br>


					<c:forEach items="${comboCategorias}" var="categoria">
						<option value="${categoria.id}">${categoria.nombre}</option>
					</c:forEach>

				</select> <br>
				<br> <label for="proveedores">Proveedor</label> <br> <select
					name="idproveedores" id="proveedores" form="formulario">

					<br>

					<c:forEach items="${comboProveedores}" var="proveedor">
						<option value="${proveedor.id}">${proveedor.nombre}</option>
					</c:forEach>

				</select> <br>
				<br> <input type="submit" value="Enviar" name="enviar">
			</form>
		</div>




		<h3>Resultado de busqueda</h3>
		<c:forEach items="${lista}" var="producto">

			<div class="form">
				<form
					action="http://localhost:8080/tienda/productos/modificarproductos"
					method="POST">

					<label for="id">Id Producto:</label> <br> <input type="text"
						id="id" name="id" value="${producto.id}" readonly> <br>
					<label for="nombre">Nombre:</label> <br> <input type="text"
						id="nombre" name="nombre" value="${producto.nombre}" required>
					<br> <label for="descripcion">Descripcion:</label> <br> <input
						type="text" id="descripcion" name="descripcion"
						value="${producto.descripcion}"> <br> <label
						for="precio">Precio:</label> <br> <input type="number"
						id="precio" name="precio" value="${producto.precio}" min=0
						required> <br> <label for="precio">Cantidad
						en Stock:</label> <br> <input type="number" id="cantidadStock"
						name="cantidadStock" value="${producto.cantidadEnStock}" min=0
						required> <br> <label for="categoria">Categoria:</label>
					<br> <select name="idcategorias" id="idCategoria">

						
					
				

						<c:forEach items="${comboCategoria}" var="categoria">
							<c:choose>
								<c:when test="${categoria.id == producto.idCategoria}">
									<option value="${producto.idCategoria}" selected>${producto.categoria}</option>
								</c:when>

								<c:otherwise>
									<option value="${categoria.id}">${categoria.nombre}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
					
					
					
					
					
					<br> <br> <label for="precio">Proveedor:</label> <br>
					
					
					<select name="idproveedores" id="idProveedor">

						<c:forEach items="${comboProveedores}" var="proveedor">
							<c:choose>
								<c:when test="${proveedor.id == producto.idProveedor}">
									<option value="${proveedor.id}" selected>${proveedor.nombre}</option>
								</c:when>

								<c:otherwise>
									<option value="${proveedor.id}">${proveedor.nombre}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> <br> <input type="submit" value="Modificar" name="modificar">
				</form>


			</div>

			<br>
		</c:forEach>



	</div>

</body>
</html>