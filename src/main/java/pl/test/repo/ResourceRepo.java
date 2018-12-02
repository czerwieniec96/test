package pl.test.repo;

import com.sun.istack.internal.NotNull;
import pl.test.model.Mesresource;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import static javax.transaction.Transactional.TxType.*;

public class ResourceRepo {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testPU");
    EntityManager em = entityManagerFactory.createEntityManager();

    public Mesresource findById(@NotNull Integer id) {
        return em.find(Mesresource.class, id);
    }

    public List<Mesresource> findAll() {
        TypedQuery<Mesresource> query = em.createQuery("from Mesresource ", Mesresource.class);
        return query.getResultList();
    }

    public Long countAll() {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(r) FROM Mesresource r", Long.class);
        return query.getSingleResult();
    }

    @Transactional(REQUIRED)
    public Mesresource create(@NotNull Mesresource mesoperationdictionary){
        em.getTransaction().begin();
        em.persist(mesoperationdictionary);
        em.getTransaction().commit();
        em.close();
        return mesoperationdictionary;
    }

    @Transactional(REQUIRED)
    public void delete(@NotNull Integer id) {
        em.getTransaction().begin();
        em.remove(em.getReference(Mesresource.class, id));
        em.getTransaction().commit();
        em.close();
    }

}
