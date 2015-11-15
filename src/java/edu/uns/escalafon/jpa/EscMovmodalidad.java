/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "esc_movmodalidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscMovmodalidad.findAll", query = "SELECT e FROM EscMovmodalidad e"),
    @NamedQuery(name = "EscMovmodalidad.findByIdMovmod", query = "SELECT e FROM EscMovmodalidad e WHERE e.idMovmod = :idMovmod"),
    @NamedQuery(name = "EscMovmodalidad.findByModalidad", query = "SELECT e FROM EscMovmodalidad e WHERE e.modalidad = :modalidad"),
    @NamedQuery(name = "EscMovmodalidad.findByAbrev", query = "SELECT e FROM EscMovmodalidad e WHERE e.abrev = :abrev")})
public class EscMovmodalidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_movmod")
    private Short idMovmod;
    @Basic(optional = false)
    @Column(name = "modalidad")
    private String modalidad;
    @Basic(optional = false)
    @Column(name = "abrev")
    private String abrev;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMovmod")
    private List<EscCarreraLaboral> escCarreraLaboralList;

    public EscMovmodalidad() {
    }

    public EscMovmodalidad(Short idMovmod) {
        this.idMovmod = idMovmod;
    }

    public EscMovmodalidad(Short idMovmod, String modalidad, String abrev) {
        this.idMovmod = idMovmod;
        this.modalidad = modalidad;
        this.abrev = abrev;
    }

    public Short getIdMovmod() {
        return idMovmod;
    }

    public void setIdMovmod(Short idMovmod) {
        this.idMovmod = idMovmod;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    @XmlTransient
    public List<EscCarreraLaboral> getEscCarreraLaboralList() {
        return escCarreraLaboralList;
    }

    public void setEscCarreraLaboralList(List<EscCarreraLaboral> escCarreraLaboralList) {
        this.escCarreraLaboralList = escCarreraLaboralList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovmod != null ? idMovmod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscMovmodalidad)) {
            return false;
        }
        EscMovmodalidad other = (EscMovmodalidad) object;
        if ((this.idMovmod == null && other.idMovmod != null) || (this.idMovmod != null && !this.idMovmod.equals(other.idMovmod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscMovmodalidad[ idMovmod=" + idMovmod + " ]";
    }
    
}
