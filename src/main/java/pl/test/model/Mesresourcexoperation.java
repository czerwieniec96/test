package pl.test.model;

import javax.persistence.*;
import java.util.concurrent.CopyOnWriteArrayList;

@Entity
public class Mesresourcexoperation {
    private Integer idResourceXOperation;
    private Mesoperation mesoperationByIdOperation;
    private Mesresource mesresourceByIdResource;

    @Id
    @Column(name = "idResourceXOperation")
    public Integer getIdResourceXOperation() {
        return idResourceXOperation;
    }

    public void setIdResourceXOperation(Integer idResourceXOperation) {
        this.idResourceXOperation = idResourceXOperation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mesresourcexoperation that = (Mesresourcexoperation) o;


        if (idResourceXOperation != null ? !idResourceXOperation.equals(that.idResourceXOperation) : that.idResourceXOperation != null)
            return false;

        return true;
    }

   /* @Override
    public int hashCode() {
        int idResource;
        int result = idResource != null ? idResource.hashCode() : 0;
        result = 31 * result + (idResourceXOperation != null ? idResourceXOperation.hashCode() : 0);
        return result;
    }
*/
    @ManyToOne
    @JoinColumn(name = "idOperation", referencedColumnName = "idOperation", nullable = false)
    public Mesoperation getMesoperationByIdOperation() {
        return mesoperationByIdOperation;
    }

    public void setMesoperationByIdOperation(Mesoperation mesoperationByIdOperation) {
        this.mesoperationByIdOperation = mesoperationByIdOperation;
    }

    @ManyToOne
    @JoinColumn(name = "idResource", referencedColumnName = "idResource")
    public Mesresource getMesresourceByIdResource() {
        return mesresourceByIdResource;
    }

    public void setMesresourceByIdResource(Mesresource mesresourceByIdResource) {
        this.mesresourceByIdResource = mesresourceByIdResource;
    }
}
