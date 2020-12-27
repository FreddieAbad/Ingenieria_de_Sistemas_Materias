/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gustavo
 */
@Entity
@Table(name = "loggin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loggin.findAll", query = "SELECT l FROM Loggin l")
    , @NamedQuery(name = "Loggin.findByUserId", query = "SELECT l FROM Loggin l WHERE l.userId = :userId")
    , @NamedQuery(name = "Loggin.findByUser", query = "SELECT l FROM Loggin l WHERE l.user = :user")
    , @NamedQuery(name = "Loggin.findByPassword", query = "SELECT l FROM Loggin l WHERE l.password = :password")})
public class Loggin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "user_id")
    private String userId;
    @Size(max = 150)
    @Column(name = "user")
    private String user;
    @Size(max = 150)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "user_id", referencedColumnName = "persona_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public Loggin() {
    }

    public Loggin(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loggin)) {
            return false;
        }
        Loggin other = (Loggin) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Loggin[ userId=" + userId + " ]";
    }
    
}
