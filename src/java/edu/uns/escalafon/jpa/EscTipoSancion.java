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
@Table(name = "esc_tipo_sancion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscTipoSancion.findAll", query = "SELECT e FROM EscTipoSancion e"),
    @NamedQuery(name = "EscTipoSancion.findByIdTs", query = "SELECT e FROM EscTipoSancion e WHERE e.idTs = :idTs"),
    @NamedQuery(name = "EscTipoSancion.findBySancion", query = "SELECT e FROM EscTipoSancion e WHERE e.sancion = :sancion")})
public class EscTipoSancion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_ts")
    private Short idTs;
    @Basic(optional = false)
    @Column(name = "sancion")
    private String sancion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTs")
    private List<EscDemeritos> escDemeritosList;

    public EscTipoSancion() {
    }

    public EscTipoSancion(Short idTs) {
        this.idTs = idTs;
    }

    public EscTipoSancion(Short idTs, String sancion) {
        this.idTs = idTs;
        this.sancion = sancion;
    }

    public Short getIdTs() {
        return idTs;
    }

    public void setIdTs(Short idTs) {
        this.idTs = idTs;
    }

    public String getSancion() {
        return sancion;
    }

    public void setSancion(String sancion) {
        this.sancion = sancion;
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
        hash += (idTs != null ? idTs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscTipoSancion)) {
            return false;
        }
        EscTipoSancion other = (EscTipoSancion) object;
        if ((this.idTs == null && other.idTs != null) || (this.idTs != null && !this.idTs.equals(other.idTs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscTipoSancion[ idTs=" + idTs + " ]";
    }
    
}
