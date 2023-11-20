/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Kyle
 */
public class Tany implements Serializable{  
    
    String idTany;
    String frontiere;

    public String getFrontiere() {
        return frontiere;
    }

    public void setFrontiere(String frontiere) {
        this.frontiere = frontiere;
    }
    

    public String getIdTany() {
        return idTany;
    }

    public void setIdTany(String idTany) {
        this.idTany = idTany;
    }

    public Tany(String idTany, String frontiere) {
        this.idTany = idTany;
        this.frontiere = frontiere;
    }

    public Tany() {
    }
}
