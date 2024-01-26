
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

    <h1>Carrito de Compras</h1>

  
     <%-- HACER COMBO CLIENTE --%>
      <label for="cliente">Seleccionar cliente:</label>
				<br>
				<select name="idCliente" id="cliente">
				
						<option value="" disabled selected>--Seleccione un cliente--</option>
					<c:forEach items="${comboCliente}" var="cliente">
						<option value="${cliente.id}">${cliente.nombre}</option>
					</c:forEach>
				
				</select>
				
	<%-- comentarioEJEMPLO
    <select id="cliente">
		<option value="" disabled selected>Seleccione una opci�n</option>
		<option value="1">Pepe</option>
        <option value="2">Juanita</option>
        <option value="3">Pepita</option>
    </select>
 --%>
    <br><br>

    
   <%-- HACER COMBO PRODUCTO --%>
   <label for="producto">Seleccionar producto:</label>
				<br>
				<select onchange = "calculaPrecio()" id="Producto" >
				
						<option value="" disabled selected>--Seleccione un producto--</option>
					<c:forEach items="${comboProducto}" var="producto">
						<option value="${producto.id}">${producto.nombre}</option>
					</c:forEach>
				
				</select>
   
   
   
   <%-- Ejemplo 
   <label for="producto">Seleccionar producto:</label>
   <br>
    <select onchange = "calculaPrecio()" id="producto">
		<option value="" disabled selected>Seleccione una opci�n</option>
        <option value="1">Teclado</option>
        <option value="2">Procesador</option>
        <option value="3">rat�sn</option>
    </select>
--%>


    <br><br>

    <label for="cantidad">Cantidad:</label>
    <input type="number" id="cantidad" value="1">

    <br><br>
        <label for="precio">Precio:</label>
    <input type="number" id="precio" >
   <br><br>
    <button onclick="agregarAlCarrito()">Agregar al carrito</button>
    <button onclick="realizarVenta()">Realizar Venta</button>

    <h2>Carrito</h2>
    <ul id="listaCarrito">
    </ul>

 <script src="/tienda/js/scripts.js"></script>
</body>
</html>