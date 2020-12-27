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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gustavo
 */
@Entity
@Table(name = "preferencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preferencia.findAll", query = "SELECT p FROM Preferencia p")
    , @NamedQuery(name = "Preferencia.findByIdPreferencia", query = "SELECT p FROM Preferencia p WHERE p.idPreferencia = :idPreferencia")})
public class Preferencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_preferencia")
    private Integer idPreferencia;
    @JoinColumn(name = "id_multimedia", referencedColumnName = "id_multimedia")
    @ManyToOne
    private Multimedia idMultimedia;
    @JoinColumn(name = "id_persona", referencedColumnName = "persona_id")
    @ManyToOne
    private Usuario idPersona;

    public Preferencia() {
    }

    public Preferencia(Integer idPreferencia) {
        this.idPreferencia = idPreferencia;
    }

    public Integer getIdPreferencia() {
        return idPreferencia;
    }

    public void setIdPreferencia(Integer idPreferencia) {
        this.idPreferencia = idPreferencia;
    }

    public Multimedia getIdMultimedia() {
        return idMultimedia;
    }

    public void setIdMultimedia(Multimedia idMultimedia) {
        this.idMultimedia = idMultimedia;
    }

    public Usuario getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Usuario idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPreferencia != null ? idPreferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preferencia)) {
            return false;
        }
        Preferencia other = (Preferencia) object;
        if ((this.idPreferencia == null && other.idPreferencia != null) || (this.idPreferencia != null && !this.idPreferencia.equals(other.idPreferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Preferencia[ idPreferencia=" + idPreferencia + " ]";
    }
    
}
