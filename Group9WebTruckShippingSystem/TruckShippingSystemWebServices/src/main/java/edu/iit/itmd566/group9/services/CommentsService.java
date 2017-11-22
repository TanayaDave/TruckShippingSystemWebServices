/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.itmd566.group9.services;

import edu.iit.itmd566.group9.domain.Comments;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

     *
     * @author shrikantjesu
 */
@Path("books")
public class CommentsService {

    private static final Logger LOG = Logger.getLogger(CommentsService.class.getName());

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Comments CommentsService(@PathParam("id") int id) {
        LOG.info("commentsdata:");
        Comments comment = new Comments();
        try {
            EntityManager em = Utility.createEntityManager();

            comment = em.find(Comments.class, id);
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOG.info("commentsdata:" + comment.toString());
        return comment;

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
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
