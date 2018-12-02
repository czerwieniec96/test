package pl.test.model;

import javax.persistence.*;

@Entity
public class Mesattachmenttechnology {
    private Integer idAttachmentTechnology;
    private String name;
    private String link;
    private Mestechnology mestechnologyByIdTechnology;

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "idAttachmentTechnology")
    public Integer getIdAttachmentTechnology() {
        return idAttachmentTechnology;
    }

    public void setIdAttachmentTechnology(Integer idAttachmentTechnology) {
        this.idAttachmentTechnology = idAttachmentTechnology;
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

        Mesattachmenttechnology that = (Mesattachmenttechnology) o;

        if (idAttachmentTechnology != null ? !idAttachmentTechnology.equals(that.idAttachmentTechnology) : that.idAttachmentTechnology != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (link != null ? !link.equals(that.link) : that.link != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAttachmentTechnology != null ? idAttachmentTechnology.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
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
}
