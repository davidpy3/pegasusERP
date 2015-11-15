/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

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
@Table(name = "Enivel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ENivel.findAll", query = "SELECT e FROM ENivel e"),
    @NamedQuery(name = "ENivel.findByIDnivel", query = "SELECT e FROM ENivel e WHERE e.iDnivel = :iDnivel"),
    @NamedQuery(name = "ENivel.findByNomNivel", query = "SELECT e FROM ENivel e WHERE e.nomNivel = :nomNivel")})
public class ENivel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ID_nivel")
    private String iDnivel;
    @Size(max = 10)
    @Column(name = "nom_nivel")
    private String nomNivel;

    public ENivel() {
    }

    public ENivel(String iDnivel) {
        this.iDnivel = iDnivel;
    }

    public String getIDnivel() {
        return iDnivel;
    }

    public void setIDnivel(String iDnivel) {
        this.iDnivel = iDnivel;
    }

    public String getNomNivel() {
        return nomNivel;
    }

    public void setNomNivel(String nomNivel) {
        this.nomNivel = nomNivel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDnivel != null ? iDnivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ENivel)) {
            return false;
        }
        ENivel other = (ENivel) object;
        if ((this.iDnivel == null && other.iDnivel != null) || (this.iDnivel != null && !this.iDnivel.equals(other.iDnivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.ENivel[ iDnivel=" + iDnivel + " ]";
    }
    
}
