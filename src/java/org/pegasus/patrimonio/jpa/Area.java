/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "areas")
public class Area implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codarea")
    private String codarea;
    @Size(max = 3)
    @Column(name = "codlocal")
    private String codlocal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "area")
    private String area;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "siglas")
    private String siglas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "area")
    private Collection<Oficina> oficinaCollection;

    public Area() {
    }

    public Area(String codarea) {
        this.codarea = codarea;
    }

    public Area(String codarea, String area, String siglas) {
        this.codarea = codarea;
        this.area = area;
        this.siglas = siglas;
    }

    public String getCodarea() {
        return codarea;
    }

    public void setCodarea(String codarea) {
        this.codarea = codarea;
    }

    public String getCodlocal() {
        return codlocal;
    }

    public void setCodlocal(String codlocal) {
        this.codlocal = codlocal;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    @XmlTransient
    public Collection<Oficina> getOficinaCollection() {
        return oficinaCollection;
    }

    public void setOficinaCollection(Collection<Oficina> oficinaCollection) {
        this.oficinaCollection = oficinaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codarea != null ? codarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.codarea == null && other.codarea != null) || (this.codarea != null && !this.codarea.equals(other.codarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Area[ codarea=" + codarea + " ]";
    }
    
}
