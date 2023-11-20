<%-- 
    Document   : index
    Created on : 10 oct. 2023, 15:36:48
    Author     : Kyle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/css/animate.css">
	<link rel="stylesheet" href="assets/css/flexslider.css">
	<link rel="stylesheet" href="assets/fonts/icomoon/style.css">
	<link rel="stylesheet" href="assets/css/bootstrap.css">
	<link rel="stylesheet" href="assets/css/style.css">
	<link rel="stylesheet" href="assets/css/bouton.css">
        <title>JSP Page</title>
    </head>
    <body>
    <div class="container">	
	<div class="row">
            <div class="col-md-7 mb-5" style="margin-left: 250px; margin-top: 250px;">
                <form action="Find" method="post">
                <center>
                    <h1 class="mb-4">Bonjour entrer votre Numero de CIN:</h1>
                    <div class="form-group">
                        <input type="text" name="cin" class="form-control px-3 py-4" placeholder="Votre numero de CIN">
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary  px-4 py-2" type="submit">Valider</button>
                    </div>
                </center>
                </form>
            </div>
        </div>
    </div>
        
    </body>
</html>
