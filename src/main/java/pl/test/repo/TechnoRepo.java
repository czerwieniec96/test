package pl.test.repo;

import com.sun.istack.internal.NotNull;
import pl.test.model.Mestechnology;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
public class TechnoRepo {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testPU");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<Object[]> findById(@NotNull Integer id) {
        TypedQuery<Object[]> query = em.createQuery("select t.name, t.number, t.state, t.mestechnologygroupByIdTechnologyGroup.name from Mestechnology t where t.idTechnology =:id" , Object[].class)
                .setParameter("id",id);
        return query.getResultList();
    }

    public List<Object[]> findAll() {
        TypedQuery<Object[]> query = em.createQuery("select t.name, t.number from Mestechnology t", Object[].class);
        return query.getResultList();
    }
}
