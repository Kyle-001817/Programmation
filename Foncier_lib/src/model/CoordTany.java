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
public class CoordTany implements Serializable {
    
    String id_coodTany;
    String longitude;
    String latitude;
    String id_personne;
    String id_tany;

    public CoordTany(String id_coodTany, String longitude, String latitude, String id_personne, String id_tany) {
        this.id_coodTany = id_coodTany;
        this.longitude = longitude;
        this.latitude = latitude;
        this.id_personne = id_personne;
        this.id_tany = id_tany;
    }

    public CoordTany() {
    }

    public String getId_coodTany() {
        return id_coodTany;
    }

    public void setId_coodTany(String id_coodTany) {
        this.id_coodTany = id_coodTany;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getId_personne() {
        return id_personne;
    }

    public void setId_personne(String id_personne) {
        this.id_personne = id_personne;
    }

    public String getId_tany() {
        return id_tany;
    }

    public void setId_tany(String id_tany) {
        this.id_tany = id_tany;
    }
}
