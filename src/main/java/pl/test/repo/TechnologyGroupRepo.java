package pl.test.repo;

import com.sun.istack.internal.NotNull;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import java.util.List;

import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
public class TechnologyGroupRepo {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testPU");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<Object[]> findById(@NotNull Integer id) {
        TypedQuery<Object[]> query = em.createQuery("select t.name, t.number, t.description from Mestechnologygroup t where t.idTechnologyGroup =:id" , Object[].class)
                .setParameter("id",id);
        return query.getResultList();
    }

    public List<Object[]> findAll() {
        TypedQuery<Object[]> query = em.createQuery("select t.name, t.number from Mestechnologygroup t", Object[].class);
        return query.getResultList();
    }


//dodać dodawanie i deletowanie




}
