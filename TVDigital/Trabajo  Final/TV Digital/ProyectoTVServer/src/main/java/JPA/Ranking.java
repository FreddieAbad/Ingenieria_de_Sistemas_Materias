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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gustavo
 */
@Entity
@Table(name = "ranking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ranking.findAll", query = "SELECT r FROM Ranking r")
    , @NamedQuery(name = "Ranking.findByIdRanking", query = "SELECT r FROM Ranking r WHERE r.idRanking = :idRanking")
    , @NamedQuery(name = "Ranking.findByNota", query = "SELECT r FROM Ranking r WHERE r.nota = :nota")
    , @NamedQuery(name = "Ranking.findByPorcentaje", query = "SELECT r FROM Ranking r WHERE r.porcentaje = :porcentaje")})
public class Ranking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ranking")
    private Integer idRanking;
    @Column(name = "nota")
    private Integer nota;
    @Size(max = 5)
    @Column(name = "porcentaje")
    private String porcentaje;
    @JoinColumn(name = "id_multimedia", referencedColumnName = "id_multimedia")
    @ManyToOne
    private Multimedia idMultimedia;
    @JoinColumn(name = "id_persona", referencedColumnName = "persona_id")
    @ManyToOne
    private Usuario idPersona;

    public Ranking() {
    }

    public Ranking(Integer idRanking) {
        this.idRanking = idRanking;
    }

    public Integer getIdRanking() {
        return idRanking;
    }

    public void setIdRanking(Integer idRanking) {
        this.idRanking = idRanking;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
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
        hash += (idRanking != null ? idRanking.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ranking)) {
            return false;
        }
        Ranking other = (Ranking) object;
        if ((this.idRanking == null && other.idRanking != null) || (this.idRanking != null && !this.idRanking.equals(other.idRanking))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Ranking[ idRanking=" + idRanking + " ]";
    }
    
}
