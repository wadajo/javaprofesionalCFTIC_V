<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%--isErrorPage="true"  --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="./css/stylesheet.css">
<title>Error</title>
</head>
<body>
<h1>Error al procesar la venta</h1>
<%-- 
<section id="aviso"><%=exception.getMessage()%></section>
--%>
<section id="aviso">${requestScope.mensajeError}</section>
<button><a href="Controller?option=toLogin"/>Volver a Iniciar sesión</button>
</body>
</html>