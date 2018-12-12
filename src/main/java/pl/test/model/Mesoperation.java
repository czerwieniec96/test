package pl.test.model;

import javax.persistence.*;

@Entity
public class Mesoperation {
    private Integer idOperation;
    private String name;
    private String description;
    private Integer number;
    private Mestechnology mestechnologyByIdTechnology;
    private Mesoperationdictionary mesoperationdictionaryByIdOperationdictionary;

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "idOperation")
    public Integer getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(Integer idOperation) {
        this.idOperation = idOperation;
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

    @Basic
    @Column(name = "number")
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

        Mesoperation that = (Mesoperation) o;

        if (idOperation != null ? !idOperation.equals(that.idOperation) : that.idOperation != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOperation != null ? idOperation.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idTechnology", referencedColumnName = "idTechnology", nullable = false)
    public Mestechnology getMestechnologyByIdTechnology() {
        return mestechnologyByIdTechnology;
    }

    public void setMestechnologyByIdTechnology(Mestechnology mestechnologyByIdTechnology) {
        this.mestechnologyByIdTechnology = mestechnologyByIdTechnology;
    }

    @ManyToOne
    @JoinColumn(name = "idOperationdictionary", referencedColumnName = "idOperationDictionary", nullable = false)
    public Mesoperationdictionary getMesoperationdictionaryByIdOperationdictionary() {
        return mesoperationdictionaryByIdOperationdictionary;
    }

    public void setMesoperationdictionaryByIdOperationdictionary(Mesoperationdictionary mesoperationdictionaryByIdOperationdictionary) {
        this.mesoperationdictionaryByIdOperationdictionary = mesoperationdictionaryByIdOperationdictionary;
    }

    private Mesoperationstate idOperationstate;

    @ManyToOne
    @JoinColumn(name = "idOperationstate", referencedColumnName = "idOperationstate", nullable = false)

    public Mesoperationstate getIdOperationstate() {
        return idOperationstate;
    }

    public void setIdOperationstate(Mesoperationstate idOperationstate) {
        this.idOperationstate = idOperationstate;
    }
}
