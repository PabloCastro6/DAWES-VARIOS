<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
<%@include file="/menu.html" %>

<div class="container">
	<div class="form">
		<form action="http://localhost:8080/tienda/productos/listarproductos" method="POST" id="formulario">
			<label for="nombre"> Nombre</label> <input type="text" id="nombre" name="nombre">
			<label for="descripcion"> Descripcion</label> <input type="text" id="descripcion" name="descripcion">
			<br>
			<label for="precio">Precio</label> <input type="text" id="precio" name="precio">
			<label for="cantidadStock">Cantidad en Stock</label> <input type="text" id="cantidadStock" name="cantidadStock">
			<label for="categorias">Categoria</label>
			<br>
			<select name ="categorias" id="categorias" form="formulario">
			<br>
			
			
				<c:forEach items="${comboCategorias}" var="categoria">
					
					<option value="${categoria.id}">${categoria.nombre}</option>
				
				
				</c:forEach>
			
			</select>
			<br>
			<label for="proveedores">Proveedor</label>
			<select name ="proveedores" id="proveedores" form="formulario">
			
				<c:forEach items="${comboProveedores}" var="proveedor">
					
					<option value="${proveedor.id}">${proveedor.nombre}</option>
				
				
				</c:forEach>
			
			</select>
			
			
			<input type ="submit" value="Enviar">
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
       
        
    </tr>
    <c:forEach items="${lista}" var="producto">
        <tr>
           <td>${producto.id}</td>
            <td>${producto.nombre}</td>
            <td>${producto.descripcion}</td>
            <td>${producto.precio}</td>
            <td>${producto.cantidadEnStock}</td>
            
           
        </tr>
   </c:forEach>
</table> 
</c:if>
</div>
</body>
</html>