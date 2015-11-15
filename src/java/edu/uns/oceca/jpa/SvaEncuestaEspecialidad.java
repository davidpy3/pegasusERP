package edu.uns.oceca.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "sva_encuesta_especialidad")
public class SvaEncuestaEspecialidad implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Transient
    private List<QuizPregunta> preguntaList;

    public List<QuizPregunta> getPreguntaList() {
        return preguntaList;
    }

    public void setPreguntaList(List<QuizPregunta> concepto) {
        this.preguntaList = concepto;
    }
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_encuesta")
    private Integer idEncuesta;
    @Basic(optional = false)
    @Column(name = "id_autoevaluacion")
    private int idAutoevaluacion;
    @Basic(optional = false)
    @Column(name = "id_acper")
    private int idAcper;
    @Basic(optional = false)
    @Column(name = "id_especialidad")
    private int idEspecialidad;
    @Basic(optional = false)
    @Column(name = "id_modelo")
    private int idModelo;
    @Basic(optional = false)
    @Column(name = "id_cuestionario")
    private int idCuestionario;
    @Column(name = "fecha_ini")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIni;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @Column(name = "id_editor")
    private int idEditor;
    @Basic(optional = false)
    @Column(name = "id_creador")
    private int idCreador;
    @Basic(optional = false)
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @Column(name = "fecha_reg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReg;
    @Basic(optional = false)
    @Column(name = "estado")
    private Character estado;

    public SvaEncuestaEspecialidad() {
    }

    public SvaEncuestaEspecialidad(Integer idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public Integer getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(Integer idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public int getIdAutoevaluacion() {
        return idAutoevaluacion;
    }

    public void setIdAutoevaluacion(int idAutoevaluacion) {
        this.idAutoevaluacion = idAutoevaluacion;
    }

    public int getIdAcper() {
        return idAcper;
    }

    public void setIdAcper(int idAcper) {
        this.idAcper = idAcper;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public int getIdCuestionario() {
        return idCuestionario;
    }

    public void setIdCuestionario(int idCuestionario) {
        this.idCuestionario = idCuestionario;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getIdEditor() {
        return idEditor;
    }

    public void setIdEditor(int idEditor) {
        this.idEditor = idEditor;
    }

    public int getIdCreador() {
        return idCreador;
    }

    public void setIdCreador(int idCreador) {
        this.idCreador = idCreador;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEncuesta != null ? idEncuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SvaEncuestaEspecialidad)) {
            return false;
        }
        SvaEncuestaEspecialidad other = (SvaEncuestaEspecialidad) object;
        if ((this.idEncuesta == null && other.idEncuesta != null) || (this.idEncuesta != null && !this.idEncuesta.equals(other.idEncuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SvaEncuestaEspecialidad[ idEncuesta=" + idEncuesta + " ]";
    }
    
}
