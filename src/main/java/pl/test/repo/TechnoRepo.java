package pl.test.repo;

import com.sun.istack.internal.NotNull;
import pl.test.model.Mesattachmenttechnology;
import pl.test.model.Mestechnology;
import pl.test.model.Mestechnologygroup;


import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;

import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
public class TechnoRepo {
/*    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testPU");
    EntityManager em = entityManagerFactory.createEntityManager();*/

    @PersistenceContext(unitName = "testPU")
    private EntityManager em;

    public Mestechnology findById(@NotNull Integer id) {
        Mestechnology tech = em.find(Mestechnology.class, id);
        //em.close();
        return tech;
    }

    public List<Mestechnology> findAll() {
        TypedQuery<Mestechnology> query = em.createQuery("from Mestechnology", Mestechnology.class);
        List <Mestechnology> mestechnologyList = query.getResultList();
      //  em.close();
        return mestechnologyList;
    }

    public Mesattachmenttechnology findAttachemntById(@NotNull Integer id) {
        Mesattachmenttechnology mesattachmenttechnology = em.find(Mesattachmenttechnology.class, id);
       // em.close();
        return mesattachmenttechnology;
    }


    public List<Mesattachmenttechnology> findAttachmentsByTechnology(Integer idTechnology) {
        TypedQuery<Mesattachmenttechnology> query = em.createQuery("select at from Mesattachmenttechnology at " +
                "where at.mestechnologyByIdTechnology.idTechnology = :id ", Mesattachmenttechnology.class);
        query.setParameter("id", idTechnology);
        List <Mesattachmenttechnology> attachmentList = query.getResultList();
      //  em.close();
        return attachmentList;
    }

    @Transactional(REQUIRED)
    public Mestechnology create(@NotNull Mestechnology mestechnology) {
       // em.getTransaction().begin();
        em.persist(mestechnology);
      //  em.getTransaction().commit();
      //  em.close();
        return mestechnology;
    }

    @Transactional(REQUIRED)
    public void delete(@NotNull Integer id) {
     //   em.getTransaction().begin();
        em.remove(em.getReference(Mestechnology.class, id));
      //  em.getTransaction().commit();
       // em.close();
    }

    @Transactional(REQUIRED)
    public Mesattachmenttechnology createAttachment(@NotNull Mesattachmenttechnology attachment) {
      //  em.getTransaction().begin();
        em.persist(attachment);
      //  em.getTransaction().commit();
      //  em.close();
        return attachment;
    }

    @Transactional(REQUIRED)
    public void deleteAttachment(@NotNull Integer id) {
     //  em.getTransaction().begin();
        em.remove(em.getReference(Mesattachmenttechnology.class, id));
      //  em.getTransaction().commit();
      //  em.close();
    }

}
