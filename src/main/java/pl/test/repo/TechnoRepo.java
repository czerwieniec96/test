package pl.test.repo;

import com.sun.istack.internal.NotNull;
import pl.test.model.Mestechnology;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import java.util.List;

import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
public class TechnoRepo {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testPU");
    EntityManager em = entityManagerFactory.createEntityManager();

    public Mestechnology findById(@NotNull Integer id) {
        return em.find(Mestechnology.class, id);
    }

    public List<Mestechnology> findAll() {
        TypedQuery<Mestechnology> query = em.createQuery("from Mestechnology", Mestechnology.class);
        return query.getResultList();
    }

}
