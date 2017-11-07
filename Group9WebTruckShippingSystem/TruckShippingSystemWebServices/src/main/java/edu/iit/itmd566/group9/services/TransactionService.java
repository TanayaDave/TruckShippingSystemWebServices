/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.itmd566.group9.services;

import edu.iit.itmd566.group9.domain.Transaction;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author shrikantjesu
 */
@WebService(serviceName = "TransactionService")
public class TransactionService {

    @WebMethod(operationName = "getTransactionDetailsById")
    public Transaction transactionService(@WebParam(name = "tranId") Integer tranId) throws Exception {

        Transaction transaction = new Transaction();
        try {
            EntityManager em = Utility.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            transaction = em.find(Transaction.class, tranId);
            trans.commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transaction;

    }
}
