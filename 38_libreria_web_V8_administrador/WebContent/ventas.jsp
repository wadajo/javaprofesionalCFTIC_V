<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="format"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" lang="es">
<link rel="stylesheet" href="./css/stylesheet.css">
<title>Librería - Ventas</title>
</head>
<body>
<h1>Ventas</h1>
<br>
	<br>
	<div class="divTable">
		<div class="div-table-row">
			<div class="div-table-title-col-large" align=center>Título</div>
			<div class="div-table-title-col" align=center>Cliente</div>
			<div class="div-table-title-col-large" align=center>Fecha</div>			
		</div>
	</div>
	<core:forEach var="unaVenta" items="${requestScope.ventas}">	
		<div class="divTable">
			<div class="div-table-row">
				<div class="div-table-col-large" align=center>${unaVenta.libro.titulo}</div>
				<div class="div-table-col" align=center>${unaVenta.cliente.usuario}</div>				
				<%-- Se podría usar format:parseDate antes de formateDate 
				para crear una variable Timestamp si tuviéramos LocalDateTime 
				en el JavaBean (que sería lo suyo) --%> 
				<div class="div-table-col-large" align=center><format:formatDate type = "both" value = "${unaVenta.fechaVenta}" /></div>				
			</div>
		</div>
	</core:forEach>
	<br>
	<p>Ver resultados de página:</p>
	<core:forEach var="numeroPagina" begin="1" end="${requestScope.totalpaginas}">		
			<a href="Controller?option=toVentas&pagina=${numeroPagina}"><button>${numeroPagina}</button></a>	
	</core:forEach>
	<br><br>
	<a href="Controller?option=toAdmin"><button>Volver</button></a>
</body>
</html>