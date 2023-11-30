<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 29-11-2023
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modificar Administrador</title>
</head>
<body>

<form action="ModificarAdministradorServlet" method="post">
    <label>Rut: <input type="text" name="rut" required></label><br>
    <label>Nombre: <input type="text" name="nombre" required></label><br>
    <label>Apellido: <input type="text" name="apellido" required></label><br>
    <label>Teléfono: <input type="text" name="telefono" required></label><br>
    <label>Rol: <input type="text" name="rol" required></label><br>

    <input type="submit" value="Modificar Administrador">
</form>

</body>
</html>
