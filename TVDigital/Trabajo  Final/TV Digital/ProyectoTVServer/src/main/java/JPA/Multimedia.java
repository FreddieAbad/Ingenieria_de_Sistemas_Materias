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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "multimedia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Multimedia.findAll", query = "SELECT m FROM Multimedia m")
    , @NamedQuery(name = "Multimedia.findByIdMultimedia", query = "SELECT m FROM Multimedia m WHERE m.idMultimedia = :idMultimedia")
    , @NamedQuery(name = "Multimedia.findByNombre", query = "SELECT m FROM Multimedia m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Multimedia.findByDuracion", query = "SELECT m FROM Multimedia m WHERE m.duracion = :duracion")})
public class Multimedia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_multimedia")
    private Integer idMultimedia;
    @Size(max = 250)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "duracion")
    private String duracion;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne
    private Categoria idCategoria;
    @JoinColumn(name = "id_mpaa", referencedColumnName = "id_mpaa")
    @ManyToOne
    private Mpaa idMpaa;
    @OneToMany(mappedBy = "idMultimedia")
    private Collection<Preferencia> preferenciaCollection;
    @OneToMany(mappedBy = "idMultimedia")
    private Collection<Ranking> rankingCollection;

    public Multimedia() {
    }

    public Multimedia(Integer idMultimedia) {
        this.idMultimedia = idMultimedia;
    }

    public Integer getIdMultimedia() {
        return idMultimedia;
    }

    public void setIdMultimedia(Integer idMultimedia) {
        this.idMultimedia = idMultimedia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Mpaa getIdMpaa() {
        return idMpaa;
    }

    public void setIdMpaa(Mpaa idMpaa) {
        this.idMpaa = idMpaa;
    }

    @XmlTransient
    public Collection<Preferencia> getPreferenciaCollection() {
        return preferenciaCollection;
    }

    public void setPreferenciaCollection(Collection<Preferencia> preferenciaCollection) {
        this.preferenciaCollection = preferenciaCollection;
    }

    @XmlTransient
    public Collection<Ranking> getRankingCollection() {
        return rankingCollection;
    }

    public void setRankingCollection(Collection<Ranking> rankingCollection) {
        this.rankingCollection = rankingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMultimedia != null ? idMultimedia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Multimedia)) {
            return false;
        }
        Multimedia other = (Multimedia) object;
        if ((this.idMultimedia == null && other.idMultimedia != null) || (this.idMultimedia != null && !this.idMultimedia.equals(other.idMultimedia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Multimedia[ idMultimedia=" + idMultimedia + " ]";
    }
    
}
