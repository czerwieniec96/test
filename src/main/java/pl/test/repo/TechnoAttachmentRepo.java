package pl.test.repo;

import com.sun.istack.internal.NotNull;
import pl.test.model.Mesattachmenttechnology;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TechnoAttachmentRepo {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testPU");
    EntityManager em = entityManagerFactory.createEntityManager();

    public Mesattachmenttechnology findAll(@NotNull Long id) {
        return em.find(Mesattachmenttechnology.class, id);
    }


    public Mesattachmenttechnology findAllbyID(Integer id) {
        TypedQuery<Mesattachmenttechnology> query = em.createQuery("from Mestechnologygroup", Mesattachmenttechnology.class);
        return (Mesattachmenttechnology) query.getResultList();
    }

}
