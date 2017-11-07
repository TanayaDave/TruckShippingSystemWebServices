/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.itmd566.group9.services;

import edu.iit.itmd566.group9.domain.Vehicles;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author shrikantjesu
 */
@WebService(serviceName = "VehiclesServices")
public class VehiclesServices {

    @WebMethod(operationName = "getVehicleDetailsById")
    public Vehicles vehiclesServices(@WebParam(name = "vehicleId") Integer vehicleId) throws Exception {

        Vehicles vehicle = new Vehicles();

        try {
            EntityManager em = Utility.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            vehicle = em.find(Vehicles.class, vehicleId);
            trans.commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehicle;

    }
}
