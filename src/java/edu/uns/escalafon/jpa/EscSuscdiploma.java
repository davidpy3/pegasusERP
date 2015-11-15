/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "esc_suscdiploma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscSuscdiploma.findAll", query = "SELECT e FROM EscSuscdiploma e"),
    @NamedQuery(name = "EscSuscdiploma.findById", query = "SELECT e FROM EscSuscdiploma e WHERE e.escSuscdiplomaPK.id = :id"),
    @NamedQuery(name = "EscSuscdiploma.findByCargoSus", query = "SELECT e FROM EscSuscdiploma e WHERE e.escSuscdiplomaPK.cargoSus = :cargoSus"),
    @NamedQuery(name = "EscSuscdiploma.findByNombreSus", query = "SELECT e FROM EscSuscdiploma e WHERE e.nombreSus = :nombreSus")})
public class EscSuscdiploma implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EscSuscdiplomaPK escSuscdiplomaPK;
    @Basic(optional = false)
    @Column(name = "nombre_sus")
    private String nombreSus;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EscEstudio escEstudio;

    public EscSuscdiploma() {
    }

    public EscSuscdiploma(EscSuscdiplomaPK escSuscdiplomaPK) {
        this.escSuscdiplomaPK = escSuscdiplomaPK;
    }

    public EscSuscdiploma(EscSuscdiplomaPK escSuscdiplomaPK, String nombreSus) {
        this.escSuscdiplomaPK = escSuscdiplomaPK;
        this.nombreSus = nombreSus;
    }

    public EscSuscdiploma(int id, String cargoSus) {
        this.escSuscdiplomaPK = new EscSuscdiplomaPK(id, cargoSus);
    }

    public EscSuscdiplomaPK getEscSuscdiplomaPK() {
        return escSuscdiplomaPK;
    }

    public void setEscSuscdiplomaPK(EscSuscdiplomaPK escSuscdiplomaPK) {
        this.escSuscdiplomaPK = escSuscdiplomaPK;
    }

    public String getNombreSus() {
        return nombreSus;
    }

    public void setNombreSus(String nombreSus) {
        this.nombreSus = nombreSus;
    }

    public EscEstudio getEscEstudio() {
        return escEstudio;
    }

    public void setEscEstudio(EscEstudio escEstudio) {
        this.escEstudio = escEstudio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (escSuscdiplomaPK != null ? escSuscdiplomaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscSuscdiploma)) {
            return false;
        }
        EscSuscdiploma other = (EscSuscdiploma) object;
        if ((this.escSuscdiplomaPK == null && other.escSuscdiplomaPK != null) || (this.escSuscdiplomaPK != null && !this.escSuscdiplomaPK.equals(other.escSuscdiplomaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscSuscdiploma[ escSuscdiplomaPK=" + escSuscdiplomaPK + " ]";
    }
    
}
