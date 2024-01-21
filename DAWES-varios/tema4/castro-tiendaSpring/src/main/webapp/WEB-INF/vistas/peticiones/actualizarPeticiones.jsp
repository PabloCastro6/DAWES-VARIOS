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

<div class="container">
		<div class="form">
			<form id="formularioBusqueda"
				action="http://localhost:8080/tienda/peticiones/formularioactualizarpeticion"
				method="POST">

				<label for="idPeticiones">ID Petición</label> <input type="text"
					id="idPeticiones" name="idPeticiones"> <label
					for="idCliente">ID Cliente</label> <select name="idCliente"
					id="idCliente">
					<option value="">Seleccione una opción</option>
					<c:forEach items="${comboCliente}" var="cliente">
						<option value="${cliente.id}">${cliente.nombre}</option>
					</c:forEach>
				</select> <label for="idProducto">Producto</label> <select name="idProducto"
					id="idProducto">

					<option value="">Seleccione una opción</option>

					<c:forEach items="${comboProducto}" var="producto">
						<option value="${producto.id}">${producto.nombre}</option>
					</c:forEach>

				</select> <label for="cantidad">Cantidad</label> <input type="text"
					id="cantidad" name="cantidad"> <label for="estado">Estado</label>
				<select name="estado" id="estado">

					<option value="">Seleccione una opción</option>

					<c:forEach items="${comboEstadoPedido}" var="estadoPedido">
						<option value="${estadoPedido.id}">${estadoPedido.nombre}</option>
					</c:forEach>
				</select> <label for="fecha">Fecha</label> <input type="date" name="fecha"
					id="fecha"> <input type="submit" value="Actualizar">

			</form>
		</div>

		<h3>Modificar Peticiones</h3>
		<c:forEach items="${lista}" var="peticiones" varStatus="loop">
			<div class="form">
				<form id="formularioModificacion"
					action="http://localhost:8080/tienda/peticiones/actualizarpeticiones"
					method="post">

					<label for="id">ID Petición</label> <input type="text"
						id="idPeticiones" name="idPeticiones" value="${peticiones.iD}" readonly>

					<label for="idCliente">Cliente</label> <select name="idCliente"
						id="idCliente">
						<c:forEach items="${comboCliente}" var="cliente">
							<option value="${cliente.id}">${cliente.nombre}</option>
						</c:forEach>
					</select> <label for="idProducto">Producto</label> <select name="idProducto"
						id="idProducto">
						<c:forEach items="${comboProducto}" var="producto">
							<option value="${producto.id}">${producto.nombre}</option>
						</c:forEach>
					</select> <label for="cantidad">Cantidad</label> <input type="text"
						id="cantidad" name="cantidad" value="${peticiones.cantidad}">

					<label for="estado">Estado</label> <select name="estado"
						id="estado">
						<c:forEach items="${comboEstadoPedido}" var="estadoPedido">
							<option value="${estadoPedido.id}">${estadoPedido.nombre}</option>
						</c:forEach>
					</select> <label for="fecha">Fecha</label> <input type="date" name="fecha"
						id="fecha" value="${peticiones.fecha}"> <input
						type="submit" value="Modificar">

				</form>
			</div>
		</c:forEach>
	</div>
</body>
</html>