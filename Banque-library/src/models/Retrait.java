/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Kyle
 */
public class Retrait implements Serializable{
    String id_retrait;
    Double solde_retrait;
    Timestamp date_retrait;
    String id_personne;

    public String getId_retrait() {
        return id_retrait;
    }

    public void setId_retrait(String id_retrait) {
        this.id_retrait = id_retrait;
    }

    public Double getSolde_retrait() {
        return solde_retrait;
    }

    public void setSolde_retrait(Double solde_retrait) {
        this.solde_retrait = solde_retrait;
    }

    public Timestamp getDate_retrait() {
        return date_retrait;
    }

    public void setDate_retrait(Timestamp date_retrait) {
        this.date_retrait = date_retrait;
    }

    public String getId_personne() {
        return id_personne;
    }

    public void setId_personne(String id_personne) {
        this.id_personne = id_personne;
    }

    public Retrait(String id_retrait, Double solde_retrait, Timestamp date_retrait, String id_personne) {
        this.id_retrait = id_retrait;
        this.solde_retrait = solde_retrait;
        this.date_retrait = date_retrait;
        this.id_personne = id_personne;
    }
    
    public Retrait() {
    }
}
