/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.itmd566.group9.services;

import edu.iit.itmd566.group9.domain.Maintenance;
import java.util.ArrayList;
import java.util.List;
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
@WebService(serviceName = "maintenance")
public class MaintenanceService {

    @WebMethod(operationName = "getMaintenanceById")
    public Maintenance maintenanceService(@WebParam(name = "id") Integer mntid) {

        Maintenance maintain = new Maintenance();
        try {
            EntityManager em = Utility.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            maintain = em.find(Maintenance.class, mntid);
            trans.commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maintain;

    }

    @WebMethod(operationName = "createMaintenance")
    public Boolean createMaintenance(@WebParam(name = "maintenance") Maintenance maintenance) {

        Maintenance maintain = new Maintenance();
        try {
            EntityManager em = Utility.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            em.persist(maintenance);
            trans.commit();
            em.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    @WebMethod(operationName = "getAllMaintenance")
    public List<Maintenance> getAllMaintenance() {

        List<Maintenance> maintainList = new ArrayList<>();
        try {
            EntityManager em = Utility.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            maintainList = em.createNamedQuery("Maintenance.getAllMaintenance", Maintenance.class).getResultList();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maintainList;

    }
    
    @WebMethod(operationName = "deleteMaintenanceById")
    public Maintenance deleteMaintenanceById(@WebParam(name = "id") Integer mntid) {

        Maintenance maintain = new Maintenance();
        try {
            EntityManager em = Utility.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            maintain = em.find(Maintenance.class, mntid);
            em.remove(maintain);
            trans.commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maintain;

    }
    
    @WebMethod(operationName = "updateMaintenanceById")
    public void updateMaintenanceById(@WebParam(name = "maintenance") Maintenance maintenance) {

        Maintenance maintenanceObj = new Maintenance();
        try {
            EntityManager em = Utility.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            maintenanceObj = em.find(Maintenance.class, maintenance.getId());
            maintenanceObj.setCost(maintenance.getCost());
            maintenanceObj.setDate(maintenance.getDate());
            maintenanceObj.setDesc(maintenance.getDesc());
            maintenanceObj.setStatus(maintenance.getStatus());
            em.merge(maintenanceObj);
            trans.commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
}
