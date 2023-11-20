/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import databaseConnector.ConnectPostgres;
import interface_foncier.TanyRemote;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.Tany;

/**
 *
 * @author Kyle
 */
public class CoordTany implements TanyRemote {
    
    @Override
    public List<model.CoordTany> selectAllCoordTany() {
        ConnectPostgres dbc = new ConnectPostgres();
        Connection connection = dbc.Connecter();
        List<model.CoordTany> coordList = new ArrayList<>();

        String query = "SELECT * FROM coordtany";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id_coordTany = resultSet.getString("id_coordtany");
                String longitude = resultSet.getString("longitude");
                String latitude = resultSet.getString("latitude");
                String id_personne = resultSet.getString("id_personne");
                String id_tany = resultSet.getString("id_tany");

                model.CoordTany coordTany = new model.CoordTany(id_coordTany,longitude,latitude,id_personne,id_tany);
                coordList.add(coordTany);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return coordList;
    }
    
    @Override
    public void insertCoordTany(String frontiere,String longitude,String latitude, String idTany) {
            ConnectPostgres dbc = new ConnectPostgres();
            Connection connection = dbc.Connecter();
            String query = "INSERT INTO coordtany(longitude,latitude,id_personne,id_tany) VALUES (?, ?, ?, ?);";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, frontiere);
                preparedStatement.setString(2, longitude);
                preparedStatement.setString(3, latitude);
                preparedStatement.setString(4, idTany);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    @Override
    public List<Tany> selectAllTany() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertFrontiere(String frontiere) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
