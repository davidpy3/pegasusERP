/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "sva_evaluacion_docente_participacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SvaEvaluacionDocenteParticipacion.findAll", query = "SELECT s FROM SvaEvaluacionDocenteParticipacion s"),
    @NamedQuery(name = "SvaEvaluacionDocenteParticipacion.findByIdParticipacion", query = "SELECT s FROM SvaEvaluacionDocenteParticipacion s WHERE s.idParticipacion = :idParticipacion"),
    @NamedQuery(name = "SvaEvaluacionDocenteParticipacion.findByIdEncuesta", query = "SELECT s FROM SvaEvaluacionDocenteParticipacion s WHERE s.idEncuesta = :idEncuesta"),
    @NamedQuery(name = "SvaEvaluacionDocenteParticipacion.findByIdDir", query = "SELECT s FROM SvaEvaluacionDocenteParticipacion s WHERE s.idDir = :idDir"),
    @NamedQuery(name = "SvaEvaluacionDocenteParticipacion.findByIdAsignatura", query = "SELECT s FROM SvaEvaluacionDocenteParticipacion s WHERE s.idAsignatura = :idAsignatura"),
    @NamedQuery(name = "SvaEvaluacionDocenteParticipacion.findByIdDocente", query = "SELECT s FROM SvaEvaluacionDocenteParticipacion s WHERE s.idDocente = :idDocente"),
    @NamedQuery(name = "SvaEvaluacionDocenteParticipacion.findByPuntaje", query = "SELECT s FROM SvaEvaluacionDocenteParticipacion s WHERE s.puntaje = :puntaje"),
    @NamedQuery(name = "SvaEvaluacionDocenteParticipacion.findByCerrado", query = "SELECT s FROM SvaEvaluacionDocenteParticipacion s WHERE s.cerrado = :cerrado"),
    @NamedQuery(name = "SvaEvaluacionDocenteParticipacion.findByFechaCierre", query = "SELECT s FROM SvaEvaluacionDocenteParticipacion s WHERE s.fechaCierre = :fechaCierre"),
    @NamedQuery(name = "SvaEvaluacionDocenteParticipacion.findByFechaReg", query = "SELECT s FROM SvaEvaluacionDocenteParticipacion s WHERE s.fechaReg = :fechaReg")})
public class SvaEvaluacionDocenteParticipacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_participacion")
    private Integer idParticipacion;
    @Basic(optional = false)
    @Column(name = "id_encuesta")
    private int idEncuesta;
    @Basic(optional = false)
    @Column(name = "id_dir")
    private int idDir;
    @Basic(optional = false)
    @Column(name = "id_asignatura")
    private int idAsignatura;
    @Basic(optional = false)
    @Column(name = "id_docente")
    private int idDocente;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "puntaje")
    private Double puntaje;
    @Basic(optional = false)
    @Column(name = "cerrado")
    private short cerrado;
    @Column(name = "fecha_cierre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCierre;
    @Basic(optional = false)
    @Column(name = "fecha_reg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReg;

    public SvaEvaluacionDocenteParticipacion() {
    }

    public SvaEvaluacionDocenteParticipacion(Integer idParticipacion) {
        this.idParticipacion = idParticipacion;
    }

    public SvaEvaluacionDocenteParticipacion(Integer idParticipacion, int idEncuesta, int idDir, int idAsignatura, int idDocente, short cerrado, Date fechaReg) {
        this.idParticipacion = idParticipacion;
        this.idEncuesta = idEncuesta;
        this.idDir = idDir;
        this.idAsignatura = idAsignatura;
        this.idDocente = idDocente;
        this.cerrado = cerrado;
        this.fechaReg = fechaReg;
    }

    public Integer getIdParticipacion() {
        return idParticipacion;
    }

    public void setIdParticipacion(Integer idParticipacion) {
        this.idParticipacion = idParticipacion;
    }

    public int getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(int idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public int getIdDir() {
        return idDir;
    }

    public void setIdDir(int idDir) {
        this.idDir = idDir;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public Double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Double puntaje) {
        this.puntaje = puntaje;
    }

    public short getCerrado() {
        return cerrado;
    }

    public void setCerrado(short cerrado) {
        this.cerrado = cerrado;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParticipacion != null ? idParticipacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SvaEvaluacionDocenteParticipacion)) {
            return false;
        }
        SvaEvaluacionDocenteParticipacion other = (SvaEvaluacionDocenteParticipacion) object;
        if ((this.idParticipacion == null && other.idParticipacion != null) || (this.idParticipacion != null && !this.idParticipacion.equals(other.idParticipacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SvaEvaluacionDocenteParticipacion[ idParticipacion=" + idParticipacion + " ]";
    }
    
}
