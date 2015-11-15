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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "clases")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clase.findAll", query = "SELECT c FROM Clase c"),
    @NamedQuery(name = "Clase.findByClase", query = "SELECT c FROM Clase c WHERE c.clase = :clase"),
    @NamedQuery(name = "Clase.findByDscclase", query = "SELECT c FROM Clase c WHERE c.dscclase = :dscclase")})
public class Clase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "clase")
    private String clase;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "dscclase")
    private String dscclase;
    @JoinTable(name = "grupos_clases", joinColumns = {
        @JoinColumn(name = "clase", referencedColumnName = "clase")}, inverseJoinColumns = {
        @JoinColumn(name = "grupo", referencedColumnName = "grupo")})
    @ManyToMany
    private Collection<Grupo> grupoCollection;

    public Clase() {
    }

    public Clase(String clase) {
        this.clase = clase;
    }

    public Clase(String clase, String dscclase) {
        this.clase = clase;
        this.dscclase = dscclase;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getDscclase() {
        return dscclase;
    }

    public void setDscclase(String dscclase) {
        this.dscclase = dscclase;
    }

    @XmlTransient
    public Collection<Grupo> getGrupoCollection() {
        return grupoCollection;
    }

    public void setGrupoCollection(Collection<Grupo> grupoCollection) {
        this.grupoCollection = grupoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clase != null ? clase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clase)) {
            return false;
        }
        Clase other = (Clase) object;
        if ((this.clase == null && other.clase != null) || (this.clase != null && !this.clase.equals(other.clase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Clase[ clase=" + clase + " ]";
    }
    
}
