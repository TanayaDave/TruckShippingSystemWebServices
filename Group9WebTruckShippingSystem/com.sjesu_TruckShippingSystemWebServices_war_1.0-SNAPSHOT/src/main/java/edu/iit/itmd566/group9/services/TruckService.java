/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.itmd566.group9.services;

import edu.iit.itmd566.group9.domain.Truck;
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
    public Truck truckService(@WebParam(name = "id") Integer id) throws Exception {

        Truck truck = new Truck();
        try {
            EntityManager em = Utility.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            truck = em.find(Truck.class, id);
            trans.commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return truck;

    }
}
