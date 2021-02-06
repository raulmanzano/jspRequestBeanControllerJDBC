<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="primariaControllerBean" class="es.manzano.ejemplo.jspjdbc.controllerBeans.PrimariaControllerBean" scope="request"/>
<jsp:setProperty name="primariaControllerBean" property="id" param="id"/>
<jsp:setProperty name="primariaControllerBean" property="operacion" param="operacion"/>
<html>
<head>
<title>Aplicación</title>
</head>
<body>
	<div align="center">
		<h1>Principal</h1>
	<h2>
		
		<c:if test="${primariaControllerBean.operacion eq 'Edit'}">
        Editar Primaria
        </c:if>
		<c:if test="${primariaControllerBean.operacion eq 'Nuevo'}">
        Nueva Primaria
        </c:if>
        
	</h2>
	</div>
	<div align="center">
			<form action="primaria.jsp" method="post">
		<table>
			<tr><td>id</td><td><input type="text" name="id" value="<c:out value='${primariaControllerBean.id}' />" readonly style="background-color:lightgrey"/></td></tr>			
			<tr><td>Campo1</td><td><input type="text" name="campo1" value="<c:out value='${primariaControllerBean.campo1}' />" /></td></tr>
			<tr><td>Campo2</td><td><input type="text" name="campo2" value="<c:out value='${primariaControllerBean.campo2}' />" /></td></tr>
			<tr><td>Campo3</td><td><input type="text" name="campo3" value="<c:out value='${primariaControllerBean.campo3}' />" /></td></tr>
		</table>		
		<c:if test="${primariaControllerBean.operacion eq 'Edit'}">
			<input type="submit" name="operacion" value="Editar"/>
		</c:if>
		<c:if test="${primariaControllerBean.operacion eq 'Nuevo'}">
			<input type="submit" name="operacion" value="Crear"/>			
		</c:if>
			<a href="primaria.jsp">Cancelar</a>
		</form>
	</div>
</body>









</html>
