/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "familia_bien_SEACE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FamiliabienSEACE.findAll", query = "SELECT f FROM FamiliabienSEACE f"),
    @NamedQuery(name = "FamiliabienSEACE.findByTipoBien", query = "SELECT f FROM FamiliabienSEACE f WHERE f.familiabienSEACEPK.tipoBien = :tipoBien"),
    @NamedQuery(name = "FamiliabienSEACE.findByGrupoBien", query = "SELECT f FROM FamiliabienSEACE f WHERE f.familiabienSEACEPK.grupoBien = :grupoBien"),
    @NamedQuery(name = "FamiliabienSEACE.findByClaseBien", query = "SELECT f FROM FamiliabienSEACE f WHERE f.familiabienSEACEPK.claseBien = :claseBien"),
    @NamedQuery(name = "FamiliabienSEACE.findByFamiliaBien", query = "SELECT f FROM FamiliabienSEACE f WHERE f.familiabienSEACEPK.familiaBien = :familiaBien"),
    @NamedQuery(name = "FamiliabienSEACE.findByNombreFam", query = "SELECT f FROM FamiliabienSEACE f WHERE f.nombreFam = :nombreFam"),
    @NamedQuery(name = "FamiliabienSEACE.findByAlcanceFam", query = "SELECT f FROM FamiliabienSEACE f WHERE f.alcanceFam = :alcanceFam"),
    @NamedQuery(name = "FamiliabienSEACE.findByFlagActiv", query = "SELECT f FROM FamiliabienSEACE f WHERE f.flagActiv = :flagActiv"),
    @NamedQuery(name = "FamiliabienSEACE.findByFlagSbn", query = "SELECT f FROM FamiliabienSEACE f WHERE f.flagSbn = :flagSbn"),
    @NamedQuery(name = "FamiliabienSEACE.findByEstado", query = "SELECT f FROM FamiliabienSEACE f WHERE f.estado = :estado")})
public class FamiliabienSEACE implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FamiliabienSEACEPK familiabienSEACEPK;
    @Size(max = 1000)
    @Column(name = "nombre_fam")
    private String nombreFam;
    @Size(max = 1000)
    @Column(name = "alcance_fam")
    private String alcanceFam;
    @Column(name = "flag_activ")
    private Character flagActiv;
    @Column(name = "flag_sbn")
    private Character flagSbn;
    @Column(name = "estado")
    private Character estado;
    @JoinColumns({
        @JoinColumn(name = "tipo_bien", referencedColumnName = "tipo_bien", insertable = false, updatable = false),
        @JoinColumn(name = "grupo_bien", referencedColumnName = "grupo_bien", insertable = false, updatable = false),
        @JoinColumn(name = "clase_bien", referencedColumnName = "clase_bien", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private ClasebienSEACE clasebienSEACE;

    public FamiliabienSEACE() {
    }

    public FamiliabienSEACE(FamiliabienSEACEPK familiabienSEACEPK) {
        this.familiabienSEACEPK = familiabienSEACEPK;
    }

    public FamiliabienSEACE(Character tipoBien, String grupoBien, String claseBien, String familiaBien) {
        this.familiabienSEACEPK = new FamiliabienSEACEPK(tipoBien, grupoBien, claseBien, familiaBien);
    }

    public FamiliabienSEACEPK getFamiliabienSEACEPK() {
        return familiabienSEACEPK;
    }

    public void setFamiliabienSEACEPK(FamiliabienSEACEPK familiabienSEACEPK) {
        this.familiabienSEACEPK = familiabienSEACEPK;
    }

    public String getNombreFam() {
        return nombreFam;
    }

    public void setNombreFam(String nombreFam) {
        this.nombreFam = nombreFam;
    }

    public String getAlcanceFam() {
        return alcanceFam;
    }

    public void setAlcanceFam(String alcanceFam) {
        this.alcanceFam = alcanceFam;
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

    public ClasebienSEACE getClasebienSEACE() {
        return clasebienSEACE;
    }

    public void setClasebienSEACE(ClasebienSEACE clasebienSEACE) {
        this.clasebienSEACE = clasebienSEACE;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (familiabienSEACEPK != null ? familiabienSEACEPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FamiliabienSEACE)) {
            return false;
        }
        FamiliabienSEACE other = (FamiliabienSEACE) object;
        if ((this.familiabienSEACEPK == null && other.familiabienSEACEPK != null) || (this.familiabienSEACEPK != null && !this.familiabienSEACEPK.equals(other.familiabienSEACEPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.FamiliabienSEACE[ familiabienSEACEPK=" + familiabienSEACEPK + " ]";
    }
    
}
