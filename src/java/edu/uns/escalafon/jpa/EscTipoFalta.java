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
@Table(name = "esc_tipo_falta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscTipoFalta.findAll", query = "SELECT e FROM EscTipoFalta e"),
    @NamedQuery(name = "EscTipoFalta.findByIdTf", query = "SELECT e FROM EscTipoFalta e WHERE e.idTf = :idTf"),
    @NamedQuery(name = "EscTipoFalta.findByFalta", query = "SELECT e FROM EscTipoFalta e WHERE e.falta = :falta")})
public class EscTipoFalta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tf")
    private Short idTf;
    @Basic(optional = false)
    @Column(name = "falta")
    private String falta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTf")
    private List<EscDemeritos> escDemeritosList;

    public EscTipoFalta() {
    }

    public EscTipoFalta(Short idTf) {
        this.idTf = idTf;
    }

    public EscTipoFalta(Short idTf, String falta) {
        this.idTf = idTf;
        this.falta = falta;
    }

    public Short getIdTf() {
        return idTf;
    }

    public void setIdTf(Short idTf) {
        this.idTf = idTf;
    }

    public String getFalta() {
        return falta;
    }

    public void setFalta(String falta) {
        this.falta = falta;
    }

    @XmlTransient
    public List<EscDemeritos> getEscDemeritosList() {
        return escDemeritosList;
    }

    public void setEscDemeritosList(List<EscDemeritos> escDemeritosList) {
        this.escDemeritosList = escDemeritosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTf != null ? idTf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscTipoFalta)) {
            return false;
        }
        EscTipoFalta other = (EscTipoFalta) object;
        if ((this.idTf == null && other.idTf != null) || (this.idTf != null && !this.idTf.equals(other.idTf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscTipoFalta[ idTf=" + idTf + " ]";
    }
    
}
