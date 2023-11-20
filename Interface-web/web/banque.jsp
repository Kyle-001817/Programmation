<%-- 
    Document   : banque
    Created on : 16 oct. 2023, 21:33:56
    Author     : Kyle
--%>

<%@page import="models.Versement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% Versement versement = (Versement)request.getAttribute("cin"); %>
        <h1>Votre Solde: </h1> 
        <%out.println(versement.getSolde_verse());%>
    </body>
</html>
