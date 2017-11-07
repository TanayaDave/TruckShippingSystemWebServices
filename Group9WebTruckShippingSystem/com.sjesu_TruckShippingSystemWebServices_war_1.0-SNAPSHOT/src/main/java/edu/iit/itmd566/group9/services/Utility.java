/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.itmd566.group9.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author shrikantjesu
 */
public class Utility {

    public static EntityManager createEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ITMD566PU");
        EntityManager em = emf.createEntityManager();
        return em;
    }
}
