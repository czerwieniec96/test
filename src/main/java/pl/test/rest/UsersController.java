package pl.test.rest;

import pl.test.model.Mesusers;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path("/users")
public class UsersController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Mesusers> getAll(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Mesusers> resultList = entityManager.createQuery("SELECT m from Mesusers m", Mesusers.class).getResultList();
        entityManager.close();
        entityManagerFactory.close();
        return resultList;
    }
}