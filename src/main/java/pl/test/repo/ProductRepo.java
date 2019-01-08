package pl.test.repo;

import pl.test.model.Mesproduct;
import pl.test.model.Mesproducttype;
import pl.test.model.Mesresource;

import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;

public class ProductRepo {
/*

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testPU");
    EntityManager em = entityManagerFactory.createEntityManager();
*/
@PersistenceContext(unitName = "testPU")
private EntityManager em;

    @Inject
    ProducTypeRepo producTypeRepo;

    public Mesproduct findById(@NotNull Integer id) {
        Mesproduct product = em.find(Mesproduct.class, id);
        //em.close();
        return product;
    }

    public List<Mesproduct> findAll() {
        TypedQuery<Mesproduct> query = em.createQuery("from Mesproduct ", Mesproduct.class);
        List<Mesproduct> mesproductList = query.getResultList();
      //  em.close();
        return mesproductList;
    }

    @Transactional(REQUIRED)
    public Mesproduct createWithId(@NotNull Mesproduct mesproduct, Integer id) {
        Mesproducttype type = producTypeRepo.findById(id);
        mesproduct.setMesproducttypeByIdProductType(type);
     //   em.getTransaction().begin();
        em.persist(mesproduct);
     //   em.getTransaction().commit();
       // em.close();
        return mesproduct;
    }
    @Transactional(REQUIRED)
    public Mesproduct create(@NotNull Mesproduct mesproduct) {
       // em.getTransaction().begin();
        em.persist(mesproduct);
     //   em.getTransaction().commit();
     //   em.close();
        return mesproduct;
    }

    @Transactional(REQUIRED)
    public void delete(@NotNull Integer id) {
     //   em.getTransaction().begin();
        em.remove(em.getReference(Mesproduct.class, id));
     //   em.getTransaction().commit();
     //   em.close();
    }

}
