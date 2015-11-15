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
@Table(name = "Eoficina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EOficina.findAll", query = "SELECT e FROM EOficina e"),
    @NamedQuery(name = "EOficina.findByIDoficina", query = "SELECT e FROM EOficina e WHERE e.iDoficina = :iDoficina"),
    @NamedQuery(name = "EOficina.findByNomOficna", query = "SELECT e FROM EOficina e WHERE e.nomOficna = :nomOficna")})
public class EOficina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ID_oficina")
    private String iDoficina;
    @Size(max = 70)
    @Column(name = "nom_oficna")
    private String nomOficna;

    public EOficina() {
    }

    public EOficina(String iDoficina) {
        this.iDoficina = iDoficina;
    }

    public String getIDoficina() {
        return iDoficina;
    }

    public void setIDoficina(String iDoficina) {
        this.iDoficina = iDoficina;
    }

    public String getNomOficna() {
        return nomOficna;
    }

    public void setNomOficna(String nomOficna) {
        this.nomOficna = nomOficna;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDoficina != null ? iDoficina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EOficina)) {
            return false;
        }
        EOficina other = (EOficina) object;
        if ((this.iDoficina == null && other.iDoficina != null) || (this.iDoficina != null && !this.iDoficina.equals(other.iDoficina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.EOficina[ iDoficina=" + iDoficina + " ]";
    }
    
}
