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
@Table(name = "esc_tipo_promocion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscTipoPromocion.findAll", query = "SELECT e FROM EscTipoPromocion e"),
    @NamedQuery(name = "EscTipoPromocion.findByIdTp", query = "SELECT e FROM EscTipoPromocion e WHERE e.idTp = :idTp"),
    @NamedQuery(name = "EscTipoPromocion.findByTipoPromocion", query = "SELECT e FROM EscTipoPromocion e WHERE e.tipoPromocion = :tipoPromocion")})
public class EscTipoPromocion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tp")
    private Short idTp;
    @Basic(optional = false)
    @Column(name = "tipo_promocion")
    private String tipoPromocion;
    @OneToMany(mappedBy = "idTp")
    private List<EscCarreraLaboral> escCarreraLaboralList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTp")
    private List<EscPromociones> escPromocionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTp")
    private List<EscPromocionesDoc> escPromocionesDocList;

    public EscTipoPromocion() {
    }

    public EscTipoPromocion(Short idTp) {
        this.idTp = idTp;
    }

    public EscTipoPromocion(Short idTp, String tipoPromocion) {
        this.idTp = idTp;
        this.tipoPromocion = tipoPromocion;
    }

    public Short getIdTp() {
        return idTp;
    }

    public void setIdTp(Short idTp) {
        this.idTp = idTp;
    }

    public String getTipoPromocion() {
        return tipoPromocion;
    }

    public void setTipoPromocion(String tipoPromocion) {
        this.tipoPromocion = tipoPromocion;
    }

    @XmlTransient
    public List<EscCarreraLaboral> getEscCarreraLaboralList() {
        return escCarreraLaboralList;
    }

    public void setEscCarreraLaboralList(List<EscCarreraLaboral> escCarreraLaboralList) {
        this.escCarreraLaboralList = escCarreraLaboralList;
    }

    @XmlTransient
    public List<EscPromociones> getEscPromocionesList() {
        return escPromocionesList;
    }

    public void setEscPromocionesList(List<EscPromociones> escPromocionesList) {
        this.escPromocionesList = escPromocionesList;
    }

    @XmlTransient
    public List<EscPromocionesDoc> getEscPromocionesDocList() {
        return escPromocionesDocList;
    }

    public void setEscPromocionesDocList(List<EscPromocionesDoc> escPromocionesDocList) {
        this.escPromocionesDocList = escPromocionesDocList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTp != null ? idTp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscTipoPromocion)) {
            return false;
        }
        EscTipoPromocion other = (EscTipoPromocion) object;
        if ((this.idTp == null && other.idTp != null) || (this.idTp != null && !this.idTp.equals(other.idTp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscTipoPromocion[ idTp=" + idTp + " ]";
    }
    
}
