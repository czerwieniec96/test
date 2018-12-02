package pl.test.repo;

import com.sun.istack.internal.NotNull;
import pl.test.model.Mestechnologygroup;


import javax.enterprise.inject.Produces;
import javax.persistence.*;
import javax.transaction.Transactional;

import java.util.List;

import static javax.transaction.Transactional.TxType.*;

@Transactional(SUPPORTS)
public class TechnologyGroupRepo {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testPU");
    EntityManager em = entityManagerFactory.createEntityManager();
/*
    @PersistenceContext(unitName = "testPU")
    private EntityManager em;

*/


    public Mestechnologygroup findById(@NotNull Integer id) {
        return em.find(Mestechnologygroup.class, id);
    }

    public List<Mestechnologygroup> findAll() {
        TypedQuery<Mestechnologygroup> query = em.createQuery("select tg from Mestechnologygroup tg order by tg.number ASC ", Mestechnologygroup.class);
        return query.getResultList();
    }

    @Transactional(REQUIRED)
    public Mestechnologygroup create(@NotNull Mestechnologygroup techgroup) {
        em.getTransaction().begin();
        em.persist(techgroup);
        em.getTransaction().commit();
        em.close();
        return techgroup;
    }

    public Long countAll() {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(b) FROM Mestechnologygroup b", Long.class);
        return query.getSingleResult();
    }

    @Transactional(REQUIRED)
    public void delete(@NotNull Integer id) {
        em.getTransaction().begin();
        em.remove(em.getReference(Mestechnologygroup.class, id));
        em.getTransaction().commit();
        em.close();
    }


}
