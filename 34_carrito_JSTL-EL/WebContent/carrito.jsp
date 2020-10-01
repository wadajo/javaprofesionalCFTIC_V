<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" lang="es">
<link rel="stylesheet" href="./css/stylesheet.css">
<title>Carrito</title>
</head>
<body>
	<core:set var="carrito" value="${sessionScope.carrito}" />
	<core:choose>
		<core:when test="${empty carrito}">
			<jsp:forward page="vacio.html" />
		</core:when>
		<core:otherwise>
			<h1>El carrito actualmente contiene:</h1>
			<br>
			<br>
			<div class="divTable">
				<div class="div-table-row">
					<div class="div-table-title-col-large" align=center>Nombre</div>
					<div class="div-table-title-col-small" align=center>Precio</div>
					<div class="div-table-title-col" align=center>Categoría</div>
					<div class="div-table-title-col" align=center></div>
				</div>
			</div>	
			<core:forEach var="unProducto" items="${carrito}" varStatus="pos">		
				<div class="divTable">					
					<div class="div-table-row">					
						<div class="div-table-col-large" align=center>${unProducto.nombre}</div>
						<div class="div-table-col-small" align=center>${unProducto.precio}</div>
						<div class="div-table-col" align=center>${unProducto.categoria}</div>
						<div class="div-table-col" align=center>
							<a href="Eliminar?indice=${pos.index}"><button>Eliminar</button></a>
						</div>					
					</div>					
				</div>
			</core:forEach>			
		</core:otherwise>
	</core:choose>
	<br>
	<br>
	<a href="inicio.html"><button>Volver al Inicio</button></a>
</body>
</html>