package pl.test.repo;
import pl.test.model.Mesoperationdictionary;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
import static javax.transaction.Transactional.TxType.*;

public class OperationDictonaryRepo {

/*    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testPU");
    EntityManager em = entityManagerFactory.createEntityManager();*/
@PersistenceContext(unitName = "testPU")
private EntityManager em;


    public Mesoperationdictionary findById(@NotNull Integer id) {
        return em.find(Mesoperationdictionary.class, id);
    }

    public List<Mesoperationdictionary> findAll() {
        TypedQuery<Mesoperationdictionary> query = em.createQuery("from Mesoperationdictionary", Mesoperationdictionary.class);
        List<Mesoperationdictionary> mesoperationdictionaryList = query.getResultList();
       // em.close();
        return mesoperationdictionaryList;
    }

    public Long countAll() {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(b) FROM Mesoperationdictionary b", Long.class);
        Long number = query.getSingleResult();
       // em.close();
        return number;
    }

    @Transactional(REQUIRED)
    public Mesoperationdictionary create(@NotNull Mesoperationdictionary mesoperationdictionary){
     //   em.getTransaction().begin();
        em.persist(mesoperationdictionary);
      //  em.getTransaction().commit();
     //   em.close();
        return mesoperationdictionary;
    }

    @Transactional(REQUIRED)
    public void delete(@NotNull Integer id) {
      //  em.getTransaction().begin();
        em.remove(em.getReference(Mesoperationdictionary.class, id));
      //  em.getTransaction().commit();
       // em.close();
    }

}


