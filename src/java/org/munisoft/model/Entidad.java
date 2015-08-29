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
@Table(name = "entidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entidad.findAll", query = "SELECT e FROM Entidad e"),
    @NamedQuery(name = "Entidad.findByCodinst", query = "SELECT e FROM Entidad e WHERE e.codinst = :codinst"),
    @NamedQuery(name = "Entidad.findByEntidad", query = "SELECT e FROM Entidad e WHERE e.entidad = :entidad"),
    @NamedQuery(name = "Entidad.findBySiglas", query = "SELECT e FROM Entidad e WHERE e.siglas = :siglas")})
public class Entidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codinst")
    private String codinst;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "entidad")
    private String entidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "siglas")
    private String siglas;

    public Entidad() {
    }

    public Entidad(String codinst) {
        this.codinst = codinst;
    }

    public Entidad(String codinst, String entidad, String siglas) {
        this.codinst = codinst;
        this.entidad = entidad;
        this.siglas = siglas;
    }

    public String getCodinst() {
        return codinst;
    }

    public void setCodinst(String codinst) {
        this.codinst = codinst;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codinst != null ? codinst.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entidad)) {
            return false;
        }
        Entidad other = (Entidad) object;
        if ((this.codinst == null && other.codinst != null) || (this.codinst != null && !this.codinst.equals(other.codinst))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Entidad[ codinst=" + codinst + " ]";
    }
    
}
