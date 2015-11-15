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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "sgc_dimension")
@NamedQueries({
    @NamedQuery(name = "SgcDimension.findAll", query = "SELECT s FROM SgcDimension s")})
public class SgcDimension implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_dimension")
    private Integer idDimension;
    @Basic(optional = false)
    @Column(name = "dimension")
    private String dimension;

    public SgcDimension() {
    }

    public SgcDimension(Integer idDimension) {
        this.idDimension = idDimension;
    }

    public SgcDimension(Integer idDimension, String dimension) {
        this.idDimension = idDimension;
        this.dimension = dimension;
    }

    public Integer getIdDimension() {
        return idDimension;
    }

    public void setIdDimension(Integer idDimension) {
        this.idDimension = idDimension;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDimension != null ? idDimension.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcDimension)) {
            return false;
        }
        SgcDimension other = (SgcDimension) object;
        if ((this.idDimension == null && other.idDimension != null) || (this.idDimension != null && !this.idDimension.equals(other.idDimension))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.dbwin.SgcDimension[ idDimension=" + idDimension + " ]";
    }
    
}
