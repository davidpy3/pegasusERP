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
@Table(name = "esc_tipo_cap")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscTipoCap.findAll", query = "SELECT e FROM EscTipoCap e"),
    @NamedQuery(name = "EscTipoCap.findByIdTc", query = "SELECT e FROM EscTipoCap e WHERE e.idTc = :idTc"),
    @NamedQuery(name = "EscTipoCap.findByTipos", query = "SELECT e FROM EscTipoCap e WHERE e.tipos = :tipos")})
public class EscTipoCap implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tc")
    private Short idTc;
    @Basic(optional = false)
    @Column(name = "tipos")
    private String tipos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTc")
    private List<EscCapacitacion> escCapacitacionList;

    public EscTipoCap() {
    }

    public EscTipoCap(Short idTc) {
        this.idTc = idTc;
    }

    public EscTipoCap(Short idTc, String tipos) {
        this.idTc = idTc;
        this.tipos = tipos;
    }

    public Short getIdTc() {
        return idTc;
    }

    public void setIdTc(Short idTc) {
        this.idTc = idTc;
    }

    public String getTipos() {
        return tipos;
    }

    public void setTipos(String tipos) {
        this.tipos = tipos;
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
        hash += (idTc != null ? idTc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscTipoCap)) {
            return false;
        }
        EscTipoCap other = (EscTipoCap) object;
        if ((this.idTc == null && other.idTc != null) || (this.idTc != null && !this.idTc.equals(other.idTc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscTipoCap[ idTc=" + idTc + " ]";
    }
    
}
