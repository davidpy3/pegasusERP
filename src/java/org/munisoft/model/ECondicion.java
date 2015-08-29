/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "Econdicion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ECondicion.findAll", query = "SELECT e FROM ECondicion e"),
    @NamedQuery(name = "ECondicion.findByIDcondicion", query = "SELECT e FROM ECondicion e WHERE e.iDcondicion = :iDcondicion"),
    @NamedQuery(name = "ECondicion.findByNomCondicion", query = "SELECT e FROM ECondicion e WHERE e.nomCondicion = :nomCondicion")})
public class ECondicion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_condicion")
    private Integer iDcondicion;
    @Size(max = 70)
    @Column(name = "nom_condicion")
    private String nomCondicion;

    public ECondicion() {
    }

    public ECondicion(Integer iDcondicion) {
        this.iDcondicion = iDcondicion;
    }

    public Integer getIDcondicion() {
        return iDcondicion;
    }

    public void setIDcondicion(Integer iDcondicion) {
        this.iDcondicion = iDcondicion;
    }

    public String getNomCondicion() {
        return nomCondicion;
    }

    public void setNomCondicion(String nomCondicion) {
        this.nomCondicion = nomCondicion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDcondicion != null ? iDcondicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ECondicion)) {
            return false;
        }
        ECondicion other = (ECondicion) object;
        if ((this.iDcondicion == null && other.iDcondicion != null) || (this.iDcondicion != null && !this.iDcondicion.equals(other.iDcondicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.ECondicion[ iDcondicion=" + iDcondicion + " ]";
    }
    
}
