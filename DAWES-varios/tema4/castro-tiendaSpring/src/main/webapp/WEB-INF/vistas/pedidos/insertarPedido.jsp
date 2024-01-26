
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
<h2>PEDIDOS</h2>
</header>
<%@include file="../menu.html" %>

  

    <div class="container">
	<h3>Insertar Pedidos</h3>
		<div class="form">
			
				<label for="cliente">Seleccionar cliente:</label>
				<br>
    			<select name="idCliente" id="cliente" >
					<option value="" disabled selected>--Seleccione un cliente--</option>
						<c:forEach items="${comboCliente}" var="cliente">
					<option value="${cliente.id}">${cliente.nombre}</option>
						</c:forEach>
				</select>
    			<br><br>
				<label for="producto">Seleccionar producto:</label>
				<br>
    			<select name="idProducto" id="producto" >
					<option value="" disabled selected>--Seleccione un producto--</option>
						<c:forEach items="${comboProducto}" var="producto">
					<option value="${producto.id}">${producto.nombre}</option>
						</c:forEach>
				</select>
  				<br><br>
				<label for="cantidad">Cantidad:</label>
				<br>
    			<input type="number" id="cantidad" value="1">
				<br><br>
       			<label for="precio">Precio:</label>
       			<br>
   		 		<input type="number" id="precio" value="${pedido.precio}" readonly >
  	 			<br><br>
    			<button onclick="agregarAlCarrito()">Agregar al carrito</button>
    			<button onclick="realizarVenta()">Realizar Venta</button>
  			
		</div>
		<br><br>
     	<h3>Carrito</h3>
     	<div class="form">
    		<ul id="listaCarrito">
    		</ul>
    	</div>
    	
 <script src="/tienda/js/scripts.js"></script>
 </div>
</body>
</html>