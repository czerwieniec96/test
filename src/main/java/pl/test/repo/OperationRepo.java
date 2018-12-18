package pl.test.repo;

import com.sun.istack.internal.NotNull;
import pl.test.model.Mesoperation;
import pl.test.model.Mesproductxoperation;
import pl.test.model.Mesresourcexoperation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;


public class OperationRepo {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testPU");
    EntityManager em = entityManagerFactory.createEntityManager();

    public Mesoperation findById(@NotNull Integer id) {
       Mesoperation mesoperation =em.find(Mesoperation.class,id);
       em.close();
       return mesoperation;
    }

    public Mesoperation findByNumber(@NotNull Integer number) {
      TypedQuery<Mesoperation> query = em.createQuery("select o from Mesoperation o where o.number = :number", Mesoperation.class);
      query.setParameter("number", number);
      Mesoperation mesoperation = query.getSingleResult();
      em.close();
      return mesoperation;
    }

    public List<Mesresourcexoperation> findResourcesByOperation(@NotNull Integer idoper) {
        TypedQuery<Mesresourcexoperation> query = em.createQuery("SELECT o FROM Mesresourcexoperation o " +
                "WHERE o.mesoperationByIdOperation.id = :idoper", Mesresourcexoperation.class);
                    query.setParameter("idoper", idoper);
        List<Mesresourcexoperation> mesresourcexoperationList =query.getResultList();
        em.close();
        return mesresourcexoperationList;
    }

    public List<Mesproductxoperation> findProductsByOperation(@NotNull Integer idoper) {
        TypedQuery<Mesproductxoperation> query = em.createQuery("SELECT o FROM Mesproductxoperation o " +
                "WHERE o.mesoperationByIdOperation.id = :idoper", Mesproductxoperation.class);
                    query.setParameter("idoper", idoper);
        List<Mesproductxoperation> mesproductxoperationList = query.getResultList();
        em.close();
        return mesproductxoperationList;
    }



    public List<Mesresourcexoperation> findRXOAall() {
        TypedQuery<Mesresourcexoperation> query = em.createQuery("from Mesresourcexoperation ", Mesresourcexoperation.class);

        return query.getResultList();
    }

    public List<Mesproductxoperation> findPXOAll() {
       TypedQuery<Mesproductxoperation> query = em.createQuery("from Mesproductxoperation", Mesproductxoperation.class);

        return query.getResultList();
    }

    public List<Mesoperation> findAll() {
       TypedQuery<Mesoperation> query = em.createQuery("from Mesoperation; ", Mesoperation.class);

        return query.getResultList();
    }

    public List<Mesoperation> getOperationByTechno(Integer id) {
        TypedQuery<Mesoperation> query = em.createQuery("SELECT o FROM Mesoperation o WHERE o.mestechnologyByIdTechnology.id = :id", Mesoperation.class);
        List<Mesoperation> mesoperationList = query.setParameter("id", id).getResultList();
        em.close();
        return mesoperationList;
    }

    @Transactional(REQUIRED)
    public Mesoperation create(@NotNull Mesoperation mesoperation) {
        em.getTransaction().begin();
        em.persist(mesoperation);
        em.getTransaction().commit();
        em.close();
        return mesoperation;
    }
    @Transactional(REQUIRED)
    public Mesresourcexoperation createOperationXResource(@NotNull Mesresourcexoperation rxo) {
        em.getTransaction().begin();
        em.persist(rxo);
        em.getTransaction().commit();
        em.close();
        return rxo;
    }

    @Transactional(REQUIRED)
    public Mesproductxoperation createOperationXProduct(@NotNull Mesproductxoperation pxo) {
        em.getTransaction().begin();
        em.persist(pxo);
        em.getTransaction().commit();
        em.close();
        return pxo;
    }

    @Transactional(REQUIRED)
    public void delete(@NotNull Integer id) {

           em.getTransaction().begin();
           em.remove(em.getReference(Mesoperation.class, id));
           em.getTransaction().commit();
           em.close();

    }


    @Transactional(REQUIRED)
    public void deleteOperationXResource(@NotNull Integer id) {
        em.getTransaction().begin();
        em.remove(em.getReference(Mesresourcexoperation.class, id));
        em.getTransaction().commit();
        em.close();
    }


    @Transactional(REQUIRED)
    public void deleteOperationXProduct(@NotNull Integer id) {
        em.getTransaction().begin();
        em.remove(em.getReference(Mesproductxoperation.class, id));
        em.getTransaction().commit();
        em.close();
    }


}
