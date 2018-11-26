package pl.test.repo;

import com.sun.istack.internal.NotNull;
import pl.test.model.Mesusers;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

import static javax.transaction.Transactional.TxType.SUPPORTS;
import static javax.transaction.Transactional.TxType.REQUIRED;

@Transactional(SUPPORTS)
public class UserRepo {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testPU");
    EntityManager em = entityManagerFactory.createEntityManager();

    public Mesusers find(@NotNull Integer id) {
        return em.find(Mesusers.class, id);
    }

    public List<Mesusers> findAll() {
        TypedQuery<Mesusers> query = em.createQuery("from Mesusers", Mesusers.class);
        return query.getResultList();
    }
    public Boolean isEgsisting(String name, String password) {
        TypedQuery<Mesusers> query = em.createQuery("from Mesusers where name=:name and password=:password", Mesusers.class);
        query.setParameter(name, name);
        query.setParameter(password, password);
        if (query.getSingleResult()!=null)
            return true;

        else return false;
    }


    @Transactional(REQUIRED)
    public Mesusers create(@NotNull Mesusers user) {

        em.persist(user);
        return user;
    }



    @Transactional(REQUIRED)
    public void delete(@NotNull Integer id) {
        em.remove(em.getReference(Mesusers.class, id));
    }
}
