/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseConnector;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author Kyle
 */
public class ConnectPostgres {
    public Connection Connecter() {
        Connection c = null;
        String url = "";
        try {
            System.out.println(Class.forName("org.postgresql.Driver"));
            url = "jdbc:postgresql://localhost:5432/banque";
            System.out.println(url);
            c = DriverManager.getConnection(url, "postgres", "1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
}
