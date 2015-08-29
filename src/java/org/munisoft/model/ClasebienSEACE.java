/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "clase_bien_SEACE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClasebienSEACE.findAll", query = "SELECT c FROM ClasebienSEACE c"),
    @NamedQuery(name = "ClasebienSEACE.findByTipoBien", query = "SELECT c FROM ClasebienSEACE c WHERE c.clasebienSEACEPK.tipoBien = :tipoBien"),
    @NamedQuery(name = "ClasebienSEACE.findByGrupoBien", query = "SELECT c FROM ClasebienSEACE c WHERE c.clasebienSEACEPK.grupoBien = :grupoBien"),
    @NamedQuery(name = "ClasebienSEACE.findByClaseBien", query = "SELECT c FROM ClasebienSEACE c WHERE c.clasebienSEACEPK.claseBien = :claseBien"),
    @NamedQuery(name = "ClasebienSEACE.findByNombreCla", query = "SELECT c FROM ClasebienSEACE c WHERE c.nombreCla = :nombreCla"),
    @NamedQuery(name = "ClasebienSEACE.findByAlcanceCla", query = "SELECT c FROM ClasebienSEACE c WHERE c.alcanceCla = :alcanceCla"),
    @NamedQuery(name = "ClasebienSEACE.findByFlagActiv", query = "SELECT c FROM ClasebienSEACE c WHERE c.flagActiv = :flagActiv"),
    @NamedQuery(name = "ClasebienSEACE.findByFlagSbn", query = "SELECT c FROM ClasebienSEACE c WHERE c.flagSbn = :flagSbn"),
    @NamedQuery(name = "ClasebienSEACE.findByEstado", query = "SELECT c FROM ClasebienSEACE c WHERE c.estado = :estado")})
public class ClasebienSEACE implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClasebienSEACEPK clasebienSEACEPK;
    @Size(max = 1000)
    @Column(name = "nombre_cla")
    private String nombreCla;
    @Size(max = 1000)
    @Column(name = "alcance_cla")
    private String alcanceCla;
    @Column(name = "flag_activ")
    private Character flagActiv;
    @Column(name = "flag_sbn")
    private Character flagSbn;
    @Column(name = "estado")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clasebienSEACE")
    private Collection<FamiliabienSEACE> familiabienSEACECollection;
    @JoinColumns({
        @JoinColumn(name = "tipo_bien", referencedColumnName = "tipo_bien", insertable = false, updatable = false),
        @JoinColumn(name = "grupo_bien", referencedColumnName = "grupo_bien", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private GrupoBienSEACE grupoBienSEACE;

    public ClasebienSEACE() {
    }

    public ClasebienSEACE(ClasebienSEACEPK clasebienSEACEPK) {
        this.clasebienSEACEPK = clasebienSEACEPK;
    }

    public ClasebienSEACE(Character tipoBien, String grupoBien, String claseBien) {
        this.clasebienSEACEPK = new ClasebienSEACEPK(tipoBien, grupoBien, claseBien);
    }

    public ClasebienSEACEPK getClasebienSEACEPK() {
        return clasebienSEACEPK;
    }

    public void setClasebienSEACEPK(ClasebienSEACEPK clasebienSEACEPK) {
        this.clasebienSEACEPK = clasebienSEACEPK;
    }

    public String getNombreCla() {
        return nombreCla;
    }

    public void setNombreCla(String nombreCla) {
        this.nombreCla = nombreCla;
    }

    public String getAlcanceCla() {
        return alcanceCla;
    }

    public void setAlcanceCla(String alcanceCla) {
        this.alcanceCla = alcanceCla;
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
    public Collection<FamiliabienSEACE> getFamiliabienSEACECollection() {
        return familiabienSEACECollection;
    }

    public void setFamiliabienSEACECollection(Collection<FamiliabienSEACE> familiabienSEACECollection) {
        this.familiabienSEACECollection = familiabienSEACECollection;
    }

    public GrupoBienSEACE getGrupoBienSEACE() {
        return grupoBienSEACE;
    }

    public void setGrupoBienSEACE(GrupoBienSEACE grupoBienSEACE) {
        this.grupoBienSEACE = grupoBienSEACE;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clasebienSEACEPK != null ? clasebienSEACEPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClasebienSEACE)) {
            return false;
        }
        ClasebienSEACE other = (ClasebienSEACE) object;
        if ((this.clasebienSEACEPK == null && other.clasebienSEACEPK != null) || (this.clasebienSEACEPK != null && !this.clasebienSEACEPK.equals(other.clasebienSEACEPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.ClasebienSEACE[ clasebienSEACEPK=" + clasebienSEACEPK + " ]";
    }
    
}
