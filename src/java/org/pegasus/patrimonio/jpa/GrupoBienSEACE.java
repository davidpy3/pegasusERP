/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "Grupo_bien_SEACE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoBienSEACE.findAll", query = "SELECT g FROM GrupoBienSEACE g"),
    @NamedQuery(name = "GrupoBienSEACE.findByTipoBien", query = "SELECT g FROM GrupoBienSEACE g WHERE g.grupoBienSEACEPK.tipoBien = :tipoBien"),
    @NamedQuery(name = "GrupoBienSEACE.findByGrupoBien", query = "SELECT g FROM GrupoBienSEACE g WHERE g.grupoBienSEACEPK.grupoBien = :grupoBien"),
    @NamedQuery(name = "GrupoBienSEACE.findByNombreGru", query = "SELECT g FROM GrupoBienSEACE g WHERE g.nombreGru = :nombreGru"),
    @NamedQuery(name = "GrupoBienSEACE.findByAlcanceGru", query = "SELECT g FROM GrupoBienSEACE g WHERE g.alcanceGru = :alcanceGru"),
    @NamedQuery(name = "GrupoBienSEACE.findByFlagActiv", query = "SELECT g FROM GrupoBienSEACE g WHERE g.flagActiv = :flagActiv"),
    @NamedQuery(name = "GrupoBienSEACE.findByFlagSbn", query = "SELECT g FROM GrupoBienSEACE g WHERE g.flagSbn = :flagSbn"),
    @NamedQuery(name = "GrupoBienSEACE.findByEstado", query = "SELECT g FROM GrupoBienSEACE g WHERE g.estado = :estado")})
public class GrupoBienSEACE implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GrupoBienSEACEPK grupoBienSEACEPK;
    @Size(max = 500)
    @Column(name = "nombre_gru")
    private String nombreGru;
    @Size(max = 500)
    @Column(name = "alcance_gru")
    private String alcanceGru;
    @Column(name = "flag_activ")
    private Character flagActiv;
    @Column(name = "flag_sbn")
    private Character flagSbn;
    @Column(name = "estado")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoBienSEACE")
    private Collection<ClasebienSEACE> clasebienSEACECollection;

    public GrupoBienSEACE() {
    }

    public GrupoBienSEACE(GrupoBienSEACEPK grupoBienSEACEPK) {
        this.grupoBienSEACEPK = grupoBienSEACEPK;
    }

    public GrupoBienSEACE(Character tipoBien, String grupoBien) {
        this.grupoBienSEACEPK = new GrupoBienSEACEPK(tipoBien, grupoBien);
    }

    public GrupoBienSEACEPK getGrupoBienSEACEPK() {
        return grupoBienSEACEPK;
    }

    public void setGrupoBienSEACEPK(GrupoBienSEACEPK grupoBienSEACEPK) {
        this.grupoBienSEACEPK = grupoBienSEACEPK;
    }

    public String getNombreGru() {
        return nombreGru;
    }

    public void setNombreGru(String nombreGru) {
        this.nombreGru = nombreGru;
    }

    public String getAlcanceGru() {
        return alcanceGru;
    }

    public void setAlcanceGru(String alcanceGru) {
        this.alcanceGru = alcanceGru;
    }

    public Character getFlagActiv() {
        return flagActiv;
    }

    public void setFlagActiv(Character flagActiv) {
        this.flagActiv = flagActiv;
    }

    public Character getFlagSbn() {
        return flagSbn;
    }

    public void setFlagSbn(Character flagSbn) {
        this.flagSbn = flagSbn;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<ClasebienSEACE> getClasebienSEACECollection() {
        return clasebienSEACECollection;
    }

    public void setClasebienSEACECollection(Collection<ClasebienSEACE> clasebienSEACECollection) {
        this.clasebienSEACECollection = clasebienSEACECollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupoBienSEACEPK != null ? grupoBienSEACEPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoBienSEACE)) {
            return false;
        }
        GrupoBienSEACE other = (GrupoBienSEACE) object;
        if ((this.grupoBienSEACEPK == null && other.grupoBienSEACEPK != null) || (this.grupoBienSEACEPK != null && !this.grupoBienSEACEPK.equals(other.grupoBienSEACEPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.GrupoBienSEACE[ grupoBienSEACEPK=" + grupoBienSEACEPK + " ]";
    }
    
}
