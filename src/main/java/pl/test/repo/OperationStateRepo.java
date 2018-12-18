package pl.test.repo;

import pl.test.model.Mesoperationstate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;
import static javax.transaction.Transactional.TxType.*;

public class OperationStateRepo {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testPU");
    EntityManager em = entityManagerFactory.createEntityManager();

    public Mesoperationstate findById(@NotNull Integer id) {
        Mesoperationstate mesoperationstate = em.find(Mesoperationstate.class, id);
        em.close();
        return mesoperationstate;

    }

    public List<Mesoperationstate> findAll() {
        TypedQuery<Mesoperationstate> query = em.createQuery("from Mesoperationstate", Mesoperationstate.class);
        List<Mesoperationstate> mesoperationstateList =query.getResultList();
        em.close();
        return mesoperationstateList;
    }

    public Long countAll() {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(os) FROM Mesoperationstate os", Long.class);
        Long number =query.getSingleResult();
        em.close();
        return number;
    }

    @Transactional(REQUIRED)
    public Mesoperationstate create(@NotNull Mesoperationstate mesoperationstate){
        em.getTransaction().begin();
        em.persist(mesoperationstate);
        em.getTransaction().commit();
        em.close();
        return mesoperationstate;
    }

    @Transactional(REQUIRED)
    public void delete(@NotNull Integer id) {
        em.getTransaction().begin();
        em.remove(em.getReference(Mesoperationstate.class, id));
        em.getTransaction().commit();
        em.close();
    }
}
