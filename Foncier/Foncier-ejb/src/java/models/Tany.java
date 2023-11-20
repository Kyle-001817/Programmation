/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import databaseConnector.ConnectPostgres;
import interface_foncier.TanyRemote;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import model.CoordTany;

/**
 *
 * @author Kyle
 */
@Stateful
public class Tany implements TanyRemote {

    @Override
    public List<model.Tany> selectAllTany() {
        ConnectPostgres dbc = new ConnectPostgres();
        Connection connection = dbc.Connecter();
        List<model.Tany> tanyList = new ArrayList<>();

        String query = "SELECT * FROM tany";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id_tany = resultSet.getString("id_tany");
                String frontiere = resultSet.getString("frontiere");

                model.Tany tany = new model.Tany(id_tany,frontiere);
                tanyList.add(tany);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tanyList;
    }
    
    @Override
    public void insertFrontiere(String frontiere) {
            ConnectPostgres dbc = new ConnectPostgres();
            Connection connection = dbc.Connecter();
            String query = "INSERT INTO tany(frontiere) VALUES (?);";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, frontiere);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
//    @Override
//    public List<model.Tany> selectOneFrontbyId(String id, String frontiere) {
//        List<model.Tany> list = this.selectAllTany();
//        List<model.Tany> tany = new ArrayList();
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getId_personne().equals(id) && list.get(i).getFrontiere().equals(frontiere)) {
//                tany.add(list.get(i));
//            }
//        }
//        return tany;
//    }

    @Override
    public List<CoordTany> selectAllCoordTany() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertCoordTany(String frontiere, String longitude, String latitude, String idTany) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
