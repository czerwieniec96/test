package pl.test.repo;

import pl.test.model.Mesproduct;
import pl.test.model.Mesproducttype;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;

public class ProductRepo {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testPU");
    EntityManager em = entityManagerFactory.createEntityManager();

    @Inject
    ProducTypeRepo producTypeRepo;

    public Mesproduct findById(@NotNull Integer id) {
        return em.find(Mesproduct.class, id);
    }

    public List<Mesproduct> findAll() {
        TypedQuery<Mesproduct> query = em.createQuery("from Mesproduct ", Mesproduct.class);
        return query.getResultList();
    }

    @Transactional(REQUIRED)
    public Mesproduct createWithId(@NotNull Mesproduct mesproduct, Integer id) {
        Mesproducttype type = producTypeRepo.findById(id);
        mesproduct.setMesproducttypeByIdProductType(type);
        em.getTransaction().begin();
        em.persist(mesproduct);
        em.getTransaction().commit();
        em.close();
        return mesproduct;
    }
    @Transactional(REQUIRED)
    public Mesproduct create(@NotNull Mesproduct mesproduct) {
        em.getTransaction().begin();
        em.persist(mesproduct);
        em.getTransaction().commit();
        em.close();
        return mesproduct;
    }

    @Transactional(REQUIRED)
    public void delete(@NotNull Integer id) {
        em.getTransaction().begin();
        em.remove(em.getReference(Mesproduct.class, id));
        em.getTransaction().commit();
        em.close();
    }

}
