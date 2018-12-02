package pl.test.model;

import javax.persistence.*;

@Entity
public class Mesresourcexoperation {
    private Integer idResourceXOperation;
    private Mesoperation mesoperationByIdOperation;
    private Mesresource mesresourceByIdResource;

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
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

    @Override
    public int hashCode() {
        return idResourceXOperation != null ? idResourceXOperation.hashCode() : 0;
    }

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
