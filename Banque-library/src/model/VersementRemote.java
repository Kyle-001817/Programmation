/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.ejb.Remote;
import models.Versement;

/**
 *
 * @author Kyle
 */
@Remote
public interface VersementRemote {
    public List<Versement> selectAllVersement();
    public List<models.Versement> selectVersementbyId(String id);
    public double sommeSoldeVersementParPersonne(String idPersonne);
}
