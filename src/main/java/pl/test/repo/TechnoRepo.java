package pl.test.repo;

import com.sun.istack.internal.NotNull;
import pl.test.model.Mestechnology;
import pl.test.model.Mestechnologygroup;


import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
public class TechnoRepo {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testPU");
    EntityManager em = entityManagerFactory.createEntityManager();

    @Inject
    TechnologyGroupRepo groupRepo;

    public Mestechnology findById(@NotNull Integer id) {
        return em.find(Mestechnology.class, id);
    }

    public List<Mestechnology> findAll() {
        TypedQuery<Mestechnology> query = em.createQuery("from Mestechnology", Mestechnology.class);
        return query.getResultList();
    }

    @Transactional(REQUIRED)
    public Mestechnology create(@NotNull Mestechnology mestechnology) {
        em.getTransaction().begin();
        em.persist(mestechnology);
        em.getTransaction().commit();
        em.close();
        return mestechnology;
    }

    @Transactional(REQUIRED)
    public void delete(@NotNull Integer id) {
        em.getTransaction().begin();
        em.remove(em.getReference(Mestechnology.class, id));
        em.getTransaction().commit();
        em.close();
    }

}
