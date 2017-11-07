/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.itmd566.group9.services;

import edu.iit.itmd566.group9.domain.Ticket;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author shrikantjesu
 */
@WebService(serviceName = "TicketService")
public class TicketService {

    @WebMethod(operationName = "getTicketDetailsById")
    public Ticket ticketService(@WebParam(name = "ticketId") Integer ticketId) throws Exception {

        Ticket ticket = new Ticket();
        try {
            EntityManager em = Utility.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            ticket = em.find(Ticket.class, ticketId);
            trans.commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticket;

    }
}
