<%-- 
    Document   : Carte
    Created on : 23 oct. 2023, 14:38:20
    Author     : Kyle
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Tany"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./leaflet/leaflet.css">
        <link rel="stylesheet" href="assets/css/animate.css">
	<link rel="stylesheet" href="assets/css/flexslider.css">
	<link rel="stylesheet" href="assets/fonts/icomoon/style.css">
	<link rel="stylesheet" href="assets/css/bootstrap.css">
	<link rel="stylesheet" href="assets/css/style.css">
	<link rel="stylesheet" href="assets/css/bouton.css">
        <script src="./leaflet/leaflet.js" crossorigin=" "></script>
        <title>JSP Page</title>
        <style>
            #map{
            height: 600px;
            width: 700px;
            float: left;
        }
        #coordonneesTable{
            width: 500px;
            height: 50px;
            color: white;
            text-align: center;
        }
        </style>
    </head>
    <body>
        <h1>La Carte</h1>
        <% String cin = (String)request.getAttribute("cin");
        List<Tany> frontieres = (List<Tany>)request.getAttribute("frontiere");
        %>
        <form method="post" action="TanyServlet">
        <div id="map"></div>
        <div id="left">
        <table border="1" id="coordonneesTable">
            <tr>
                <th>Longitude</th>
                <th>Latitude</th>
            </tr>
            <input type="hidden" id="coordinatesInput" name="coordinates" value="">
            <input type="hidden"  name="cin" value="<%out.println(cin);%>">
        </table>
        <hr><input class="form-control col-md-3 px-1 py-4" type="text" placeholder="Nom du frontiere" name="frontiere">
        <select name="frontiere" class="form-control">
            <%for (int i=0; i<frontieres.size(); i++){ %>
            <option value="<%out.println(frontieres.get(i).getIdTany());%>"><%out.println(frontieres.get(i).getFrontiere());%></option>
            <% } %>
        </select>
        <button  type="submit"class="btn btn-primary  px-4 py-2">Valider</button>
        </div>
        
        
        <script>
            var coordinatesInput = document.getElementById("coordinatesInput");
            var map = L.map('map').setView([-18.869938,47.566907],13);
            L.tileLayer('https://api.maptiler.com/maps/streets-v2/{z}/{x}/{y}.png?key=NbS1lBuHbuo5ADp6wWZc', {
                maxZoom: 19,
                attribution: '<a href="https://www.maptiler.com/copyright/" target="_blank">&copy; MapTiler</a> <a href="https://www.openstreetmap.org/copyright" target="_blank">&copy; OpenStreetMap contributors</a>'
            }).addTo(map);
            
            var table = document.querySelector("#coordonneesTable");
            var coordinatesArray = [];

            map.on('click', function(e) {
                var lat = e.latlng.lat;
                var lng = e.latlng.lng;
                var coordinates = { latitude: lat, longitude: lng };
                coordinatesArray.push(coordinates);
                var simplifiedArray = coordinatesArray.map(function(coord) {
                    return [coord.latitude, coord.longitude];
                });
                var latitudeArray = [];
                var longitudeArray = [];

                var values = simplifiedArray.join();
                coordinatesInput.value = values;

                var row = table.insertRow(-1);
                var cell1 = row.insertCell(0);
                var cell2 = row.insertCell(1);
                
                cell1.innerHTML = lng;
                cell2.innerHTML = lat;
                
                var circle = L.circle([lat, lng], {
                    color: 'red',
                    fillColor: '#f03',
                    fillOpacity: 0.5,
                    radius: 10
                }).addTo(map);
                
                for (var i = 0; i < coordinatesArray.length; i++) 
                {
                        var coordinates = coordinatesArray[i];
                        var latitude = coordinates.latitude;
                        var longitude = coordinates.longitude;
                        latitudeArray.push(latitude);
                        longitudeArray.push(longitude);
//                    console.log("Coordonnées " + (i + 1) + ": Latitude=" + latitude + ", Longitude=" + longitude);
                }
            });
        </script>
        </form>
    </body>
</html>
