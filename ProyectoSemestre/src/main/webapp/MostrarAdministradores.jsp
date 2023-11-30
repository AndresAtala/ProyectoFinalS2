<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mostrar Administradores</title>
</head>
<body>

<c:if test="${not empty administradores}">
    <h2>Lista de Administradores</h2>
    <table border="1">
        <tr>
            <th>RUT</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Teléfono</th>
            <th>Rol</th>
        </tr>
        <c:forEach var="admin" items="${administradores}">
            <tr>
                <td>${admin.rut}</td>
                <td>${admin.nombre}</td>
                <td>${admin.apellido}</td>
                <td>${admin.telefono}</td>
                <td>${admin.rol}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${empty administradores}">
    <p>No se encontraron administradores.</p>
</c:if>

<a href="index.jsp">INICIO</a>

</body>
</html>
