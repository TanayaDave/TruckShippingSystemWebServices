/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.itmd566.group9.services;

import edu.iit.itmd566.group9.domain.User;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

/**
 *
 * @author shrikantjesu
 */
@WebService(serviceName = "LoginService")
public class LoginService {

    @WebMethod(operationName = "userLogin")
    public boolean userLogin(@WebParam(name = "userName") String userName, @WebParam(name = "passoword") String passoword) {
        EntityManager em = Utility.createEntityManager();
        EntityTransaction trans = em.getTransaction();

//        trans.begin();
//        User user1 = new User();
//        user1.setUserName("admin");
//        user1.setPassword("admin");
//        user1.setUserType("admin");
//        em.persist(user1);
//        trans.commit();
//        trans.begin();
        User user = em.createNamedQuery("User.findUserByUsername", User.class).setParameter("username", userName).getSingleResult();
        if (user.getUserName().equals(userName) && user.getPassword().equals(passoword)) {

            return true;
        }
        return false;
    }

    @WebMethod(operationName = "createUser")
    public boolean createUser(@WebParam(name = "user") User user) {

        try {
            EntityManager em = Utility.createEntityManager();
            EntityTransaction trans = em.getTransaction();

            trans.begin();
            em.persist(user);
            trans.commit();
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return false;
    }

}
