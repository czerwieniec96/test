package pl.test.model;

import javax.persistence.*;

@Entity
public class Mesoperationstate {
    private Integer idOperationState;
    private String state;
    private String description;

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "idOperationState")
    public Integer getIdOperationState() {
        return idOperationState;
    }

    public void setIdOperationState(Integer idOperationState) {
        this.idOperationState = idOperationState;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

        Mesoperationstate that = (Mesoperationstate) o;

        if (idOperationState != null ? !idOperationState.equals(that.idOperationState) : that.idOperationState != null)
            return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOperationState != null ? idOperationState.hashCode() : 0;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
