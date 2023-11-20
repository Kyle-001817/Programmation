/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Kyle
 */
public class Versement implements Serializable{
    
    String id_versement;
    double solde_verse;
    Date date_versement;
    String id_personne;

    public String getId_versement() {
        return id_versement;
    }

    public void setId_versement(String id_versement) {
        this.id_versement = id_versement;
    }

    public double getSolde_verse() {
        return solde_verse;
    }

    public void setSolde_verse(double solde_verse) {
        this.solde_verse = solde_verse;
    }

    public Date getDate_versement() {
        return date_versement;
    }

    public void setDate_versement(Date date_versement) {
        this.date_versement = date_versement;
    }

    public String getId_personne() {
        return id_personne;
    }

    public void setId_personne(String id_personne) {
        this.id_personne = id_personne;
    }

    public Versement(String id_versement, double solde_verse, Date date_versement, String id_personne) {
        this.id_versement = id_versement;
        this.solde_verse = solde_verse;
        this.date_versement = date_versement;
        this.id_personne = id_personne;
    }

    public Versement() {
    }
}
