<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Alumnos</title>
</head>
<body>
	<ul>
		<c:forEach items="${listaAlumnos}" var="alumno">
			<li>ID: ${alumno.id} Nombre: ${alumno.nombre}</li>

		</c:forEach>
	</ul>
</body>
</html>