/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import databaseConnector.ConnectPostgres;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author Kyle
 */
@Stateful
public class Retrait implements RetraitRemote {

    @Override
    public List<models.Retrait> selectAllRetraits() {
        ConnectPostgres dbc = new ConnectPostgres();
        Connection connection = dbc.Connecter();
        List<models.Retrait> retraitList = new ArrayList<>();

        String query = "SELECT * FROM retrait";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id_retrait = resultSet.getString("id_retrait");
                double solde_retrait = resultSet.getDouble("solde_retrait");
                Timestamp date_retrait = resultSet.getTimestamp("date_retrait");
                String id_personne = resultSet.getString("id_personne");

                models.Retrait retrait = new models.Retrait(id_retrait,solde_retrait,date_retrait,id_personne);
                retraitList.add(retrait);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retraitList;
    }
    
    @Override
    public void insert(Double solde_retrait, Timestamp date_retrait, String id_personne) {
            ConnectPostgres dbc = new ConnectPostgres();
            Connection connection = dbc.Connecter();
            String query = "INSERT INTO retrait(solde_retrait, date_retrait, id_personne) VALUES (?, ?, ?)";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setDouble(1, solde_retrait);
                preparedStatement.setTimestamp(2, date_retrait);
                preparedStatement.setString(3, id_personne);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
    
}
