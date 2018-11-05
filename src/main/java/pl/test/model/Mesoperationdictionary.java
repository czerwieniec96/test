package pl.test.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Mesoperationdictionary {
    private Integer idOperationDictionary;
    private String name;
    private String description;
    private Collection<Mesoperation> mesoperationsByIdOperationDictionary;

    @Id
    @Column(name = "idOperationDictionary")
    public Integer getIdOperationDictionary() {
        return idOperationDictionary;
    }

    public void setIdOperationDictionary(Integer idOperationDictionary) {
        this.idOperationDictionary = idOperationDictionary;
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

        Mesoperationdictionary that = (Mesoperationdictionary) o;

        if (idOperationDictionary != null ? !idOperationDictionary.equals(that.idOperationDictionary) : that.idOperationDictionary != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOperationDictionary != null ? idOperationDictionary.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "mesoperationdictionaryByIdOperationdictionary")
    public Collection<Mesoperation> getMesoperationsByIdOperationDictionary() {
        return mesoperationsByIdOperationDictionary;
    }

    public void setMesoperationsByIdOperationDictionary(Collection<Mesoperation> mesoperationsByIdOperationDictionary) {
        this.mesoperationsByIdOperationDictionary = mesoperationsByIdOperationDictionary;
    }
}
