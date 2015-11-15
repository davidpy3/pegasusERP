/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "Tipovia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoVia.findAll", query = "SELECT t FROM TipoVia t"),
    @NamedQuery(name = "TipoVia.findByTipovia", query = "SELECT t FROM TipoVia t WHERE t.tipovia = :tipovia"),
    @NamedQuery(name = "TipoVia.findByNombreVia", query = "SELECT t FROM TipoVia t WHERE t.nombreVia = :nombreVia"),
    @NamedQuery(name = "TipoVia.findByAbrev", query = "SELECT t FROM TipoVia t WHERE t.abrev = :abrev")})
public class TipoVia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "tipovia")
    private String tipovia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_via")
    private String nombreVia;
    @Size(max = 20)
    @Column(name = "abrev")
    private String abrev;
    @OneToMany(mappedBy = "tipovia")
    private Collection<ELocal> localesCollection;

    public TipoVia() {
    }

    public TipoVia(String tipovia) {
        this.tipovia = tipovia;
    }

    public TipoVia(String tipovia, String nombreVia) {
        this.tipovia = tipovia;
        this.nombreVia = nombreVia;
    }

    public String getTipovia() {
        return tipovia;
    }

    public void setTipovia(String tipovia) {
        this.tipovia = tipovia;
    }

    public String getNombreVia() {
        return nombreVia;
    }

    public void setNombreVia(String nombreVia) {
        this.nombreVia = nombreVia;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    @XmlTransient
    public Collection<ELocal> getLocalesCollection() {
        return localesCollection;
    }

    public void setLocalesCollection(Collection<ELocal> localesCollection) {
        this.localesCollection = localesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipovia != null ? tipovia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoVia)) {
            return false;
        }
        TipoVia other = (TipoVia) object;
        if ((this.tipovia == null && other.tipovia != null) || (this.tipovia != null && !this.tipovia.equals(other.tipovia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.TipoVia[ tipovia=" + tipovia + " ]";
    }
    
}
