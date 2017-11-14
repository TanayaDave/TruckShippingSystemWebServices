/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.itmd566.group9.services;

import edu.iit.itmd566.group9.domain.Comments;
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
@WebService(serviceName = "CommentsService")
public class CommentsService {

    @WebMethod(operationName = "getCommentsById")
    public Boolean CommentsService(@WebParam(name = "comment") Comments comment) {

        try {
            EntityManager em = Utility.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            em.persist(em);
            trans.commit();
            em.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    @WebMethod(operationName = "getCommentsList")
    public List<Comments> getComments() {
        EntityManager em = Utility.createEntityManager();
        List<Comments> commentList = new ArrayList<>();
        try {
            commentList = em.createNamedQuery("Comments.getAllComments", Comments.class).getResultList();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commentList;

    }

}
