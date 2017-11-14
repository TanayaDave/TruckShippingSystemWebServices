/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.itmd566.group9.services;

import edu.iit.itmd566.group9.domain.Location;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

     *
     * @author shrikantjesu
 */
@WebService(serviceName = "location")
public class LocationService {
    
    @WebMethod(operationName = "getLocationById")
    public Location locationService(@WebParam(name = "locid") Integer loctid) {
        
        Location location = new Location();
        try {
            EntityManager em = Utility.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            location = em.find(Location.class, loctid);
            trans.commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return location;
        
    }
    
    @WebMethod(operationName = "createNewLocation")
    public boolean createNewLocation(Location location) {
        try {
            EntityManager em = Utility.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            em.persist(location);
            trans.commit();
            em.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @WebMethod(operationName = "getAllLocation")
    public List<Location> getAllLocation() {
        List<Location> locList = new ArrayList<>();
        try {
            EntityManager em = Utility.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            locList = em.createNamedQuery("Location.getAllLocation", Location.class).getResultList();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return locList;
    }
    
    @WebMethod(operationName = "updateLocation")
    public boolean updateLocation(Location location) {
        try {
            EntityManager em = Utility.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            Location locObj = new Location();
            trans.begin();
            LOG.info("checkLoc:"+location.toString());
            locObj = em.find(Location.class, location.getLocId());
            locObj.setLocCode(location.getLocCode());
            locObj.setLocName(location.getLocName());
            locObj.setPrice(location.getPrice());
            em.merge(location);
            trans.commit();
            em.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    private static final Logger LOG = Logger.getLogger(LocationService.class.getName());
    
    @WebMethod(operationName = "deleteLocation")
    public boolean deleteLocation(Integer id) {
        try {
            EntityManager em = Utility.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            Location locObj = new Location();
            trans.begin();
            locObj = em.find(Location.class, id);
            em.remove(locObj);
            trans.commit();
            em.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
