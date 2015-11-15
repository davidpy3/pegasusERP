/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "sgc_acreditacion_dependencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgcAcreditacionDependencia.findAll", query = "SELECT s FROM SgcAcreditacionDependencia s"),
    @NamedQuery(name = "SgcAcreditacionDependencia.findByIdAsignacion", query = "SELECT s FROM SgcAcreditacionDependencia s WHERE s.idAsignacion = :idAsignacion"),
    @NamedQuery(name = "SgcAcreditacionDependencia.findByIdModelo", query = "SELECT s FROM SgcAcreditacionDependencia s WHERE s.idModelo = :idModelo"),
    @NamedQuery(name = "SgcAcreditacionDependencia.findByIdDependencia", query = "SELECT s FROM SgcAcreditacionDependencia s WHERE s.idDependencia = :idDependencia"),
    @NamedQuery(name = "SgcAcreditacionDependencia.findByIdFacultad", query = "SELECT s FROM SgcAcreditacionDependencia s WHERE s.idFacultad = :idFacultad"),
    @NamedQuery(name = "SgcAcreditacionDependencia.findByIdEscuela", query = "SELECT s FROM SgcAcreditacionDependencia s WHERE s.idEscuela = :idEscuela"),
    @NamedQuery(name = "SgcAcreditacionDependencia.findByIdEspecialidad", query = "SELECT s FROM SgcAcreditacionDependencia s WHERE s.idEspecialidad = :idEspecialidad")})
public class SgcAcreditacionDependencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_asignacion")
    private Integer idAsignacion;
    @Basic(optional = false)
    @Column(name = "id_modelo")
    private int idModelo;
    @Column(name = "id_dependencia")
    private Integer idDependencia;
    @Column(name = "id_facultad")
    private Integer idFacultad;
    @Column(name = "id_escuela")
    private Integer idEscuela;
    @Column(name = "id_especialidad")
    private Integer idEspecialidad;

    public SgcAcreditacionDependencia() {
    }

    public SgcAcreditacionDependencia(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public SgcAcreditacionDependencia(Integer idAsignacion, int idModelo) {
        this.idAsignacion = idAsignacion;
        this.idModelo = idModelo;
    }

    public Integer getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public Integer getIdDependencia() {
        return idDependencia;
    }

    public void setIdDependencia(Integer idDependencia) {
        this.idDependencia = idDependencia;
    }

    public Integer getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(Integer idFacultad) {
        this.idFacultad = idFacultad;
    }

    public Integer getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(Integer idEscuela) {
        this.idEscuela = idEscuela;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignacion != null ? idAsignacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcAcreditacionDependencia)) {
            return false;
        }
        SgcAcreditacionDependencia other = (SgcAcreditacionDependencia) object;
        if ((this.idAsignacion == null && other.idAsignacion != null) || (this.idAsignacion != null && !this.idAsignacion.equals(other.idAsignacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SgcAcreditacionDependencia[ idAsignacion=" + idAsignacion + " ]";
    }
    
}
