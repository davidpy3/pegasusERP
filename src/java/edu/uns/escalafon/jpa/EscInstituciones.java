/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "esc_instituciones")
public class EscInstituciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_inst")
    private Integer idInst;
    @Column(name = "nombre_inst")
    private String nombreInst;
    @Column(name = "ruc")
    private String ruc;
    @Column(name = "pais")
    private String pais;
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "sector")
    private String sector;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "escInstituciones")
    private List<EscEstudio> escEstudioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInst")
    private List<EscCapacitacion> escCapacitacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInst")
    private List<EscCargoInstitucional> escCargoInstitucionalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInst")
    private List<EscParticComunidad> escParticComunidadList;

    public EscInstituciones() {
    }

    public EscInstituciones(Integer idInst) {
        this.idInst = idInst;
    }

    public Integer getIdInst() {
        return idInst;
    }

    public void setIdInst(Integer idInst) {
        this.idInst = idInst;
    }

    public String getNombreInst() {
        return nombreInst;
    }

    public void setNombreInst(String nombreInst) {
        this.nombreInst = nombreInst;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    @XmlTransient
    public List<EscEstudio> getEscEstudioList() {
        return escEstudioList;
    }

    public void setEscEstudioList(List<EscEstudio> escEstudioList) {
        this.escEstudioList = escEstudioList;
    }

    @XmlTransient
    public List<EscCapacitacion> getEscCapacitacionList() {
        return escCapacitacionList;
    }

    public void setEscCapacitacionList(List<EscCapacitacion> escCapacitacionList) {
        this.escCapacitacionList = escCapacitacionList;
    }

    @XmlTransient
    public List<EscCargoInstitucional> getEscCargoInstitucionalList() {
        return escCargoInstitucionalList;
    }

    public void setEscCargoInstitucionalList(List<EscCargoInstitucional> escCargoInstitucionalList) {
        this.escCargoInstitucionalList = escCargoInstitucionalList;
    }

    @XmlTransient
    public List<EscParticComunidad> getEscParticComunidadList() {
        return escParticComunidadList;
    }

    public void setEscParticComunidadList(List<EscParticComunidad> escParticComunidadList) {
        this.escParticComunidadList = escParticComunidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInst != null ? idInst.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscInstituciones)) {
            return false;
        }
        EscInstituciones other = (EscInstituciones) object;
        if ((this.idInst == null && other.idInst != null) || (this.idInst != null && !this.idInst.equals(other.idInst))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscInstituciones[ idInst=" + idInst + " ]";
    }
    
}
