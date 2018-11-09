package pl.test.repo;

import com.sun.istack.internal.NotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;



public class OperationRepo {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testPU");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<Object[]> findById(@NotNull Integer id) {
        TypedQuery<Object[]> query = em.createQuery("select t.name, t.number, t.mesoperationstateByIdOperationstate.state, t.mesoperationdictionaryByIdOperationdictionary.name, t.mestechnologyByIdTechnology.name from Mesoperation t where t.idOperation =:id" , Object[].class)
                .setParameter("id",id);
        return query.getResultList();
    }

    public List<Object[]> findAll() {
        TypedQuery<Object[]> query = em.createQuery("select t.name, t.number from Mesoperation t", Object[].class);
        return query.getResultList();
    }

}
