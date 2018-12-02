package pl.test.model;

import javax.persistence.*;

@Entity
public class Mesattachmentoperation {
    private Integer idAttachmentOperation;
    private String name;
    private String link;
    private Mesoperation mesoperationByIdOperation;

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "idAttachmentOperation")
    public Integer getIdAttachmentOperation() {
        return idAttachmentOperation;
    }

    public void setIdAttachmentOperation(Integer idAttachmentOperation) {
        this.idAttachmentOperation = idAttachmentOperation;
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
    @Column(name = "link")
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mesattachmentoperation that = (Mesattachmentoperation) o;

        if (idAttachmentOperation != null ? !idAttachmentOperation.equals(that.idAttachmentOperation) : that.idAttachmentOperation != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (link != null ? !link.equals(that.link) : that.link != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAttachmentOperation != null ? idAttachmentOperation.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        return result;
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
