<%-- 
    Document   : sante
    Created on : 16 oct. 2023, 10:58:11
    Author     : Kyle
--%>

<%@page import="java.util.List"%>
<%@page import="models.Versement"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="assets/css/animate.css">
	<link rel="stylesheet" href="assets/css/flexslider.css">
	<link rel="stylesheet" href="assets/fonts/icomoon/style.css">
	<link rel="stylesheet" href="assets/css/bootstrap.css">
	<link rel="stylesheet" href="assets/css/style.css">
	<link rel="stylesheet" href="assets/css/bouton.css">
        <title></title>
    </head>
    <style>
        .santes{
            margin-top: 50px;
            box-shadow: 3px 3px 10px 1px black;
            height: 300px;
            border-radius: 20px;
            padding-top: 20px;
            color: white;
            padding-left: 400px;
        }
        .banque{
            height: 300px;
            box-shadow: 3px 3px 10px 1px black;
        }
        .foncier{
            height: 300px;
            box-shadow: 3px 3px 10px 1px black;
        }
        tr{
            height: 50px;
        }
         
    </style>
    <body>
    <center style="margin-top:50px;"><h1 style="color: #007bff; font-family: cursive">A propos de vous </h1></center>
        
        <div class="container cont">
            <div class="row">
                <div class="col-md-12 mb-2 santes">
                <h4>Sante</h4>
                <table>
                    <% JsonObject jsonObject = (JsonObject)request.getAttribute("json");
                        Double versement = (Double)request.getAttribute("num");
                        String cin = (String)request.getAttribute("cin");
                    %>
                    <tr>
                        <td>Nom: </td>
                        <td>      </td>
                        <td><% out.println(jsonObject.get("nom").getAsString()); %></td>
                    </tr>
                    <tr>
                        <td>Prenom: </td>
                        <td>      </td>
                        <td><% out.println(jsonObject.get("prenom").getAsString()); %></td>
                    </tr>
                    <tr>
                        <td>Date de Naissance: </td>
                        <td>      </td>
                        <td><% out.println(jsonObject.get("date_naissance").getAsString()); %></td>
                    </tr>
                    <tr>
                        <td>Votre groupe Sanguin:</td>
                        <td>       </td>
                        <td><% out.println(jsonObject.get("groupe_sanguin").getAsString()); %></td>
                    </tr>
                    <tr>
                        <td>Numero CIN: </td>
                        <td>      </td>
                        <td><% out.println(cin); %></td>
                    </tr>
                </table>
                </div>
            </div>
                    <div class="row">
                        <div class="col-md-12 mb-2 santes">
                            <h4>Banque</h4>
                            <table>
                                <tr>
                                    <td>Votre Solde Actuel : </td>
                                    <td><% out.println(versement);%> Ariary</td>
                                </tr>
                                <tr>
                                    <td>Montant de transfert : </td>
                                    <td><input type="number" name="transfert" class="form-control px-5 py-3"></td>
                                </tr>
                                <tr>
                                    <td>Numero du Recepteur : </td>
                                    <td><input type="text" name="recepteur" class="form-control px-5 py-3"></td>
                                </tr>
                                <tr>
                                    <td><button class="btn btn-primary  px-4 py-2">Transferer</button></td>
                                    <td></td>
                                </tr>
                                
                            </table>
                        </div>
                        <div class="col-md-12 mb-2 santes">
                            <h4>Foncier</h4>
                            <form action="CarteServlet" method="post">
                                <b>Nom Tany: </b> <input type="text" name="frontiere" class="form-control px-5 py-3">
                                
                            <table>
                                <input type="hidden" name="num_cin" value="<% out.println(cin); %>">
                                <tr>
                                    <td><button type="submit">Valider</button></td>
                                </tr>
                            </table>
                            </form>
                        </div>
                    </div>
        </div>
    </body>
</html>
