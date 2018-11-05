package pl.test.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name="mesusers")

public class Mesusers {
    private Integer idUsers;
    private String name;
    private String password;

    @Id
    @Column(name = "idUsers")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Integer idUsers) {
        this.idUsers = idUsers;
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
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mesusers mesusers = (Mesusers) o;

        if (idUsers != null ? !idUsers.equals(mesusers.idUsers) : mesusers.idUsers != null) return false;
        if (name != null ? !name.equals(mesusers.name) : mesusers.name != null) return false;
        if (password != null ? !password.equals(mesusers.password) : mesusers.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUsers != null ? idUsers.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
