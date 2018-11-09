package pl.test.repo;

import com.sun.istack.internal.NotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TechnoAttachmentRepo {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testPU");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<Object[]> onefindById(@NotNull Integer id) {
        TypedQuery<Object[]> query = em.createQuery("select at.name, at.link, at.mestechnologyByIdTechnology.name from Mesattachmenttechnology at where at.mestechnologyByIdTechnology.idTechnology =:id" , Object[].class)
                .setParameter("id",id);

        return query.getResultList();
    }

    public List<Object[]> findAllbyID(Integer id) {
        TypedQuery<Object[]> query = em.createQuery("select t.name, t.number from Mestechnologygroup t", Object[].class);
        return query.getResultList();
    }

}
