/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.itmd566.group9.services;

import edu.iit.itmd566.group9.domain.Expense;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author user
 */
@WebService(serviceName = "ExpenseService")
public class ExpenseService {

    @WebMethod(operationName = "getExpenseDetailsById")
    public Expense expenseService(@WebParam(name = "expId") Integer id) throws Exception {

        Expense expense = new Expense();
        try {
            EntityManager em = Utility.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            expense = em.find(Expense.class, id);
            trans.commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return expense;

    }
}
