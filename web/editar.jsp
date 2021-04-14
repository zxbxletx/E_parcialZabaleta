<%-- 
    Document   : editar
    Created on : 13-abr-2021, 21:29:21
    Author     : Zxbxl
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
      <body>
                
        <h1>
            <c:if test="${requestScope.op == 'nuevo'}" var="res" scope="request">
                Registro de
            </c:if>
            <c:if test="${requestScope.op == 'modificar'}" var="res" scope="request">
                Modificar
            </c:if>
                Datos de Pacientes
        </h1>
        <jsp:useBean id="miDatos" scope="request" class="com.emergentes.modelo.Datos" />
        <form action="Controller" method="post">
            <table>
                <tr>
                    <td>Id</td>
                    <td><input type="text" name="id" value="<jsp:getProperty name="miDatos" property="id" />"></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="<jsp:getProperty name="miDatos" property="nombre" />"></td>
                </tr>
                <tr>
                    <td>Peso</td>
                    <td><input type="text" name="peso" value="<jsp:getProperty name="miDatos" property="peso" />"></td>
                </tr>
                <tr>
                    <td>Talla</td>
                    <td><input type="text" name="talla" value="<jsp:getProperty name="miDatos" property="talla" />"></td>
                </tr>
                <tr>
                    <td>Vacunado</td>
                    <td>
                        <select name="vacunado">
                            <option value="SI"
                                <c:if test="${miDatos.vacunado == 'SI'}"
                                      var="res" scope="request" >
                                    selected
                                </c:if>>SI
                            </option>
                            <option value="NO"
                                <c:if test="${miDatos.vacunado == 'NO'}"
                                      var="res" scope="request" >
                                    selected
                                </c:if>>NO
                            </option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="hidden" name="opg" value="${requestScope.op}"/>
                        <input type="hidden" name="op" value="guardar"/>
                    </td>
                    <td><input type="submit" value="Enviar"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
