<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="./css/stylesheet.css">
<title>Cajero - Ingresar dinero en cuenta</title>
</head>
<body>
<h1>Ingresar</h1>
<p>El saldo en tu cuenta es de ${sessionScope.logeada.saldo}</p>
<p>¿Cuánto deseas ingresar?</p>
	<form action="Controller?option=doIngresar" method="POST">
		Cantidad: <input type="number" name="dineroaingresar" required autofocus/><br>		
		<button>Ingresar</button>
	</form>
</body>
</html>