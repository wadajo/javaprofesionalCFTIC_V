<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" lang="es">
<link rel="stylesheet" href="./css/stylesheet.css">
<title>Librería - Buscar por tema</title>
</head>
<body>
<h2>Hola ${sessionScope.logeado.usuario}</h2>
<core:choose>
	<core:when test="${requestScope.venta == 'ok'}">
		<section id=aviso>Has realizado la venta correctamente.</section>
	</core:when>
</core:choose>
<p>Selecciona el tema:</p>
<form action="Controller?option=doLibrosPorTema" method="post">
		<label for="importancia">Tema:</label> <br> 
		<select	name="temabuscado">
			<option value="todos" SELECTED>-todos-
		<core:forEach var="unTema" items="${requestScope.temas}">	
			<option value="${unTema}">${unTema}			
		</core:forEach>
		</select>		
		<br> <br>
		<button>Ver libros de este tema</button>
	</form>
</body>
</html>