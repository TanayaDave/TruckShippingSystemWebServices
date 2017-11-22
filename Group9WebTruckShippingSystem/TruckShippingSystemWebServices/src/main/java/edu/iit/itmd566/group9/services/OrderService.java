/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.itmd566.group9.services;

import edu.iit.itmd566.group9.domain.Order;
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
@WebService(serviceName = "OrderService")
public class OrderService {
    
    @WebMethod(operationName = "getOrderDetailsById")
    public Order orderService(@WebParam(name = "orderId") Integer id) throws Exception {
        
        Order order = new Order();
        try {
            EntityManager em = Utility.createEntityManager();
//            EntityTransaction trans = em.getTransaction();
//            trans.begin();
            LOG.info("DATA:" + em.find(Order.class, id).toString());
            order = em.find(Order.class, id);
//            trans.commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
        
    }
    private static final Logger LOG = Logger.getLogger(OrderService.class.getName());
    
    @WebMethod(operationName = "getOrderList")
    public List<Order> getOrderList() {
        EntityManager em = Utility.createEntityManager();
        List<Order> orderList = new ArrayList<>();
        try {
            orderList = em.createQuery("Select c from OrderTable c", Order.class).getResultList();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
        
    }
    
}
