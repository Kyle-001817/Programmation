/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;
import java.util.List;
import javax.ejb.Remote;
import models.Retrait;

/**
 *
 * @author Kyle
 */
@Remote
public interface RetraitRemote {
    public List<Retrait> selectAllRetraits();
    public void insert(Double solde_retrait, Timestamp date_retrait, String id_personne);
}
