/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "aps_ambito_acad")
public class ApsAmbitoAcad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_ambito")
    private Short idAmbito;
    @Column(name = "ambito")
    private String ambito;
    @Column(name = "fecha_insert")
    @Temporal(TemporalType.DATE)
    private Date fechaInsert;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @Column(name = "abr")
    private String abr;
    @OneToMany(mappedBy = "idAmbito")
    private List<ApsFacultadEfcap> apsFacultadEfcapList;
    @OneToMany(mappedBy = "idAmbito")
    private List<ApsEspecialidad> apsEspecialidadList;
    @OneToMany(mappedBy = "idAmbito")
    private List<ApsFacultad> apsFacultadList;
    @OneToMany(mappedBy = "idAmbito")
    private List<ApsAreaPost> apsAreaPostList;
    @OneToMany(mappedBy = "idAmbito")
    private List<ApsAreaElear> apsAreaElearList;

    public ApsAmbitoAcad() {
    }

    public ApsAmbitoAcad(Short idAmbito) {
        this.idAmbito = idAmbito;
    }

    public ApsAmbitoAcad(Short idAmbito, boolean estado) {
        this.idAmbito = idAmbito;
        this.estado = estado;
    }

    public Short getIdAmbito() {
        return idAmbito;
    }

    public void setIdAmbito(Short idAmbito) {
        this.idAmbito = idAmbito;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public Date getFechaInsert() {
        return fechaInsert;
    }

    public void setFechaInsert(Date fechaInsert) {
        this.fechaInsert = fechaInsert;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getAbr() {
        return abr;
    }

    public void setAbr(String abr) {
        this.abr = abr;
    }

    @XmlTransient
    public List<ApsFacultadEfcap> getApsFacultadEfcapList() {
        return apsFacultadEfcapList;
    }

    public void setApsFacultadEfcapList(List<ApsFacultadEfcap> apsFacultadEfcapList) {
        this.apsFacultadEfcapList = apsFacultadEfcapList;
    }

    @XmlTransient
    public List<ApsEspecialidad> getApsEspecialidadList() {
        return apsEspecialidadList;
    }

    public void setApsEspecialidadList(List<ApsEspecialidad> apsEspecialidadList) {
        this.apsEspecialidadList = apsEspecialidadList;
    }

    @XmlTransient
    public List<ApsFacultad> getApsFacultadList() {
        return apsFacultadList;
    }

    public void setApsFacultadList(List<ApsFacultad> apsFacultadList) {
        this.apsFacultadList = apsFacultadList;
    }

    @XmlTransient
    public List<ApsAreaPost> getApsAreaPostList() {
        return apsAreaPostList;
    }

    public void setApsAreaPostList(List<ApsAreaPost> apsAreaPostList) {
        this.apsAreaPostList = apsAreaPostList;
    }

    @XmlTransient
    public List<ApsAreaElear> getApsAreaElearList() {
        return apsAreaElearList;
    }

    public void setApsAreaElearList(List<ApsAreaElear> apsAreaElearList) {
        this.apsAreaElearList = apsAreaElearList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAmbito != null ? idAmbito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApsAmbitoAcad)) {
            return false;
        }
        ApsAmbitoAcad other = (ApsAmbitoAcad) object;
        if ((this.idAmbito == null && other.idAmbito != null) || (this.idAmbito != null && !this.idAmbito.equals(other.idAmbito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceda.jpa.ApsAmbitoAcad[ idAmbito=" + idAmbito + " ]";
    }
    
}
