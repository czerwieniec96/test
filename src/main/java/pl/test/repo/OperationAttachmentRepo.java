package pl.test.repo;

import com.sun.istack.internal.NotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class OperationAttachmentRepo {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testPU");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<Object[]> onefindById(@NotNull Integer id) {
        TypedQuery<Object[]> query = em.createQuery("select at.name, at.link, at.mesoperationByIdOperation.name from Mesattachmentoperation at where at.mesoperationByIdOperation.id=:id" , Object[].class)
                .setParameter("id",id);

        return query.getResultList();
    }

    public List<Object[]> findAllbyID(Integer id) {
        TypedQuery<Object[]> query = em.createQuery("select t.name from Mesattachmentoperation t", Object[].class);
        return query.getResultList();
    }

}
