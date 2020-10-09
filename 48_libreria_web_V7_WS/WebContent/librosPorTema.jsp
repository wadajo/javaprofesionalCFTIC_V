<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" lang="es">
<link rel="stylesheet" href="./css/stylesheet.css">
<title>Librería - Libros por tema</title>
</head>
<body>
	<h2>Hola ${sessionScope.logeado.usuario}</h2>
	
	<core:choose>
		<core:when test="${requestScope.tema == 'todos'}">
			<p>Estos son todos los libros de la Librería:</p>
		</core:when>
		<core:otherwise>
			<p>
				Estos son los libros disponibles del tema <b>${requestScope.librosportema[0].tema}</b>:
			</p>
		</core:otherwise>
	</core:choose>
	<br>
	<br>
	<div class="divTable">
		<div class="div-table-row">
			<div class="div-table-title-col-large" align=center>Título</div>
			<div class="div-table-title-col-large" align=center>Autor</div>
			<div class="div-table-title-col-small" align=center>Precio</div>
			<div class="div-table-title-col" align=center>Tema</div>
			<div class="div-table-title-col-small2" align=center>Agregar al Carrito</div>
		</div>
	</div>
	<core:forEach var="unLibroDeEsteTema"
		items="${requestScope.librosportema}">
		<div class="divTable">
			<div class="div-table-row">
				<div class="div-table-col-large" align=center>${unLibroDeEsteTema.titulo}</div>
				<div class="div-table-col-large" align=center>${unLibroDeEsteTema.autor}</div>
				<div class="div-table-col-small" align=center>${unLibroDeEsteTema.precio}</div>
				<div class="div-table-col" align=center>${unLibroDeEsteTema.tema}</div>
				<div class="div-table-col-small2" align=center>
					<form action="Controller?temabuscado=${param.temabuscado}&option=doAgregar" method="post">
						<input type="hidden" name="isbn" value="${unLibroDeEsteTema.isbn}"> 
						<input type="hidden" name="titulo" value="${unLibroDeEsteTema.titulo}">
						<input type="hidden" name="autor" value="${unLibroDeEsteTema.autor}">
						<input type="hidden" name="precio" value="${unLibroDeEsteTema.precio}">
						<input type="hidden" name="paginas" value="${unLibroDeEsteTema.paginas}">
						<input type="hidden" name="tema" value="${unLibroDeEsteTema.tema}">
						<button type="submit">Agregar</button>
					</form>
				</div>
			</div>
		</div>
	</core:forEach>
	<br>
	<core:choose>
		<core:when test="${!empty sessionScope.carrito}">
			<p>Estos son por ahora los libros de tu Carrito:</p>
			<br>
			<br>
			<div class="divTable">
				<div class="div-table-row">
					<div class="div-table-title-col-large" align=center>Título</div>
					<div class="div-table-title-col-large" align=center>Autor</div>
					<div class="div-table-title-col-small" align=center>Precio</div>
					<div class="div-table-title-col" align=center>Tema</div>
					<div class="div-table-title-col-small2" align=center>Quitar</div>
				</div>
			</div>
			<core:forEach var="unLibroEnCarrito" items="${sessionScope.carrito}" varStatus="pos">
		<div class="divTable">
			<div class="div-table-row">
				<div class="div-table-col-large" align=center>${unLibroEnCarrito.titulo}</div>
				<div class="div-table-col-large" align=center>${unLibroEnCarrito.autor}</div>
				<div class="div-table-col-small" align=center>${unLibroEnCarrito.precio}</div>
				<div class="div-table-col" align=center>${unLibroEnCarrito.tema}</div>
				<div class="div-table-col-small2" align=center>
					<form action="Controller?temabuscado=${param.temabuscado}&option=doQuitar" method="post">
						<input type="hidden" name="posicion" value="${pos.index}">
						<input type="hidden" name="temabusqueda" value="${requestScope.tema}">
						<button type="submit">Quitar</button>
					</form>
				</div>		
			</div>
		</div>
	</core:forEach>
	<br>
	<a href="Controller?temabuscado=${param.temabuscado}&option=doVender"><button>Realizar venta</button></a>
	<br><br>
	</core:when>
	</core:choose>
	<a href="Controller?option=toLibrosPorTema"><button>Volver a buscar</button></a>
	<br>
</body>
</html>