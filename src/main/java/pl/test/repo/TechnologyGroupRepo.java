package pl.test.repo;

import com.sun.istack.internal.NotNull;
import pl.test.model.Mestechnology;
import pl.test.model.Mestechnologygroup;


import javax.enterprise.inject.Produces;
import javax.persistence.*;
import javax.transaction.Transactional;

import java.util.List;

import static javax.transaction.Transactional.TxType.*;

@Transactional(SUPPORTS)
public class TechnologyGroupRepo {

 /*   EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testPU");
    EntityManager em = entityManagerFactory.createEntityManager();*/


    @PersistenceContext(unitName = "testPU")
    private EntityManager em;




    public Mestechnologygroup findById(@NotNull Integer id) {
        Mestechnologygroup group = em.find(Mestechnologygroup.class, id);
        return group;
    }

    public List<Mestechnologygroup> findAll() {
        TypedQuery<Mestechnologygroup> query = em.createQuery("select tg from Mestechnologygroup tg order by tg.number ASC ", Mestechnologygroup.class);
        List<Mestechnologygroup> groups =query.getResultList();
        return groups;
    }

    @Transactional(REQUIRED)
    public Mestechnologygroup create(@NotNull Mestechnologygroup techgroup) {
        em.persist(techgroup);
        return techgroup;
    }

    public Long countAll() {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(b) FROM Mestechnologygroup b", Long.class);
        Long number = query.getSingleResult();
        return number;
    }

    @Transactional(REQUIRED)
    public void delete(@NotNull Integer id) {
        em.remove(em.getReference(Mestechnologygroup.class, id));
    }


}
