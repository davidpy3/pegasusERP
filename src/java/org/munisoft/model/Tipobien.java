/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "tipobien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipobien.findAll", query = "SELECT t FROM Tipobien t"),
    @NamedQuery(name = "Tipobien.findByCodbien", query = "SELECT t FROM Tipobien t WHERE t.codbien = :codbien"),
    @NamedQuery(name = "Tipobien.findByDescripcio", query = "SELECT t FROM Tipobien t WHERE t.descripcio = :descripcio"),
    @NamedQuery(name = "Tipobien.findByCorrela", query = "SELECT t FROM Tipobien t WHERE t.correla = :correla"),
    @NamedQuery(name = "Tipobien.findByTipo", query = "SELECT t FROM Tipobien t WHERE t.tipo = :tipo")})
public class Tipobien implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipobien")
    private Collection<MBienes0> mBienes0Collection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "codbien")
    private String codbien;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "descripcio")
    private String descripcio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "correla")
    private int correla;
    @Column(name = "tipo")
    private Character tipo;
    
    public Tipobien() {
    }

    public Tipobien(String codbien) {
        this.codbien = codbien;
    }

    public Tipobien(String codbien, String descripcio, int correla) {
        this.codbien = codbien;
        this.descripcio = descripcio;
        this.correla = correla;
    }

    public String getCodbien() {
        return codbien;
    }

    public void setCodbien(String codbien) {
        this.codbien = codbien;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public int getCorrela() {
        return correla;
    }

    public void setCorrela(int correla) {
        this.correla = correla;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<MBienes0> getMbienes0Collection() {
        return mBienes0Collection;
    }

    public void setMbienes0Collection(Collection<MBienes0> mBienes0Collection) {
        this.mBienes0Collection = mBienes0Collection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codbien != null ? codbien.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipobien)) {
            return false;
        }
        Tipobien other = (Tipobien) object;
        if ((this.codbien == null && other.codbien != null) || (this.codbien != null && !this.codbien.equals(other.codbien))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Tipobien[ codbien=" + codbien + " ]";
    }

    @XmlTransient
    public Collection<MBienes0> getMBienes0Collection() {
        return mBienes0Collection;
    }

    public void setMBienes0Collection(Collection<MBienes0> mBienes0Collection) {
        this.mBienes0Collection = mBienes0Collection;
    }
    
}
