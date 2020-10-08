<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="./css/stylesheet.css">
<title>Países del mundo</title>
</head>
<body>
	<h1>Países del mundo</h1>
	<p>Lista de países:</p>
		
				
			<form action="Controller?option=doDetallesPais" method="post">
				<div class="divTable">				
					<div class="div-table-row">					
						<select	name="nombrepais">
							<core:forEach var="unPais" items="${applicationScope.listapaises}">
								<option value="${unPais}">${unPais}
							</core:forEach>			
						</select>					
					</div>				
				</div>
				<br>
				<button>Seleccionar</button>
			</form>
		
		<core:choose>
			<core:when test="${!empty requestScope.paiselegido}">
				<p>Nombre de país: <b>${paiselegido.nombre}</b></p>					
				<p>Región: <b>${paiselegido.region}</b></p>				
				<p>Habitantes: <b>${paiselegido.habitantes}</b></p>				
				<p>Capital: <b>${paiselegido.capital}</b></p>				
				<p>Bandera: <br><img alt="Bandera de ${paiselegido.nombre}" src="${paiselegido.bandera}"/></p>		
			</core:when>
		</core:choose>
	
</body>
</html>