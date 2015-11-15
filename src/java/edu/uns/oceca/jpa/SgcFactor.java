/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "sgc_factor")
public class SgcFactor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_factor")
    private Integer idFactor;
    @Basic(optional = false)
    @Column(name = "id_dimension")
    private int idDimension;
    @Basic(optional = false)
    @Column(name = "factor")
    private String factor;
    @Basic(optional = false)
//    @Lob
    @Column(name = "descripcion")
    private String descripcion;

    public SgcFactor() {
    }

    public SgcFactor(Integer idFactor) {
        this.idFactor = idFactor;
    }

    public SgcFactor(Integer idFactor, int idDimension, String factor, String descripcion) {
        this.idFactor = idFactor;
        this.idDimension = idDimension;
        this.factor = factor;
        this.descripcion = descripcion;
    }

    public Integer getIdFactor() {
        return idFactor;
    }

    public void setIdFactor(Integer idFactor) {
        this.idFactor = idFactor;
    }

    public int getIdDimension() {
        return idDimension;
    }

    public void setIdDimension(int idDimension) {
        this.idDimension = idDimension;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactor != null ? idFactor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcFactor)) {
            return false;
        }
        SgcFactor other = (SgcFactor) object;
        if ((this.idFactor == null && other.idFactor != null) || (this.idFactor != null && !this.idFactor.equals(other.idFactor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.jpa.SgcFactor[ idFactor=" + idFactor + " ]";
    }
    
}
