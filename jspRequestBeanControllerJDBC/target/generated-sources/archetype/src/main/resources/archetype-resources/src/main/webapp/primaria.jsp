#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="primariaControllerBean" class="${package}.jspjdbc.controllerBeans.PrimariaControllerBean" scope="request"/>
<jsp:setProperty name="primariaControllerBean" property="*" />
<%-- <jsp:getProperty name="businessDelegate" property="reset"/> --%>
<%-- <jsp:setProperty name="businessDelegate" property="id" param="id"/> --%>
<%-- <jsp:setProperty name="businessDelegate" property="operacion" param="operacion"/> --%>
<%-- <c:set var="saveStatus" value="${symbol_dollar}{user.save()}" /> --%>
<html>
<head>
 <title>Aplicación</title>
</head>
<body>
<div align="center">
<h1>Principal</h1>
</div>
<br/>
<%@include file="menu.jsp" %>

<%
if (primariaControllerBean.getMensaje()!=null)
{%>
<script>alert("<%=primariaControllerBean.getMensaje()%>");</script>
<%
}
%>

<div align="center">
<table>
        <tr>
            <th>ID</th>
            <th>Campos 1</th>
            <th>Campos 2</th>
            <th>Campos 3</th>
        </tr>
        <c:forEach items="${symbol_dollar}{primariaControllerBean.primarias}" var="elemento">
            <tr>
                <td>${symbol_dollar}{elemento.id}</td>
                <td>${symbol_dollar}{elemento.campo1}</td>
                <td>${symbol_dollar}{elemento.campo2}</td>
                <td>${symbol_dollar}{elemento.campo3}</td>
                <td>
                    <form action="primariaform.jsp" method="post">
                        <input type="hidden" name="id" value="${symbol_dollar}{elemento.id}">
                        <input type="submit" name="operacion" value="Edit"  >
                    </form>
                <td>
                    <form action="primaria.jsp" method="post">
                        <input type="hidden" name="id" value="${symbol_dollar}{elemento.id}">
                        <input type="submit" name="operacion" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>        
    </table>
                    <form action="primariaform.jsp" method="post">                        
                        <input type="submit" name="operacion" value="Nuevo">
                    </form>
    
    
</div>
</body>
</html>
