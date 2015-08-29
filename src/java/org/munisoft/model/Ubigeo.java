/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

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
@Table(name = "ubigeo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ubigeo.findAll", query = "SELECT u FROM Ubigeo u"),
    @NamedQuery(name = "Ubigeo.findByCodubigeo", query = "SELECT u FROM Ubigeo u WHERE u.codubigeo = :codubigeo"),
    @NamedQuery(name = "Ubigeo.findByCoddpto", query = "SELECT u FROM Ubigeo u WHERE u.coddpto = :coddpto"),
    @NamedQuery(name = "Ubigeo.findByCodprov", query = "SELECT u FROM Ubigeo u WHERE u.codprov = :codprov"),
    @NamedQuery(name = "Ubigeo.findByCoddist", query = "SELECT u FROM Ubigeo u WHERE u.coddist = :coddist"),
    @NamedQuery(name = "Ubigeo.findByNmbubigeo", query = "SELECT u FROM Ubigeo u WHERE u.nmbubigeo = :nmbubigeo")})
public class Ubigeo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "codubigeo")
    private String codubigeo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "coddpto")
    private String coddpto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "codprov")
    private String codprov;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "coddist")
    private String coddist;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nmbubigeo")
    private String nmbubigeo;
    @OneToMany(mappedBy = "codubigeo")
    private Collection<Locales> localesCollection;

    public Ubigeo() {
    }

    public Ubigeo(String codubigeo) {
        this.codubigeo = codubigeo;
    }

    public Ubigeo(String codubigeo, String coddpto, String codprov, String coddist, String nmbubigeo) {
        this.codubigeo = codubigeo;
        this.coddpto = coddpto;
        this.codprov = codprov;
        this.coddist = coddist;
        this.nmbubigeo = nmbubigeo;
    }

    public String getCodubigeo() {
        return codubigeo;
    }

    public void setCodubigeo(String codubigeo) {
        this.codubigeo = codubigeo;
    }

    public String getCoddpto() {
        return coddpto;
    }

    public void setCoddpto(String coddpto) {
        this.coddpto = coddpto;
    }

    public String getCodprov() {
        return codprov;
    }

    public void setCodprov(String codprov) {
        this.codprov = codprov;
    }

    public String getCoddist() {
        return coddist;
    }

    public void setCoddist(String coddist) {
        this.coddist = coddist;
    }

    public String getNmbubigeo() {
        return nmbubigeo;
    }

    public void setNmbubigeo(String nmbubigeo) {
        this.nmbubigeo = nmbubigeo;
    }

    @XmlTransient
    public Collection<Locales> getLocalesCollection() {
        return localesCollection;
    }

    public void setLocalesCollection(Collection<Locales> localesCollection) {
        this.localesCollection = localesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codubigeo != null ? codubigeo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubigeo)) {
            return false;
        }
        Ubigeo other = (Ubigeo) object;
        if ((this.codubigeo == null && other.codubigeo != null) || (this.codubigeo != null && !this.codubigeo.equals(other.codubigeo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Ubigeo[ codubigeo=" + codubigeo + " ]";
    }
    
}
