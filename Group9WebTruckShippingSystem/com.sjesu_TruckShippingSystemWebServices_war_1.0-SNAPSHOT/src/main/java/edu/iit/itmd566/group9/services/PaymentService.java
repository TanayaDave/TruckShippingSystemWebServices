/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.itmd566.group9.services;

import edu.iit.itmd566.group9.domain.Payment;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

     *
     * @author shrikantjesu
 */
@WebService(serviceName = "payment")
public class PaymentService {

    @WebMethod(operationName = "getPaymentsById")
    public Payment paymentService(@WebParam(name = "payid") Integer payid) throws Exception {

        Payment payment = new Payment();
        try {
            EntityManager em = Utility.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            payment = em.find(Payment.class, payid);
            trans.commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return payment;

    }
}
