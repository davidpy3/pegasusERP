/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "esc_tip_c")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscTipC.findAll", query = "SELECT e FROM EscTipC e"),
    @NamedQuery(name = "EscTipC.findByIdTc", query = "SELECT e FROM EscTipC e WHERE e.idTc = :idTc"),
    @NamedQuery(name = "EscTipC.findByTipoCargo", query = "SELECT e FROM EscTipC e WHERE e.tipoCargo = :tipoCargo")})
public class EscTipC implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tc")
    private Short idTc;
    @Basic(optional = false)
    @Column(name = "tipo_cargo")
    private String tipoCargo;
    @OneToMany(mappedBy = "idTc")
    private List<EscCargoInstitucional> escCargoInstitucionalList;

    public EscTipC() {
    }

    public EscTipC(Short idTc) {
        this.idTc = idTc;
    }

    public EscTipC(Short idTc, String tipoCargo) {
        this.idTc = idTc;
        this.tipoCargo = tipoCargo;
    }

    public Short getIdTc() {
        return idTc;
    }

    public void setIdTc(Short idTc) {
        this.idTc = idTc;
    }

    public String getTipoCargo() {
        return tipoCargo;
    }

    public void setTipoCargo(String tipoCargo) {
        this.tipoCargo = tipoCargo;
    }

    @XmlTransient
    public List<EscCargoInstitucional> getEscCargoInstitucionalList() {
        return escCargoInstitucionalList;
    }

    public void setEscCargoInstitucionalList(List<EscCargoInstitucional> escCargoInstitucionalList) {
        this.escCargoInstitucionalList = escCargoInstitucionalList;
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
        if (!(object instanceof EscTipC)) {
            return false;
        }
        EscTipC other = (EscTipC) object;
        if ((this.idTc == null && other.idTc != null) || (this.idTc != null && !this.idTc.equals(other.idTc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscTipC[ idTc=" + idTc + " ]";
    }
    
}
