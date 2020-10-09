<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="format"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="./css/stylesheet.css">
<format:setBundle basename="resources.descripciones" />
<title><format:message key="login.title"/></title>
</head>
<body>
	<h1><format:message key="login.h1"/></h1>
	<h2>Cambiar idioma:</h2>
	<a href="Controller?option=doIdioma&idioma=en"><p>English</p></a>
	<a href="Controller?option=doIdioma&idioma=es"><p>Español</p></a>
	<form action="Controller?option=doLogin" method="POST">
		<format:message key="login.user"/> <input type="text" name="user" required autofocus/><br> 
		<format:message key="login.password"/> <input	type="password" name="pass" required/><br>
		<button><format:message key="login.enter"/></button>
	</form>
	<br>
	<p><format:message key="login.signup"/></p>
	<a href="Controller?option=toRegistro"><button><format:message key="login.signupbutton"/></button></a>
</body>
</html>