/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.itmd566.group9.services;

import edu.iit.itmd566.group9.domain.Invoice;
import edu.iit.itmd566.group9.domain.Order;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author shrikantjesu
 */
@WebService(serviceName = "InvoiceService")
public class InvoiceService {

    @WebMethod(operationName = "getInvoiceDetailsById")
    public Invoice invoiceService(@WebParam(name = "invoiceId") Integer empId) throws Exception {

        Invoice invoice = new Invoice();
        try {
            EntityManager em = Utility.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            invoice = em.find(Invoice.class, empId);
            trans.commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return invoice;

    }

    @WebMethod(operationName = "getInvoiceList")
    public List<Invoice> getInvoiceList() {
        EntityManager em = Utility.createEntityManager();
        List<Invoice> invoiceList = new ArrayList<>();
        try {
            invoiceList = em.createQuery("Select i from Invoice i", Invoice.class).getResultList();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return invoiceList;

    }
}
