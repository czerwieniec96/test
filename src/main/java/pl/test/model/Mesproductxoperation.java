package pl.test.model;

import javax.persistence.*;

@Entity
public class Mesproductxoperation {
    private Integer idProductXOperation;
    private Mesproduct mesproductByIdProduct;
    private Mesoperation mesoperationByIdOperation;

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "idProductXOperation")
    public Integer getIdProductXOperation() {
        return idProductXOperation;
    }

    public void setIdProductXOperation(Integer idProductXOperation) {
        this.idProductXOperation = idProductXOperation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mesproductxoperation that = (Mesproductxoperation) o;

        if (idProductXOperation != null ? !idProductXOperation.equals(that.idProductXOperation) : that.idProductXOperation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idProductXOperation != null ? idProductXOperation.hashCode() : 0;
    }

    @ManyToOne
    @JoinColumn(name = "idProduct", referencedColumnName = "idProduct", nullable = false)
    public Mesproduct getMesproductByIdProduct() {
        return mesproductByIdProduct;
    }

    public void setMesproductByIdProduct(Mesproduct mesproductByIdProduct) {
        this.mesproductByIdProduct = mesproductByIdProduct;
    }

    @ManyToOne
    @JoinColumn(name = "idOperation", referencedColumnName = "idOperation", nullable = false)
    public Mesoperation getMesoperationByIdOperation() {
        return mesoperationByIdOperation;
    }

    public void setMesoperationByIdOperation(Mesoperation mesoperationByIdOperation) {
        this.mesoperationByIdOperation = mesoperationByIdOperation;
    }
}
