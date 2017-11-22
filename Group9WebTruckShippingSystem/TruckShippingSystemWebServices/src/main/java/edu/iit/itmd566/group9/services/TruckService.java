/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.itmd566.group9.services;

import edu.iit.itmd566.group9.domain.Truck;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author user
 */
@WebService(serviceName = "TruckService")
public class TruckService {
    
    @WebMethod(operationName = "getTruckDetailsById")
    public Truck truckServiceById(@WebParam(name = "id") Integer id) {
        
        Truck truck = new Truck();
        boolean flag = true;
        try {
            EntityManager em = Utility.createEntityManager();
            truck = em.find(Truck.class, id);
            em.close();
            LOG.info("truckData:" + truck.toString());
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return truck;
        
    }
    private static final Logger LOG = Logger.getLogger(TruckService.class.getName());
    
    @WebMethod(operationName = "createTruck")
    public Boolean createTruck(@WebParam(name = "truck") Truck truck) {
        
        try {
            EntityManager em = Utility.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            em.persist(truck);
            trans.commit();
            em.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
        
    }
    
    @WebMethod(operationName = "getAllTrucks")
    public List<Truck> getAllTrucks() {
        List<Truck> truckList = new ArrayList<>();
        Truck truck = new Truck();
        try {
            EntityManager em = Utility.createEntityManager();
            truckList = em.createNamedQuery("Truck.getAllTrucks", Truck.class).getResultList();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return truckList;
        
    }
    
    @WebMethod(operationName = "updateTruck")
    public Boolean updateTruck(@WebParam(name = "truck") Truck truck) {
        
        try {
            EntityManager em = Utility.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            Truck truckObj = new Truck();
            trans.begin();
            LOG.info("checktruck" + truck.toString());
            truckObj = em.find(Truck.class, truck.getId());
            truckObj.setVin(truck.getVin());
            truckObj.setColor(truck.getColor());
            truckObj.setCapacity(truck.getCapacity());
            truckObj.setType(truck.getType());
            truckObj.setLicPlateNo(truck.getLicPlateNo());
            truckObj.setYear(truck.getYear());
            em.merge(truckObj);
            trans.commit();
            em.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
        
    }
    
    @WebMethod(operationName = "deleteTruck")
    public Boolean deleteTruck(int id) throws Exception {
        EntityManager em = Utility.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        trans.begin();
        em.remove(em.find(Truck.class, id));
        trans.commit();
        em.close();
        
        return true;
    }
    
}
