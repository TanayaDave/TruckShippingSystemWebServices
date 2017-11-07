/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.itmd566.group9.services;

import edu.iit.itmd566.group9.domain.Drivers;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author user
 */
@WebService(serviceName = "DriversService")
public class DriversService {

    @WebMethod(operationName = "getDriverDetailsById")
    public Drivers driversService(@WebParam(name = "id") Long id) throws Exception {

        Drivers driver = new Drivers();
        try {
            EntityManager em = Utility.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            driver = em.find(Drivers.class, id);
            trans.commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;

    }
}
