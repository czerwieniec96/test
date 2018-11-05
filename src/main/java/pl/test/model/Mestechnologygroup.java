package pl.test.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Mestechnologygroup {
    private Integer idTechnologyGroup;
    private String name;
    private String description;
    private Integer number;
    private Collection<Mestechnology> mestechnologiesByIdTechnologyGroup;

    @Id
    @Column(name = "idTechnologyGroup")
    public Integer getIdTechnologyGroup() {
        return idTechnologyGroup;
    }

    public void setIdTechnologyGroup(Integer idTechnologyGroup) {
        this.idTechnologyGroup = idTechnologyGroup;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Number")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mestechnologygroup that = (Mestechnologygroup) o;

        if (idTechnologyGroup != null ? !idTechnologyGroup.equals(that.idTechnologyGroup) : that.idTechnologyGroup != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTechnologyGroup != null ? idTechnologyGroup.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "mestechnologygroupByIdTechnologyGroup")
    public Collection<Mestechnology> getMestechnologiesByIdTechnologyGroup() {
        return mestechnologiesByIdTechnologyGroup;
    }

    public void setMestechnologiesByIdTechnologyGroup(Collection<Mestechnology> mestechnologiesByIdTechnologyGroup) {
        this.mestechnologiesByIdTechnologyGroup = mestechnologiesByIdTechnologyGroup;
    }
}
