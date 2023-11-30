<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 29-11-2023
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Eliminar Administrador</title>
</head>
<body>

<form action="EliminarAdministradorServlet" method="post">
    <label>Rut: <input type="text" name="rut" required></label><br>

    <input type="submit" value="Eliminar Administrador">
</form>

</body>
</html>
