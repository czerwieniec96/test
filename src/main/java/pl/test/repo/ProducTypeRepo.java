package pl.test.repo;

import pl.test.model.Mesproducttype;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;
import static javax.transaction.Transactional.TxType.*;

public class ProducTypeRepo {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testPU");
    EntityManager em = entityManagerFactory.createEntityManager();

    public Mesproducttype findById(@NotNull Integer id) {
        return em.find(Mesproducttype.class, id);
    }

    public List<Mesproducttype> findAll() {
        TypedQuery<Mesproducttype> query = em.createQuery("from Mesproducttype ", Mesproducttype.class);
        return query.getResultList();
    }

    public Long countAll() {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(pt) FROM Mesproducttype pt", Long.class);
        return query.getSingleResult();
    }

    @Transactional(REQUIRED)
    public Mesproducttype create(@NotNull Mesproducttype mesproducttype){
        em.getTransaction().begin();
        em.persist(mesproducttype);
        em.getTransaction().commit();
        em.close();
        return mesproducttype;
    }

    @Transactional(REQUIRED)
    public void delete(@NotNull Integer id) {
        em.getTransaction().begin();
        em.remove(em.getReference(Mesproducttype.class, id));
        em.getTransaction().commit();
        em.close();
    }
}
