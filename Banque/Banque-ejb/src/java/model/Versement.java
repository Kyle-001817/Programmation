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
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author Kyle
 */

@Stateful
public class Versement implements VersementRemote{

    @Override
    public List<models.Versement> selectAllVersement() {
        ConnectPostgres dbc = new ConnectPostgres();
        Connection connect = dbc.Connecter();
        List<models.Versement> versementList = new ArrayList<>();
        String query = "SELECT * FROM versement";
        try {
            PreparedStatement preparedStatement = connect.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id_versement = resultSet.getString("id_versement");
                double solde_verse = resultSet.getDouble("solde_verse");
                Date date_versement = resultSet.getDate("date_versement");
                String id_personne = resultSet.getString("id_personne");

                models.Versement versement = new models.Versement(id_versement,solde_verse,date_versement,id_personne);
                versementList.add(versement);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return versementList;
    }

    @Override
    public List<models.Versement> selectVersementbyId(String id) {
        List<models.Versement> list = this.selectAllVersement();
        List<models.Versement> vers = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId_personne().equals(id)) {
                vers.add(list.get(i));
            }
        }
        return vers;
    }

    @Override
    public double sommeSoldeVersementParPersonne(String idPersonne) {
       double somme = 0.0;
        List<models.Versement> versementList = selectAllVersement();

        for(int i=0; i<versementList.size(); i++) {
            if (versementList.get(i).getId_personne().equals(idPersonne)) {
                somme += versementList.get(i).getSolde_verse();
            }
        }
        return somme;
        }
}
