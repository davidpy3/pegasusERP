/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "aps_escuela_efcap")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApsEscuelaEfcap.findAll", query = "SELECT a FROM ApsEscuelaEfcap a"),
    @NamedQuery(name = "ApsEscuelaEfcap.findByIdEscuela", query = "SELECT a FROM ApsEscuelaEfcap a WHERE a.idEscuela = :idEscuela"),
    @NamedQuery(name = "ApsEscuelaEfcap.findByCodEap", query = "SELECT a FROM ApsEscuelaEfcap a WHERE a.codEap = :codEap"),
    @NamedQuery(name = "ApsEscuelaEfcap.findByNombre", query = "SELECT a FROM ApsEscuelaEfcap a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "ApsEscuelaEfcap.findByAbr", query = "SELECT a FROM ApsEscuelaEfcap a WHERE a.abr = :abr"),
    @NamedQuery(name = "ApsEscuelaEfcap.findByEstado", query = "SELECT a FROM ApsEscuelaEfcap a WHERE a.estado = :estado")})
public class ApsEscuelaEfcap implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_escuela")
    private Integer idEscuela;
    @Column(name = "cod_eap")
    private String codEap;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "abr")
    private String abr;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @JoinTable(name = "aps_especialidad_efcap", joinColumns = {
        @JoinColumn(name = "id_escuela", referencedColumnName = "id_escuela")}, inverseJoinColumns = {
        @JoinColumn(name = "id_especialidad", referencedColumnName = "id_especialidad")})
    @ManyToMany
    private List<ApsEspecialidad> apsEspecialidadList;
    @JoinColumn(name = "id_facultad", referencedColumnName = "id_facultad")
    @ManyToOne
    private ApsFacultadEfcap idFacultad;

    public ApsEscuelaEfcap() {
    }

    public ApsEscuelaEfcap(Integer idEscuela) {
        this.idEscuela = idEscuela;
    }

    public ApsEscuelaEfcap(Integer idEscuela, boolean estado) {
        this.idEscuela = idEscuela;
        this.estado = estado;
    }

    public Integer getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(Integer idEscuela) {
        this.idEscuela = idEscuela;
    }

    public String getCodEap() {
        return codEap;
    }

    public void setCodEap(String codEap) {
        this.codEap = codEap;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbr() {
        return abr;
    }

    public void setAbr(String abr) {
        this.abr = abr;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<ApsEspecialidad> getApsEspecialidadList() {
        return apsEspecialidadList;
    }

    public void setApsEspecialidadList(List<ApsEspecialidad> apsEspecialidadList) {
        this.apsEspecialidadList = apsEspecialidadList;
    }

    public ApsFacultadEfcap getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(ApsFacultadEfcap idFacultad) {
        this.idFacultad = idFacultad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEscuela != null ? idEscuela.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApsEscuelaEfcap)) {
            return false;
        }
        ApsEscuelaEfcap other = (ApsEscuelaEfcap) object;
        if ((this.idEscuela == null && other.idEscuela != null) || (this.idEscuela != null && !this.idEscuela.equals(other.idEscuela))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceda.jpa.ApsEscuelaEfcap[ idEscuela=" + idEscuela + " ]";
    }
    
}
