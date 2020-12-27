/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gustavo
 */
@Entity
@Table(name = "mpaa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mpaa.findAll", query = "SELECT m FROM Mpaa m")
    , @NamedQuery(name = "Mpaa.findByIdMpaa", query = "SELECT m FROM Mpaa m WHERE m.idMpaa = :idMpaa")
    , @NamedQuery(name = "Mpaa.findByClasificacion", query = "SELECT m FROM Mpaa m WHERE m.clasificacion = :clasificacion")
    , @NamedQuery(name = "Mpaa.findByEdadMayor", query = "SELECT m FROM Mpaa m WHERE m.edadMayor = :edadMayor")
    , @NamedQuery(name = "Mpaa.findByDetalle", query = "SELECT m FROM Mpaa m WHERE m.detalle = :detalle")})
public class Mpaa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_mpaa")
    private Integer idMpaa;
    @Size(max = 10)
    @Column(name = "clasificacion")
    private String clasificacion;
    @Column(name = "edad_mayor")
    private Integer edadMayor;
    @Size(max = 150)
    @Column(name = "detalle")
    private String detalle;
    @OneToMany(mappedBy = "idMpaa")
    private Collection<Multimedia> multimediaCollection;

    public Mpaa() {
    }

    public Mpaa(Integer idMpaa) {
        this.idMpaa = idMpaa;
    }

    public Integer getIdMpaa() {
        return idMpaa;
    }

    public void setIdMpaa(Integer idMpaa) {
        this.idMpaa = idMpaa;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Integer getEdadMayor() {
        return edadMayor;
    }

    public void setEdadMayor(Integer edadMayor) {
        this.edadMayor = edadMayor;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @XmlTransient
    public Collection<Multimedia> getMultimediaCollection() {
        return multimediaCollection;
    }

    public void setMultimediaCollection(Collection<Multimedia> multimediaCollection) {
        this.multimediaCollection = multimediaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMpaa != null ? idMpaa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mpaa)) {
            return false;
        }
        Mpaa other = (Mpaa) object;
        if ((this.idMpaa == null && other.idMpaa != null) || (this.idMpaa != null && !this.idMpaa.equals(other.idMpaa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Mpaa[ idMpaa=" + idMpaa + " ]";
    }
    
}
