/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_foncier;

import java.util.List;
import javax.ejb.Remote;
import model.CoordTany;
import model.Tany;

/**
 *
 * @author Kyle
 */
@Remote
public interface TanyRemote {
    public List<Tany> selectAllTany();
    public void insertFrontiere(String frontiere);
    List<CoordTany> selectAllCoordTany();
    public void insertCoordTany(String frontiere,String longitude,String latitude, String idTany);
//    public List<model.Tany> selectOneFrontbyId(String id, String frontiere);
}
