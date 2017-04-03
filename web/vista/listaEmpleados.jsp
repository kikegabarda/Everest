<%-- 
    Document   : listaEmpleados
    Created on : 03-04-2017, 14:40:27
    Author     : cetecom
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de empleados</title>
    </head>
    <body>
        <p>Lista de Empleados</p>
        
        <c:forEach var="u" items="${lista}" >
            <c:out value="${u.toString()}"></c:out>
            <br>
        </c:forEach>
    </body>
</html>
