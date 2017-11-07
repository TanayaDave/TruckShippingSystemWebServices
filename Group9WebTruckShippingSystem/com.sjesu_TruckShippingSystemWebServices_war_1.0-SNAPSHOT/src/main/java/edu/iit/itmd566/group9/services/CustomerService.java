/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.itmd566.group9.services;

import edu.iit.itmd566.group9.domain.Customer;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author user
 */
@WebService(serviceName = "CustomerService")
public class CustomerService {

    @WebMethod(operationName = "getCustomerDetailsById")
    public Customer customerService(@WebParam(name = "custId") Integer id) throws Exception {
 

        Customer customer=new Customer();
        try {
            EntityManager em=Utility.createEntityManager();
            EntityTransaction trans=em.getTransaction();
            trans.begin();
            customer=em.find(Customer.class, id);
            trans.commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;

    }
}