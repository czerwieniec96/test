package pl.test.repo;

import com.sun.istack.internal.NotNull;
import pl.test.model.Mestechnologygroup;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import java.util.List;

import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
public class TechnologyGroupRepo {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testPU");
    EntityManager em = entityManagerFactory.createEntityManager();

    public Mestechnologygroup findById(@NotNull Integer id) {
        return em.find(Mestechnologygroup.class, id);
    }

    public List<Mestechnologygroup> findAll() {
        TypedQuery<Mestechnologygroup> query = em.createQuery("from Mestechnologygroup", Mestechnologygroup.class);
        return query.getResultList();
    }


//dodać dodawanie i deletowanie




}
