/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.itmd566.group9.services;

import edu.iit.itmd566.group9.domain.Pricing;
import java.util.ArrayList;
import java.util.List;
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
@WebService(serviceName = "price")
public class PricingService {

    @WebMethod(operationName = "getPriceById")
    public String priceService(@WebParam(name = "priceid") Integer prcid) throws Exception {

        Pricing price = new Pricing();
        try {
            EntityManager em = Utility.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            price = em.find(Pricing.class, prcid);
            trans.commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return price.toString();

    }

    @WebMethod(operationName = "getPricing")
    public List<Pricing> getPricing() {
        EntityManager em = Utility.createEntityManager();
        List<Pricing> pricingList = new ArrayList<>();
        try {
            pricingList = em.createQuery("Select c from Pricing c", Pricing.class).getResultList();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pricingList;

    }
}
