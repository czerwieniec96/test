package pl.test.model;

import javax.persistence.*;

@Entity
public class Mesproduct {
    private Integer idProduct;
    private String name;
    private String description;
    private Mesproducttype mesproducttypeByIdProductType;

    @Id
    @Column(name = "idProduct")
    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mesproduct that = (Mesproduct) o;

        if (idProduct != null ? !idProduct.equals(that.idProduct) : that.idProduct != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProduct != null ? idProduct.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idProductType", referencedColumnName = "idProductType", nullable = false)
    public Mesproducttype getMesproducttypeByIdProductType() {
        return mesproducttypeByIdProductType;
    }

    public void setMesproducttypeByIdProductType(Mesproducttype mesproducttypeByIdProductType) {
        this.mesproducttypeByIdProductType = mesproducttypeByIdProductType;
    }
}
