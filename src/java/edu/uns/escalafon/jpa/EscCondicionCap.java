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
@Table(name = "esc_condicion_cap")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscCondicionCap.findAll", query = "SELECT e FROM EscCondicionCap e"),
    @NamedQuery(name = "EscCondicionCap.findByIdCc", query = "SELECT e FROM EscCondicionCap e WHERE e.idCc = :idCc"),
    @NamedQuery(name = "EscCondicionCap.findByCondicion", query = "SELECT e FROM EscCondicionCap e WHERE e.condicion = :condicion")})
public class EscCondicionCap implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_cc")
    private Short idCc;
    @Basic(optional = false)
    @Column(name = "condicion")
    private String condicion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCc")
    private List<EscCapacitacion> escCapacitacionList;

    public EscCondicionCap() {
    }

    public EscCondicionCap(Short idCc) {
        this.idCc = idCc;
    }

    public EscCondicionCap(Short idCc, String condicion) {
        this.idCc = idCc;
        this.condicion = condicion;
    }

    public Short getIdCc() {
        return idCc;
    }

    public void setIdCc(Short idCc) {
        this.idCc = idCc;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    @XmlTransient
    public List<EscCapacitacion> getEscCapacitacionList() {
        return escCapacitacionList;
    }

    public void setEscCapacitacionList(List<EscCapacitacion> escCapacitacionList) {
        this.escCapacitacionList = escCapacitacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCc != null ? idCc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscCondicionCap)) {
            return false;
        }
        EscCondicionCap other = (EscCondicionCap) object;
        if ((this.idCc == null && other.idCc != null) || (this.idCc != null && !this.idCc.equals(other.idCc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscCondicionCap[ idCc=" + idCc + " ]";
    }
    
}
