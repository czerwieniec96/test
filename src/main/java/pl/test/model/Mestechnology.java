package pl.test.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Mestechnology {
    private Integer idTechnology;
    private Integer number;
    private String name;
    private Boolean state;
    private Collection<Mesattachmenttechnology> mesattachmenttechnologiesByIdTechnology;
    private Collection<Mesoperation> mesoperationsByIdTechnology;
    private Mestechnologygroup mestechnologygroupByIdTechnologyGroup;

    @Id
    @Column(name = "idTechnology")
    public Integer getIdTechnology() {
        return idTechnology;
    }

    public void setIdTechnology(Integer idTechnology) {
        this.idTechnology = idTechnology;
    }

    @Basic
    @Column(name = "number")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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
    @Column(name = "state")
    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mestechnology that = (Mestechnology) o;

        if (idTechnology != null ? !idTechnology.equals(that.idTechnology) : that.idTechnology != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTechnology != null ? idTechnology.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "mestechnologyByIdTechnology")
    public Collection<Mesattachmenttechnology> getMesattachmenttechnologiesByIdTechnology() {
        return mesattachmenttechnologiesByIdTechnology;
    }

    public void setMesattachmenttechnologiesByIdTechnology(Collection<Mesattachmenttechnology> mesattachmenttechnologiesByIdTechnology) {
        this.mesattachmenttechnologiesByIdTechnology = mesattachmenttechnologiesByIdTechnology;
    }

    @OneToMany(mappedBy = "mestechnologyByIdTechnology")
    public Collection<Mesoperation> getMesoperationsByIdTechnology() {
        return mesoperationsByIdTechnology;
    }

    public void setMesoperationsByIdTechnology(Collection<Mesoperation> mesoperationsByIdTechnology) {
        this.mesoperationsByIdTechnology = mesoperationsByIdTechnology;
    }

    @ManyToOne
    @JoinColumn(name = "idTechnologyGroup", referencedColumnName = "idTechnologyGroup", nullable = false)
    public Mestechnologygroup getMestechnologygroupByIdTechnologyGroup() {
        return mestechnologygroupByIdTechnologyGroup;
    }

    public void setMestechnologygroupByIdTechnologyGroup(Mestechnologygroup mestechnologygroupByIdTechnologyGroup) {
        this.mestechnologygroupByIdTechnologyGroup = mestechnologygroupByIdTechnologyGroup;
    }
}
